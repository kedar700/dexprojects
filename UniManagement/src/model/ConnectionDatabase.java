package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDatabase {

	// Declared as static to share same object. 
	private static Connection conn= null;

	public Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			//To create only one object of connection
			if (conn == null){


				conn = DriverManager.getConnection("jdbc:mysql://localhost/unimanagement", "root","kedar");

			}
		}
		catch (SQLException e ){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}

