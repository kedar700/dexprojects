<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<title>Faculty Edit Form</title>
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
			<div class="panel panel-info">
				<div class="container">
					<h2>Faculty Edit Form</h2>
					<div class="panel-body">
						<div class="row">
							<div class=" col-md-9 col-lg-9 ">
								<form class="form-inline" action="faculty.do" method="post">
									<input type="hidden" name="facultyId"
										value="<c:out value="${faculty.getUserId()}" />" />
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>CWID:</td>
												<td><input type="text" name="cwId" required="true"
													class="form-control" id="cwid"
													value="<c:out value="${faculty.getCwId()}" />"></td>
											</tr>
											<tr>
												<td>FirstName:</td>
												<td><input type="text" name="firstName" required="true"
													class="form-control" id="fname"
													value="<c:out value="${faculty.getFirstName()}" />"></td>
											</tr>
											<tr>
												<td>Last Name:</td>
												<td><input type="text" name="lastName" required="true"
													class="form-control" id="lname"
													value="<c:out value="${faculty.getLastName()}" />"></td>
											</tr>
											<tr>
												<td>Email:</td>
												<td><input type="email" name="email" required="true"
													class="form-control" id="email"
													value="<c:out value="${faculty.getEmail()}" />"></td>
											</tr>
											<tr>
												<td>Password:</td>
												<td><input type="text" name="password"
													class="form-control" id="password"
													value="<c:out value="${faculty.getPassword()}" />"></td>
											</tr>
											<tr>
												<td>DOB</td>
												<td><input placeholder="dob" class="textbox-n"
													name="Dob" type="text" onfocus="(this.type='date')"
													onblur="(this.type='text')" id="dob"
													value="<c:out value="${faculty.getDob()}" />"></td>
											</tr>
											<tr>
												<td>Phone No:</td>
												<td><input type="text" name="phone" required="true"
													class="form-control" id="phone"
													value="<c:out value="${faculty.getPhone()}" />"></td>
											</tr>

											<tr>
												<td>Department Name</td>
												<td><div class="dropdown">
														<select class="btn btn-default dropdown-toggle"
															name="departmentId">
															<c:forEach items="${departments}" var="department">
																<option value="${department.getDeptId()}"><c:out
																		value="${department.getDeptName()}" /></option>
															</c:forEach>
														</select>
													</div></td>
											</tr>
										</tbody>
									</table>

									<input type="submit" class="btn btn-primary" value="Update" />
								</form>
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