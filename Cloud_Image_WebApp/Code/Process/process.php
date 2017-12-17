<?php
require 'vendor/autoload.php';

$sqs = new Aws\Sqs\SqsClient([
    'version' => 'latest',
    'region'  => 'us-west-2'
]);

$listQueueresult = $sqs->listQueues([
    
]);

echo "Your SQS URL is: " . $listQueueresult['QueueUrls'][0] . "\n";
$queueurl = $listQueueresult['QueueUrls'][0];


$receivemessageresult = $sqs->receiveMessage([
    'MaxNumberOfMessages' => 1,
    'QueueUrl' => $queueurl, 
    'VisibilityTimeout' => 60,
    'WaitTimeSeconds' => 5,
]);

$receiptHandle = $receivemessageresult['Messages'][0]['ReceiptHandle'];
$uuid = $receivemessageresult['Messages'][0]['Body'] . "\n";
echo "The content of the message is: " . $receivemessageresult['Messages'][0]['Body'] . "\n";

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

$link->real_query("SELECT s3rawurl FROM records where id='$uuid'");
$res = $link->use_result();
$row = $res->fetch_assoc();
$url= $row['s3rawurl'];

echo $url;
$link->close();

use Aws\S3\S3Client;
$uploaddir = '/tmp/';
$uploadfile = tempnam('/tmp', 'upload_');

$s3 = new Aws\S3\S3Client([
    'version' => 'latest',
    'region'  => 'us-west-2'
]);

$checkingformat = substr($url,-3);

if($checkingformat == 'png' || $checkingformat == 'PNG'){
    $image_raw=imagecreatefrompng($url);
}
else{
    $image_raw = imagecreatefromjpeg($url);
}
if($image_raw && imagefilter($image_raw, IMG_FILTER_GRAYSCALE))
{
    imagepng($image_raw, $uploadfile);
}
else
{
    echo 'Conversion to grayscale failed.';
}

// $imagemagick = new Imagick($url);
// $imagemagick->readImageFile($handle);
// $imagemagick->thumbnailImage(200,200);
// $imagemagick->writeImage($uploadfile.'.png');

$imagickbucket = 'kedarbktafter';

$result = $s3->putObject([
    'ACL' => 'public-read',
    'Bucket' => $imagickbucket,
    'Key' => basename($uploadfile.'.png'),
    'SourceFile' => $uploadfile
]);

$imagickurl = $result['ObjectURL'];

# Update your Database record using the UPDATE and the $uuid as the search term  

//echo "begin database";
$link = mysqli_connect($endpoint,"muser","544miniproject","miniproject",3306) or die("Error " . mysqli_error($link));
/* check connection */
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}
// Prepared statement, stage 1: prepare

if (!($stmt = $link->prepare("UPDATE records SET s3finishedurl='$imagickurl' WHERE id='$uuid'"))) {
	echo "Prepare failed: (" . $link->errno . ") " . $link->error;
}

if (!$stmt->execute()) {
    echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;
}
printf("%d Row sucessfully inserted into database.\n", $stmt->affected_rows);

#  * change status from 0 to 1 (done)
if (!($stmt1 = $link->prepare("UPDATE records SET status='1' WHERE id='$uuid'"))) {
	echo "Prepare failed: (" . $link->errno . ") " . $link->error;
}
if (!$stmt1->execute()) {
    echo "Execute failed: (" . $stmt1->errno . ") " . $stmt1->error;
}
printf("%d Status changed to 1 sucessfully \n", $stmt1->affected_rows);

# SNS would then send your user a text with the finsihed URL 

$sns = new Aws\Sns\SnsClient([
    'version' => 'latest',
    'region' => 'us-west-2' //regionus0west-2
]);


//creating variable to store the list of Topic arn
$resultns= $sns->listTopics([

]);

print_r($resultns['Topics']);
$topicarn=($resultns['Topics'][0]['TopicArn']);
echo "Your Topic Arn: . $topicarn";

//PUBLISH
$result = $sns->publish
([
	'Subject' => 'Picture uploaded in S3 bucket',
	'Message' => 'Congratulations!! You sucessfully subscribed.', // REQUIRED
	'TopicArn' => $topicarn,
]);

/* explicit close recommended */
$stmt->close();
# delete consumed message

$deletemessageresult = $sqs->deleteMessage([
    'QueueUrl' => $queueurl, // REQUIRED
    'ReceiptHandle' => $receiptHandle, // REQUIRED
]);

# Send message

?>