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
<h2 class="text-center custom icm-size">Welcome to Kedar's Cloud Watch</h1>

<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/sky-213848_1920.jpg">
<div class="container">
<div class="row">
<br>
<br>

<?php
session_start();
require 'vendor/autoload.php';

$cw = new Aws\CloudWatch\CloudWatchClient([
    'version' => 'latest',
    'region'  => 'us-west-2'
]);
$cpu = $cw->getMetricStatistics([
  'Dimensions' => [
      [
        'Name' => 'InstanceId',
        'Value' => 'i-06bb870fb26cd1d53'
      ],
    ],
    'EndTime' => strtotime('now'), 
    'MetricName' => 'CPUUtilization', 
    'Namespace' => 'AWS/EC2', 
    'Period' => 60, 
    'StartTime' => strtotime('-15 minutes'), 
    'Statistics' => ['Maximum','Minimum'],
]);

echo "<h3>CPU Utilization Metrics</h3>
    <table class='table table-bordered'>
        <thead>
            <tr>
                <th>Maximum Utilized Percent</th>
                <th>Minimum Utilized Percent</th>
            </tr>
        </thead>
        <tbody> ";
    foreach($cpu['Datapoints'] as $row){
        echo "<tr>";
        echo "<th scope='row'>".$row['Maximum']."</th>";
        echo "<td>".$row['Minimum']."</td>";
        echo "</tr>";
    }
echo "</tbody>
      </table>";
echo("<br>");

$readresult = $cw->getMetricStatistics([
    'Dimensions' => [
        [
          'Name' => 'InstanceId',
          'Value' => 'i-06bb870fb26cd1d53'
        ],
      ],
      'EndTime' => strtotime('now'),
      'MetricName' => 'DiskReadBytes', 
      'Namespace' => 'AWS/EC2', 
      'Period' => 60, 
      'StartTime' => strtotime('-5 minutes'),
      'Statistics' => ['Average'],
      'Unit' => 'Bytes',
  ]);

echo "<h3>Disk ReadBytes Metrics</h3>
      <table class='table table-bordered'>
          <thead>
              <tr>
                  <th>ReadBytes Average</th>
              </tr>
          </thead>
          <tbody> ";
      foreach ($readresult['Datapoints'] as $row1 ){
        echo "<tr>";
        echo "<th scope='row'>".$row1['Average']."</th>";
        echo "</tr>";
      }
  echo "</tbody>
        </table>";
echo("<br>");

$writeOps = $cw->getMetricStatistics([
    'Dimensions' => [
        [
          'Name' => 'InstanceId',
          'Value' => 'i-06bb870fb26cd1d53'
        ],
      ],
      'EndTime' => strtotime('now'),
      'MetricName' => 'DiskWriteOps', 
      'Namespace' => 'AWS/EC2', 
      'Period' => 60, 
      'StartTime' => strtotime('-1 days'), 
      'Statistics' => ['Maximum','Minimum'],
  ]);
  

 echo "<h3>Disk WriteOps Metrics</h3>
        <table class='table table-bordered'>
            <thead>
                <tr>
                    <th>Maximum Utilized Percent</th>
                    <th>Minimum Utilized Percent</th>
                </tr>
            </thead>
            <tbody> ";
            foreach($writeOps['Datapoints'] as $row2){
                echo "<tr>";
                echo "<th scope='row'>".$row2['Maximum']."</th>";
                echo "<td>".$row2['Minimum']."</td>";
                echo "</tr>";
            }
    echo "</tbody>
          </table>";
echo("<br>");

$writeBytes = $cw->getMetricStatistics([
    'Dimensions' => [
        [
          'Name' => 'InstanceId',
          'Value' => 'i-06bb870fb26cd1d53'
        ],
      ],
      'EndTime' => strtotime('now'), 
      'MetricName' => 'DiskWriteBytes', 
      'Namespace' => 'AWS/EC2',
      'Period' => 60, 
      'StartTime' => strtotime('-1 days'), 
      'Statistics' => ['Average'],
      'Unit' => 'Bytes',
  ]);
  

echo "<h3>Disk WriteBytes Metrics</h3>
          <table class='table table-bordered'>
              <thead>
                  <tr>
                      <th>WriteBytes Count</th>
                  </tr>
              </thead>
              <tbody> ";
              foreach ($writeBytes['Datapoints'] as $row3 ){
                echo "<tr>";
                echo "<th scope='row'>".$row3['Average']."</th>";
                echo "</tr>";
              }
      echo "</tbody>
            </table>";

echo("<br>");
$networking = $cw->getMetricStatistics([
    'Dimensions' => [
        [
          'Name' => 'InstanceId',
          'Value' => 'i-06bb870fb26cd1d53'
        ],
      ],
      'EndTime' => strtotime('now'), 
      'MetricName' => 'NetworkIn', 
      'Namespace' => 'AWS/EC2', 
      'Period' => 60, 
      'StartTime' => strtotime('-1 days'),
      'Statistics' => ['Minimum','Maximum'],
      'Unit' => 'Bytes',
  ]);
  
echo "<h3>NetworkIn Metrics</h3>
            <table class='table table-bordered'>
                <thead>
                    <tr>
                        <th>Maximum Utilized Bytes</th>
                        <th>Minimum Utilized Bytes</th>
                    </tr>
                </thead>
                <tbody> ";
        foreach($networking['Datapoints'] as $row4){
            echo "<tr>";
            echo "<th scope='row'>".$row4['Maximum']."</th>";
            echo "<td>".$row4['Minimum']."</td>";
            echo "</tr>";
                }
        echo "</tbody>
              </table>";
echo("<br>");

$readOps = $cw->getMetricStatistics([
    'Dimensions' => [
        [
          'Name' => 'InstanceId',
          'Value' => 'i-06bb870fb26cd1d53'
        ],
      ],
      'EndTime' => strtotime('now'),
      'MetricName' => 'DiskReadOps', 
      'Namespace' => 'AWS/EC2', 
      'Period' => 60, 
      'StartTime' => strtotime('-1 days'), 
      'Statistics' => ['Maximum','Minimum'],
  ]);

  echo "<h3>Disk ReadOps Metrics</h3>
  <table class='table table-bordered'>
      <thead>
          <tr>
              <th>Maximum Utilized Percent</th>
              <th>Minimum Utilized Percent</th>
          </tr>
      </thead>
      <tbody> ";
      foreach($readOps['Datapoints'] as $row5){
          echo "<tr>";
          echo "<th scope='row'>".$row5['Maximum']."</th>";
          echo "<td>".$row5['Minimum']."</td>";
          echo "</tr>";
      }
echo "</tbody>
    </table>";
echo("<br>");

$networkout = $cw->getMetricStatistics([
    'Dimensions' => [
        [
          'Name' => 'InstanceId',
          'Value' => 'i-06bb870fb26cd1d53'
        ],
      ],
      'EndTime' => strtotime('now'), 
      'MetricName' => 'NetworkOut', 
      'Namespace' => 'AWS/EC2', 
      'Period' => 60, 
      'StartTime' => strtotime('-1 days'),
      'Statistics' => ['Minimum','Maximum'],
      'Unit' => 'Bytes',
  ]);

echo "<h3>NetworkOut Metrics</h3>
                <table class='table table-bordered'>
                    <thead>
                        <tr>
                            <th>Maximum Utilized Percent</th>
                            <th>Minimum Utilized Percent</th>
                        </tr>
                    </thead>
                    <tbody> ";
                    foreach($networkout['Datapoints'] as $row6){
                        echo "<tr>";
                        echo "<th scope='row'>".$row6['Maximum']."</th>";
                        echo "<td>".$row6['Minimum']."</td>";
                        echo "</tr>";
                            }
            echo "</tbody>
                  </table>";
?>                      
</div>
</div>
</body>
</html>

