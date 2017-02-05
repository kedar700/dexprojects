package model.dao;

import java.sql.SQLException;


import model.User;

public class UserDAO extends Dao{

	public User getUser(String columnName, String value){
		User use = null;  
		try {
			String sql= "select * from users where " + columnName +  "='" + value + "'";
			rs = executeFetchQuery (sql);			
			if (rs.next()){	
				use = new User();
				use.setUserId(Integer.parseInt(rs.getString("user_id")));
				use.setFirstName(rs.getString("first_name"));
				use.setLastName(rs.getString("last_name"));
				use.setDob(rs.getDate("DOB"));
				use.setEmail(rs.getString("email"));
				use.setPassword(rs.getString("password"));
				use.setPhone(rs.getString("phone"));
				use.setUserType(rs.getString("user_type"));
				use.setCwId(rs.getString("cwid"));
				use.setDeptId(rs.getInt("dept_id"));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return use;
	}
	
	
	
}
