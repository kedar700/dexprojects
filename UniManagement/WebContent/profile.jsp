<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.form-actions {
	margin: 0;
	background-color: transparent;
	text-align: right;
}
</style>
<body>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading"><%@include file="header.jsp"%></div>
			<div class="panel-body">
				<div style="height: 500px">
					<div class="container">
						<div class="row">
							<div
								class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
								<!-- 	<div class="panel panel-info"> -->
								<div class="row">
									<div class=" col-md-9 col-lg-9 ">
										<table class="table table-user-information">
											<tbody>
												<tr>
													<td>Name:</td>
													<td><c:out value="${user.getFirstName()}  ${user.getLastName()}" /></td>
												</tr>
												<tr>
													<td>CWID:</td>
													<td><c:out value="${user.getCwId()}" /></td>
												</tr>
												<tr>
													<td>email:</td>
													<td><c:out value="${user.getEmail()}" /></td>
												</tr>
												<tr>
													<td>Date of Birth</td>
													<td><c:out value="${user.getDob()}" /></td>
												</tr>
												<tr>
													<td>Home Address</td>
													<td><c:out
															value="${address.getAddressline1()}  ${address.getAddressline2()}" />
														<br> <c:out
															value="${address.getCity()}  ${address.getState()}" /> <br>
														<c:out value="${address.getZip()}" /></td>
												</tr>
												<tr>
													<td>Phone Number</td>
													<td><c:out value="${user.getPhone()}" /></td>
												</tr>
											</tbody>
										</table>
										<div class=form-actions>
											<a href="address.do?action=edit" class="btn btn-primary">Edit
												Address</a>
										</div>
									</div>
								</div>
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