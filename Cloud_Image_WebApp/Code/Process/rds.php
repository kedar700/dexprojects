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
<h2 class="text-center custom icm-size">Welcome to Kedar's RDS Watch</h1>

<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/fonstola.ru-72345.jpg">
<div class="container">
<div class="row">
<br>
<br>

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
echo "<table class='table table-bordered'>
        <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email Address</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody> ";
$link->real_query("SELECT id,uname,status,email FROM records");
$res = $link->use_result();
while ($row = $res->fetch_assoc()) {
    echo "<tr>";
    echo "<th scope='row'>" . $row['id'] . "</th>";
    echo "<td>" . $row['uname'] . "</td>";
    echo "<td>" . $row['email'] . "</td>";
    echo "<td>" . $row['status'] . "</td>";
    echo "</tr>";
}
echo "</tbody>
      </table>";
$link->close();
?>                      
</div>
</div>
</body>
</html>


