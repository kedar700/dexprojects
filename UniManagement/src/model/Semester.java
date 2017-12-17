package model;

public class Semester {

private Integer semesterId;
private String semesterType;
private String semesterYear;
private boolean semesterStatus;

public Integer getSemesterId() {
	return semesterId;
}
public void setSemesterId(Integer semesterId) {
	this.semesterId = semesterId;
}
public String getSemesterType() {
	return semesterType;
}
public void setSemesterType(String semesterType) {
	this.semesterType = semesterType;
}
public String getSemesterYear() {
	return semesterYear;
}
public void setSemesterYear(String semesterYear) {
	this.semesterYear = semesterYear;
}
public boolean isSemesterStatus() {
	return semesterStatus;
}
public void setSemesterStatus(boolean semesterStatus) {
	this.semesterStatus = semesterStatus;
}

}
