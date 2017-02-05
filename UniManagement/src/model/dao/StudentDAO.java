package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDAO extends UserDAO{

	public Student getStudent(String columnName, String value){
		Student st = null;  
		try {
			String sql= "select * from users where " + columnName +  "='" + value + "'";
			rs = executeFetchQuery (sql);			
			if (rs.next()){	
				st = new Student();
				st.setUserId(Integer.parseInt(rs.getString("user_id")));
				st.setFirstName(rs.getString("first_name"));
				st.setLastName(rs.getString("last_name"));
				st.setDob(rs.getDate("DOB"));
				st.setEmail(rs.getString("email"));
				st.setPassword(rs.getString("password"));
				st.setPhone(rs.getString("phone"));
				st.setUserType(rs.getString("user_type"));
				st.setCwId(rs.getString("cwid"));
				st.setDeptId(rs.getInt("dept_id"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public ArrayList<Student> getAllStudents(){	
		ArrayList <Student> list = new ArrayList<Student>();
		try {
			String sql= "select * from users where user_type='Student'" ;
			rs = executeFetchQuery (sql);			

			while (rs.next()){	
				Student st =  new Student();
				st.setUserId(Integer.parseInt(rs.getString("user_id")));
				st.setFirstName(rs.getString("first_name"));
				st.setLastName(rs.getString("last_name"));
				st.setDob(rs.getDate("DOB"));
				st.setEmail(rs.getString("email"));
				st.setPassword(rs.getString("password"));
				st.setPhone(rs.getString("phone"));
				st.setCwId(rs.getString("cwid"));
				st.setUserType(rs.getString("user_type"));
				st.setDeptId(rs.getInt("dept_id"));
				list.add(st);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;		
	}


	public boolean addStudent(Student st){
		try {
			String sql= "INSERT INTO users(email,first_name,last_name,password,phone,user_type,DOB,cwid,dept_id) values('" +
					st.getEmail() + "','" + st.getFirstName() + "','" + st.getLastName() + "','" +
					st.getPassword() + "','" + st.getPhone() + "','"+ st.getUserType() + "','"+
					st.getDob()+ "','"+ st.getCwId()+ "','"+st.getDeptId()+"')";

			executeModifySelectQuery(sql);				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	public void updateStudent(Student st){
		try {
			String sql= "UPDATE users SET first_Name = '" + st.getFirstName() + "',last_Name='" + st.getLastName() +
					 "', password= '"+ st.getPassword() + "',phone='" + st.getPhone() + "',user_type='" + st.getUserType() +
					 "',DOB='" + st.getDob() + "',cwid='" + st.getCwId() + "',dept_id='" + st.getDeptId() +"' where user_id=" + st.getUserId()	;
			System.out.println(sql);
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void deleteStudent(Student st){
		try {
			String sql= "DELETE FROM users WHERE user_id = " + st.getUserId();
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

