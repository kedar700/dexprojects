package model;
import java.sql.Date;

import model.dao.CourseDAO;
import model.dao.FacultyDAO;
import model.dao.StudentDAO;
public class Enrollment {
	private Integer enrollId;
	private Date startDate;
	private Date endDate;
	private String courseName;
	private Double grade;
	private Integer courseId;
	private Integer classId;
	private Integer studentId;
	private Integer semesterId;
	
	
	public Integer getEnrollId() {
		return enrollId;
	}
	public void setEnrollId(Integer enrollId) {
		this.enrollId = enrollId;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(Integer semesterId) {
		this.semesterId = semesterId;
	}
	
	
	public String getFacultyName(){
		CourseDAO dao = new CourseDAO();
		Course course = dao.getCourse("course_id", this.getCourseId().toString());
		return course.getFacultyName();
	}
	public String getStudentName(){
		StudentDAO dao=new StudentDAO();
		Student student =dao.getStudent("user_id",this.getStudentId().toString());
		return student.getFirstName()+" "+student.getLastName();
	}
	
	public String getStudentCwId(){
		StudentDAO dao=new StudentDAO();
		Student student =dao.getStudent("user_id",this.getStudentId().toString());
		return student.getCwId();
	}

}
