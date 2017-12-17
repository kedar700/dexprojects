package model;

import java.sql.Date;

import model.dao.DepartmentDao;
import model.dao.FacultyDAO;
import model.dao.SemesterDAO;

public class Course {
private Integer courseId;
private String courseName;
private Integer deptId;
private Date startDate;
private Date endDate;
private Integer capacity;
private Integer facultyId;
public Integer getCapacity() {
	return capacity;
}
public void setCapacity(Integer capacity) {
	this.capacity = capacity;
}
public Integer getFacultyId() {
	return facultyId;
}
public void setFacultyId(Integer facultyId) {
	this.facultyId = facultyId;
}
private Integer semesterId;

public Integer getSemesterId() {
	return semesterId;
}
public void setSemesterId(Integer semesterId) {
	this.semesterId = semesterId;
}
public Integer getCourseId() {
	return courseId;
}
public void setCourseId(Integer courseId) {
	this.courseId = courseId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public Integer getDeptId() {
	return deptId;
}
public void setDeptId(Integer deptId) {
	this.deptId = deptId;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getDepartmentName(){
	DepartmentDao deptDao = new DepartmentDao();
	return deptDao.getDepartment("dept_id",this.getDeptId().toString()).getDeptName();
}

public String getSemesterName(){
	SemesterDAO semDao=new SemesterDAO();
	Semester sem2= semDao.getSemester("semester_id",this.getSemesterId().toString());
	return sem2.getSemesterType()+" "+sem2.getSemesterYear();
}

public String getFacultyName(){
	FacultyDAO factDao = new FacultyDAO();
	Faculty fact= factDao.getFaculty("user_id", this.getFacultyId().toString());
	return fact.getFirstName()+" "+fact.getLastName();

}

}
