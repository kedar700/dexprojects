<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faculty Home Page</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script type="text/javascript">
	$('.datepicker').datepicker();
</script>
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
								<form class="form-inline" action="facultyHome.do" method="post">
									<input type="hidden" name="enrollmentId"
										value="<c:out value="${enrollment.getEnrollId()}" />" />
											<input type="hidden" name="courseId"
										value="<c:out value="${enrollment.getCourseId()}" />" />
									<table class="table table-user-information">
										<tbody>
											<tr>
												<td>CWID:</td>
												<td><span><c:out value="${enrollment.getStudentCwId()}" /></span>
												
												</td>
											</tr>
											<tr>
												<td>Student Name:</td>
												<td>
												<span><c:out value="${enrollment.getStudentName()}" /></span>
												</td>
											</tr>
											<tr>
												<td>Grade:</td>
												<td><input type="text" name="grade" required="true"
													class="form-control" id="lname"
													value="<c:out value="${enrollment.getGrade()}" />"></td>
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

</body>
</html>