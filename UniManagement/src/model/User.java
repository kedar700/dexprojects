package model;

import java.sql.Date;

import model.dao.AddressDAO;
import model.dao.DepartmentDao;

public class User {

	private Integer userId;
	private String cwId;
	private String firstName;
	private String lastName;
	private String email;
	private String  password;
	private Date dob;
	private String phone;
	private String  userType;
	private Integer deptId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCwId() {
		return cwId;
	}
	public void setCwId(String cwId) {
		this.cwId = cwId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDepartmentName(){
		DepartmentDao deptDao = new DepartmentDao();
		return deptDao.getDepartment("dept_id",this.getDeptId().toString()).getDeptName();
	}

	public Address getAddress(){
		return  new AddressDAO().getAddress(this.getUserId());
	}

}
