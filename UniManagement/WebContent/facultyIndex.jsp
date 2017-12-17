<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
<body>
<body>
<div class="container-fluid">
	<div class="panel panel-default">
	 	<div class="panel-heading"><%@include file="header.jsp" %></div>	 
	 	<div class="container">
 			<div style="height:500px">
			<h1>Faculty Edit Form</h1>
			<div class="pull-right"><a class="btn btn-success" href="faculty.do?action=edit">Add Faculty</a></div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Date of Birth</th>
						<th>Phone</th>
						<th>Department</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${faculty}" var="faculty">
					<tr>
						<td><c:out value="${faculty.getFirstName()}" /></td>
						<td><c:out value="${faculty.getLastName()}" /></td>
						<td><c:out value="${faculty.getEmail()}" /></td>
						<td><c:out value="${faculty.getPassword()}" /></td>
						<td><c:out value="${faculty.getDob()}" /></td>
						<td><c:out value="${faculty.getPhone()}" /></td>
						<td><c:out value="${faculty.getDepartmentName()}" /></td>
						<td><a class="btn btn-primary" href="faculty.do?action=edit&facultyId=<c:out value='${faculty.getUserId() }'/>">Edit</a>
    					</td>
						<td><a class="btn btn-danger" href="faculty.do?action=delete&facultyId=<c:out value='${faculty.getUserId() }'/>">Delete</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
</div>
</div>
<div class="panel-footer"><%@include file="footer.jsp" %></div>
</div>
</body>
</html>