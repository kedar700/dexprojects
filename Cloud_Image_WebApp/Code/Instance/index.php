<?php 
session_start(); 
?>

<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<head>
  <title>Kedar Mini Project 2</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<h1 class="text-center">Welcome to Kedar's Cloud Mini Project</h1>
<style>
.icm-top{
	padding-top:12vw;
}
.icm-btn{
width:24vw;
height:12vw;
font-size:1.8rem;
}
</style>
</head>
<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/fonstola.ru-72345.jpg">
<div class="row icm-top">
	<div class="col-md-6 text-center">
	<form action="imageform.php">
	<button class="btn btn-success icm-btn" >Add Image</button>
	</form>
	</div>
	<div class="col-md-6 text-center">
	<form action="gallery.php">
   	<!-- <br /><input class="btn btn-primary btn-lg" type="button" value="Gallery"> -->
	   <button class="btn btn-success icm-btn">Gallery</button>
	</form>
	</div>
</div>
</body>
</html>