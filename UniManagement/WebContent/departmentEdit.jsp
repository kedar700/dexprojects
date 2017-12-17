<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	 <style>  
    .center-block {  
    width:100px;  
    padding:50px;     
    }</style> 

<body>
<div class="container-fluid">
	<div class="panel-heading"><%@include file="header.jsp" %></div>
		<div class="panel-body">
			<div style="height:400px">
				<div class="center-block">
					 <form class="form-inline" action="department.do" method="post">
						<input type="hidden" name="departmentId" value="<c:out value="${department.getDeptId()}" />" />
  					<div class="form-group"> 
  							<label for="Department Name">Department Name: </label>
    						<input type="text" required="true" class="form-control" id="pwd"  name="deptName" value="<c:out value="${department.getDeptName()}" />">
  							<br/><br/>
  							<input type="submit" class="btn btn-primary" value="Update" />
  					</div> 
					</form>
				</div>
			</div>
		</div>
		<div class="panel-footer"><%@include file="footer.jsp" %></div>
	</div>
</body>
</html>