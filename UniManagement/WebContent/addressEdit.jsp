<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address form</title>
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
	 <div class="panel-heading">
	 <%@include file="header.jsp" %></div>
	 <div style="height:500px">
	 <div class="container">
		<div class="row">
		<h2 class="panel-title"><strong></>Address Form</strong></h2>
					<div class="panel-body">
						<div class="row"><div class=" col-md-9 col-lg-9 ">
								<form class="form-inline" action="address.do" method="post">
								<input type="hidden" name="addressId" required="true" value="<c:out value="${address.getAddressId()}" />" />
									<table class="table table-user-information" >
										<tbody>
											<tr>
												<td>Address Line1:</td>
												<td><input type="text" name="addressline1" required="true" class="form-control"
													id="addressline1" value="<c:out value="${address.getAddressline1()}" />"></td>
											</tr>
											<tr>
											<td>Address Line2:</td>
											<td><input type="text" name="addressline2"
												class="form-control" id="addressline2"
												value="<c:out value="${address.getAddressline2()}" />"></td>
											</tr>
											<tr>
											<td>City:</td>
											<td><input type="text" name="city" required="true"
												class="form-control" id="city"
												value="<c:out value="${address.getCity()}" />"></td>
											</tr>
											<tr>
											<td>State:</td>
											<td><input type="text" name="state" required="true"
												class="form-control" id="state"
												value="<c:out value="${address.getState()}" />"></td>
											</tr>
											<tr>
											<td>Zip:</td>
											<td><input type="text" name="zip" required="true"
												class="form-control" id="zip"
												value="<c:out value="${address.getZip()}" />"></td>
											</tr>
											<tr>
											<td>Phone No:</td>
											<td><input type="text" name="phone" class="form-control" required="true"
												id="phone" value="<c:out value="${address.getPhone()}" />"></td>
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
		</div>
		<div class="panel-footer"><%@include file="footer.jsp" %></div>
	</div>
	</div>
</body>
</html>