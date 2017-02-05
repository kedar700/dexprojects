<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Enrollment Details</title>
</head>

<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/app.js"></script>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading"><%@include file="header.jsp"%></div>
				<h2>Enrollment Details</h2>
				<div class="panel-body">
					<div class="container">
						<div style="height:500px">
							<div class="row">
								<div class=" col-md-9 col-lg-9 ">
									<form class="form-inline" action="enrollment.do" method="post">
										<input type="hidden" name="enrollmentId" value="<c:out value="${enrollment.getUserId()}" />" />
										<strong>Select semester:</strong>
										<div class="dropdown">
											<select class="btn btn-default dropdown-toggle" name="courseId" id="semDrop">
												<option>Select course</option>
													<c:forEach items="${semesters}" var="semester">
														<option value="${semester.getSemesterId()}"><c:out value="${semester.getSemesterType()}-${semester.getSemesterYear()}" /></option>
													</c:forEach>
											</select>
										</div>
										</form>
							<br/><br/>
										<div id="errorDiv" style="display: none" class="alert alert-danger"></div>
										<div id="tableDiv" style="display: none">
											<table class="table table-user-information" id="courseTable">
												<thead>
													<th>Course Name</th>
													<th>Faculty Name</th>
													<th>Start Date</th>
													<th>End Date</th>
													<th>Capacity</th>
												</thead>
												<tbody id="tableData">
												</tbody>
											</table>
										</div>
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