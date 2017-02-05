<html>
<head>
<link rel="stylesheet" type="text/css" href="css/app.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>University Management System</title>

<script>
    if (!Modernizr.touch || !Modernizr.inputtypes.date) {
        $('input[type=date]')
            .attr('type', 'text')
            .datepicker({
                // Consistent format with the HTML5 picker
                dateFormat: 'yy-mm-dd'
            });
    }
</script>
</head>
<body>
	<div class="container-fluid">
	<nav class="navbar navbar-static">
	<div class="container-fluid">
		<div class="navbar-header">
			<img src="images/iitlogo.gif" class="img-fluid"	alt="Responsive image"> 
		</div>
	
		<div id="content">
			<form method="post" action="login.do">
				<h1>Login Form</h1>
				<% if(request.getAttribute("errMsg") != null) { %>
				<div id="errMsg">
				<%= request.getAttribute("errMsg") %>
				</div>
				<%} %>
				<div>
				<input type="email" name="userName" placeholder="Username" required="true" id="username">
				</div>	
				<div>
					<input type="password" name="password" title="5 to 10 characters" placeholder="Password" required="true" id="password"> 	
				</div>

				<div>
					<input type="submit"  value="submit"/>
				</div>					
			</form>
		</div>
	</div>
</body>
</html>