<?php 
session_start(); 
?>

<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<head>
  <title>Image Processing</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<h2 class="text-center custom icm-size">Image Submission Form</h1>

<style>
.custom {
color: white;
}	
.custom-padding{
	padding-top:10vw;
	padding-left:16vw;
	font-size:1.4vw;
}
.icm-size{
	font-size:4vw;
}
.form-control{
	width:40%;
}

.background{
	background-size:100% 100%;
}
.icm-padding{
	padding-left:45vw;
}
</style>

</head>

<body background="https://s3-us-west-2.amazonaws.com/kedarbkt/fonstola.ru-72345.jpg">
		<form enctype="multipart/form-data" action="submit.php" method="POST">
		<div class="text-center custom custom-padding">
		<input type="hidden" name="MAX_FILE_SIZE" value="3000000" />
		
	<div class="container-fluid">
		<div class="form-group ">
			<div class="row">
			<div class="col-md-3">
  			<label for="usr">Name:</label>
			  </div>
  			<input type="text" name="uname" class="form-control d-inline" id="usr" required>
			  </div>
		</div>
		<div class="form-group ">
		<div class="row">
		<div class="col-md-3">
			  <label for="emailid">Email:</label>
			  </div>
  			<input type="email" name="useremail" class="form-control d-inline" id="emailid" required>
			  </div>
		</div>
		<div class="form-group ">
		<div class="row">
		<div class="col-md-3">
		<label for="phno">Contact Number:</label>
		</div>
			  <input type="number" name="phone" class="form-control d-inline" id="phno" required>
			  </div>
		</div>
		<div class="form-group ">
		<div class="row">
		<div class="col-md-3">
  			<label for="fil">Browse File:</label>
			  </div>
			  <input type="file" name="userfile" class="form-control d-inline" id="fil" multiple="multiple" required>
			  </div>
		</div>
		</div>
		</div>
		<span class="icm-padding"><input class="btn btn-success" type="submit" value="Send File"  required/></span>
	</form>
</body>
</html>