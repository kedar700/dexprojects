package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Faculty;

public class FacultyDAO extends UserDAO{

	public Faculty getFaculty(String columnName, String value){
		Faculty ft = null;  
		try {
			String sql= "select * from users where " + columnName +  "='" + value + "'";
			rs = executeFetchQuery (sql);			
			if (rs.next()){	
				ft = new Faculty();
				ft.setUserId(Integer.parseInt(rs.getString("user_id")));
				ft.setFirstName(rs.getString("first_name"));
				ft.setLastName(rs.getString("last_name"));
				ft.setDob(rs.getDate("DOB"));
				ft.setEmail(rs.getString("email"));
				ft.setPassword(rs.getString("password"));
				ft.setPhone(rs.getString("phone"));
				ft.setUserType(rs.getString("user_type"));
				ft.setCwId(rs.getString("cwid"));
				ft.setDeptId(rs.getInt("dept_id"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ft;
	}
	
	public ArrayList<Faculty> getAllFaculty(){	
		ArrayList <Faculty> list = new ArrayList<Faculty>();
		try {
			String sql= "select * from users where user_type='Faculty'" ;
			rs = executeFetchQuery (sql);			

			while (rs.next()){	
				Faculty ft =  new Faculty();
				ft.setUserId(Integer.parseInt(rs.getString("user_id")));
				ft.setFirstName(rs.getString("first_name"));
				ft.setLastName(rs.getString("last_name"));
				ft.setDob(rs.getDate("DOB"));
				ft.setEmail(rs.getString("email"));
				ft.setPassword(rs.getString("password"));
				ft.setPhone(rs.getString("phone"));
				ft.setCwId(rs.getString("cwid"));
				ft.setUserType(rs.getString("user_type"));
				ft.setDeptId(rs.getInt("dept_id"));
				list.add(ft);
			}

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;		
	}


	public boolean addFaculty(Faculty ft){
		try {
			String sql= "INSERT INTO users(email,first_name,last_name,password,phone,user_type,DOB,cwid,dept_id) values('" +
					ft.getEmail() + "','" + ft.getFirstName() + "','" + ft.getLastName() + "','" +
					ft.getPassword() + "','" + ft.getPhone() + "','"+ ft.getUserType() + "','"+
					ft.getDob()+ "','"+ ft.getCwId()+ "','"+ft.getDeptId()+"')";

			executeModifySelectQuery(sql);				
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}

	public void updateFaculty(Faculty ft){
		try {
			String sql= "UPDATE users SET first_Name = '" + ft.getFirstName() + "',last_Name='" + ft.getLastName() +
					"', email='" + ft.getEmail() + "', password= '"+ ft.getPassword() + "',phone='" + ft.getPhone() + 
					 "',DOB='" + ft.getDob() + "',cwid='" + ft.getCwId() + "',dept_id='" + ft.getDeptId() +"' where user_id=" + ft.getUserId();
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void deleteFaculty(Faculty ft){
		try {
			String sql= "DELETE FROM users WHERE user_id = " + ft.getUserId();
			executeModifySelectQuery(sql);					
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
