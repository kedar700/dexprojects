<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Enrollment List</title>
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
</head>
<body>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading"><%@include file="header.jsp"%></div>
			<div class="container">
						<div style="height:500px">
			<div class="row">
				<div class="pull-right">
					<a class="btn btn-success" href="enrollment.do?action=edit">Enroll</a>
				</div>
				<div class="col-md-12">
					<h2>List of Enrollment Details:</h2>
					<div class="table-responsive">
						<table id="mytable" class="table table-bordred table-striped">
							<thead>
								<th>Course Name</th>
								<th>Faculty Name</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Grade</th>
								<th></th>
							</thead>
							<tbody>
								<c:forEach items="${enrollments}" var="enrollment">
									<tr>
										<td><c:out value="${enrollment.getCourseName()}" /></td>
										<td><c:out value="${enrollment.getFacultyName()}" /></td>
										<td><c:out value="${enrollment.getStartDate()}" /></td>
										<td><c:out value="${enrollment.getEndDate()}" /></td>
										<td><c:out value="${enrollment.getGrade()}" /></td>
										<td><a class="btn btn-primary"
											href="enrollment.do?action=delete&enrollmentId=<c:out value='${enrollment.getEnrollId() }'/>">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			</div>
			</div>
			</DIV>
			<div class="panel-footer"><%@include file="footer.jsp"%></div>
	</div>

</body>
</html>