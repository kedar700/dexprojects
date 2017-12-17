<?php 
session_start(); 
ob_start();
?>

<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<head>
  <title>Kedar submitted</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<h1 class="text-center">Check if submitted</h1>
</head>
<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/fonstola.ru-72345.jpg">

<?php
require 'vendor/autoload.php';
use Aws\S3\S3Client;
use Aws\Sns\SnsClient;
use Imagick;
$uploaddir = '/tmp/';
$uploadfile = $uploaddir . basename($_FILES['userfile']['name']);
 
echo '<pre>';
if (move_uploaded_file($_FILES['userfile']['tmp_name'], $uploadfile)) 
	{
		echo "File is valid, and was successfully uploaded.\n";
	} 
	else 
	{
		echo "Possible file upload attack!\n";
	}
print "</pre>";
 

$s3 = new Aws\S3\S3Client([
    'version' => 'latest',
    'region'  => 'us-west-2'
]);


$bucket='kedarbktbefore';


$result = $s3->putObject([
    'ACL' => 'public-read',
    'Bucket' => $bucket,
    'Key' =>  basename($_FILES['userfile']['name']),
    'SourceFile' => $uploadfile

]);

$url=$result['ObjectURL'];

echo "\n". "Your URL: " . $url ."\n";

echo"This is after s3 before object";


$sqs = new Aws\Sqs\SqsClient([
    'version' => 'latest',
    'region'  => 'us-west-2'
]);

// $sqsresult = $sqs->createQueue([
//     'Attributes' => [
//         'VisibilityTimeout' => '60'
//     ],
//     'QueueName' => 'knaik-sqs'
// ]);

#list the SQS Queue URL
$listQueueresult = $sqs->listQueues([
    
]);
# print out every thing
# print_r ($listQueueresult);  

echo "Your SQS URL is: " . $listQueueresult['QueueUrls'][0] . "\n";
$queueurl = $listQueueresult['QueueUrls'][0];

use Aws\Rds\RdsClient;
$rds = new Aws\Rds\RdsClient([
        'version' => 'latest',
        'region'  => 'us-west-2'
]);

$result = $rds->describeDBInstances([
        'DBInstanceIdentifier' => 'mp1-sb',
]);
$endpoint = "";
$endpoint = $result['DBInstances'][0]['Endpoint']['Address'];

//echo "begin database";
$link = mysqli_connect($endpoint,"muser","544miniproject","miniproject",3306) or die("Error " . mysqli_error($link));

/* check connection */
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}

// Prepared statement, stage 1: prepare
if (!($stmt = $link->prepare("INSERT INTO records (id,uname,email,phone,s3rawurl,s3finishedurl,status,receipt) VALUES (NULL,?,?,?,?,?,?,?)"))) {
	echo "Prepare failed: (" . $link->errno . ") " . $link->error;
}

$email = $_POST['useremail'];
$uname = $_POST['uname'];
$phone = $_POST['phone'];
$s3rawurl = $url; //  $result['ObjectURL']; from above
$filename = basename($_FILES['userfile']['name']);
$s3finishedurl = "";
$status =0;
$receipt=1;
$stmt->bind_param("ssssssi",$uname,$email,$phone,$s3rawurl,$s3finishedurl,$status,$receipt); // 6 strings & 1 integer ssssssi

if (!$stmt->execute()) {
    echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
}

printf("%d Row sucessfully inserted into database.\n", $stmt->affected_rows);

$link->real_query("SELECT id FROM records where s3rawurl = '$url'");
$res = $link->use_result();
while ($row = $res->fetch_object()) {
   $uuid = $row->id;
}

$link->close();

echo $uuid . '\n';

### send message to the SQS Queue
$sendmessageresult = $sqs->sendMessage([
    'DelaySeconds' => 30,
    'MessageBody' => $uuid, // REQUIRED
    'QueueUrl' => $queueurl // REQUIRED
]);

echo "The messageID is: ". $sendmessageresult['MessageId'] . "\n";

$sns = new Aws\Sns\SnsClient([
    'version' => 'latest',
    'region' => 'us-west-2' //regionus0west-2
]);


//creating variable to store the list of Topic arn
$result = $sns->listTopics([

]);

print_r($result['Topics']);
$topicarn=($result['Topics'][0]['TopicArn']);
echo "Your Topic Arn: . $topicarn";

//subscribing sns
$subscribe = $sns->subscribe([
    'Endpoint' => $email,
    'Protocol' => 'email',
    'TopicArn' => $topicarn, 
]);

sleep(20);

//PUBLISH
$result = $sns->publish
([
	'Subject' => 'Picture uploaded in S3 bucket',
	'Message' => 'Congratulations!! You sucessfully subscribed.', // REQUIRED
	'TopicArn' => $topicarn,
]);

/* explicit close recommended */
$stmt->close();
?>
</body>
</html>

<?php 
header('Location: index.php');
ob_end_flush();
?>