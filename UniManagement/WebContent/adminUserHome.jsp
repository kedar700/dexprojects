<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home Page</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	
</script>
<body>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading"><%@include file="header.jsp"%></div>
			<div class="panel-body">
				<div style="height: 500px">
					<div class="container">
						<div class="row">
							<div class="col-sm-2 col-lg-2">
								<div class="dash-unit">
									<div class="thumbnail">
										<img src="images/students.png" class="img-fluid"
											alt="Responsive image">
									</div>
									<a href="student.do?action=index"><center>
											<h3>Student Portal</h3>
										</center></a>
								</div>
							</div>

							<div class="col-sm-2 col-lg-2">
								<div class="dash-unit">
									<div class="thumbnail">
										<img src="images/faculty.png" class="img-fluid"
											alt="Responsive image">
									</div>
									<a href="faculty.do?action=index"><center>
											<h3>Faculty Portal</h3>
										</center></a>
								</div>
							</div>

							<div class="col-sm-2 col-lg-2">
								<div class="dash-unit">
									<div class="thumbnail">
										<img src="images/department.png" class="img-fluid"
											alt="Responsive image">
									</div>
									<a href="department.do?action=index"><center>
											<h3>Department Portal</h3>
										</center></a>
								</div>
							</div>

							<div class="col-sm-2 col-lg-2">
								<div class="dash-unit">
									<div class="thumbnail">
										<img src="images/courses.png" class="img-fluid"
											alt="Responsive image">
									</div>
									<a href="course.do?action=index"><center>
											<h3>Courses Portal</h3>
										</center></a>
								</div>
							</div>

							<div class="col-sm-2 col-lg-2">
								<div class="dash-unit">
									<div class="thumbnail">
										<img src="images/enrollment.png" class="img-fluid"
											alt="Responsive image">
									</div>
									<a href="#"><center>
											<h3>Enrollment Portal</h3>
										</center></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer"><%@include file="footer.jsp"%></div>
		</div>
	</div>

</body>
</html>