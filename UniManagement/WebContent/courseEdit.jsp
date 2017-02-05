<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Courses</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
<body>
	<div class="container-fluid">
 		<div class="panel panel-default">
	 		<div class="panel-heading"><%@include file="header.jsp" %></div>
	 		<div class= "panel-body">
	 			<div style="height:500px">
	 				<div class="container">
						<h3>Course View</h3>
            			<div class="panel-body">
              				<div class="row">
                				<div class=" col-md-9 col-lg-9 "> 
                					<form class="form-inline" action="course.do" method="post">
                  						<input type="hidden" name="courseId" value="<c:out value="${course.getCourseId()}" />" />
                  						<table class="table table-user-information">
                   						 <tbody>
                      						<tr>
                        						<td>Course Name:</td>
                        						<td><input type="text"name="courseName" class="form-control" id="courseName" value="<c:out value="${course.getCourseName()}" />"/></td>
                      						</tr>
                     						 <tr>
                        						<td>Course Capacity:</td>
                        						<td><input type="text"name="capacity" class="form-control" id="courseName" value="<c:out value="${course.getCapacity()}" />"/></td>
                      						</tr>
                      						<tr>
                        						<td>Department Name</td>
												<td><div class="dropdown">
														<select class="btn btn-default dropdown-toggle" name="deptId">
															<c:forEach items="${departments}" var="department">
																<option value="${department.getDeptId()}">
																	<c:out value="${department.getDeptName()}" />
																</option>
															</c:forEach>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td>Faculty Name</td>
												<td><div class="dropdown">
														<select class="btn btn-default dropdown-toggle" name="facultyId">
															<c:forEach items="${faculty}" var="faculty">
																<option value="${faculty.getUserId()}">
																	<c:out value="${faculty.getFirstName()}" />
																</option>
															</c:forEach>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<td>Semester</td>
												<td><div class="dropdown">
														<select class="btn btn-default dropdown-toggle" name="semesterId">
															<c:forEach items="${semesters}" var="semester">
																<option value="${semester.getSemesterId()}">
																	<c:out value="${semester.getSemesterType()}-${semester.getSemesterYear()}" />
																</option>
															</c:forEach>
														</select>
													</div>
												</td>
                      						</tr>               
                       						<tr>
                        						<td>Start Date:</td>
                          						<td> <input placeholder="startDate" class="textbox-n" name="startDate" value="${course.getStartDate()}" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="date"></td>
                      						</tr>
                         					<tr>
                         						<td>End Date:</td>
                           						<td> <input placeholder="endDate" class="textbox-n" name="endDate" value="${course.getEndDate()}" type="text" onfocus="(this.type='date')" onblur="(this.type='text')" id="date"></td>
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
         <div class="panel-footer"><%@include file="footer.jsp" %></div>
         </div>
         </div>
	</body>
</html>