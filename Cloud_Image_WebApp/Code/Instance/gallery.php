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
<h2 class="text-center custom icm-size">Welcome to Kedar's Gallery</h1>

<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/sky-213848_1920.jpg">
<div class="container">
<div class="row">
<?php
session_start();
require 'vendor/autoload.php';

use Aws\Rds\RdsClient;
$rds = new Aws\Rds\RdsClient([
        'version' => 'latest',
        'region'  => 'us-west-2'
]);

$result = $rds->describeDBInstances([
        'DBInstanceIdentifier' => 'mp1-replica-db',
]);
$endpoint = "";
$endpoint = $result['DBInstances'][0]['Endpoint']['Address'];
#print "\n============\n" . $endpoint . "\n================\n";

//echo "begin database";
$link = mysqli_connect($endpoint,"muser","544miniproject","miniproject") or die("Error " . mysqli_error($link));

/* check connection */
if (mysqli_connect_errno()) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}

$link->real_query("SELECT * FROM records");
$res = $link->use_result();
while ($row = $res->fetch_assoc()) {
    echo "<div class='col-xs-6'>" . "<h2>GreyScale:</h2> " . "<br/>" . "<img src =\" " . $row['s3finishedurl'] . "\"/>"."</div>";		
	echo "<div class='col-xs-6'>" . "<h2>Raw-Image:</h2> " . "<br/>" . "<img src =\" " . $row['s3rawurl'] . "\"/>"."</div>";		
}

$link->close();
?>                      
</div>
</div>
</body>
</html>


