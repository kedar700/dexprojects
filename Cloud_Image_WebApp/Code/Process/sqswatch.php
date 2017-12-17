<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<head>
  <title>Gallery</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="refresh" content="15">
<h2 class="text-center custom icm-size">Welcome to Kedar's SQS Watch</h1>

<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/fonstola.ru-72345.jpg">
<div class="container">
<div class="row">
<br>
<br>

<?php
session_start();
require 'vendor/autoload.php';

$sqs = new Aws\Sqs\SqsClient([
    'version' => 'latest',
    'region'  => 'us-west-2'
]);

#list the SQS Queue URL
$listQueueresult = $sqs->listQueues([
    
]);
//print_r($listQueueresult);

echo "Your SQS URL is: " . $listQueueresult['QueueUrls'][0] . "\n";
$queueurl = $listQueueresult['QueueUrls'][0];

$result = $sqs->getQueueAttributes([
    'AttributeNames' => ['ApproximateNumberOfMessages'],
    'QueueUrl' =>$queueurl , // REQUIRED
]);

//print_r($result);
echo "Number of Messages in the queue are : " . $result['Attributes']['ApproximateNumberOfMessages'] . "\n";
$messages=$result['Attributes']['ApproximateNumberOfMessages'];

echo "<table class='table table-bordered'>
        <thead>
            <tr>
                <th>Number of Messages</th>
                <th>Jobs</th>
            </tr>
        </thead>
        <tbody> ";
    echo "<tr>";
    echo "<th scope='row'>" . $messages . "</th>";
    echo "<td>0</td>";
    echo "</tr>";
echo "</tbody>
      </table>";
?>                      
</div>
</div>
</body>
</html>


