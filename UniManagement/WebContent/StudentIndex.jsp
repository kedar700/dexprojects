<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
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
<style>.pull-right {  float: right !important; }</style>
<body>
	<div class="container-fluid">
	<div class="panel panel-default">
	 <div class="panel-heading"><%@include file="header.jsp" %></div>	 
 	<div class="container">
 	<div style="height:500px">
		<h1>Student Edit Form</h1>
		<div class="pull-right"><a class="btn btn-success" href="student.do?action=edit">Add student</a></div>
					
		<table class="table table-striped">
			<thead>
				<tr>
					<th>CWID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Date of Birth</th>
					<th>Phone</th>
					<th>Department</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td><c:out value="${student.getCwId()}" />	</td>
						<td><c:out value="${student.getFirstName()}" /></td>
						<td><c:out value="${student.getLastName()}" /></td>
						<td><c:out value="${student.getEmail()}" /></td>
						<td><c:out value="${student.getPassword()}" /></td>
						<td><c:out value="${student.getDob()}" /></td>
						<td><c:out value="${student.getPhone()}" /></td>
						<td><c:out value="${student.getDepartmentName()}" /></td>
						<td><a class="btn btn-primary"
							href="student.do?action=edit&studentId=<c:out value='${student.getUserId() }'/>"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="<c:out value='${student.getUserId() }'/>" >
    								<span class="glyphicon glyphicon-pencil"></span>
    								</button></a></td>
						<td>
						<a class="btn btn-danger" href="student.do?action=delete&studentId=<c:out value='${student.getUserId() }'/>">Delete</a>
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