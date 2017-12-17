package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.ConnectionDatabase;


public class Dao {
	ResultSet rs= null;

	public ResultSet executeFetchQuery(String sqlQuery)	{	
		try {

			ConnectionDatabase conn = new ConnectionDatabase();
			Connection connection = conn.getConnection();
			Statement stm = connection.createStatement();
			rs = stm.executeQuery(sqlQuery);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Integer executeModifySelectQuery(String sqlQuery)	{	
		Integer id = null;
		try {
			ConnectionDatabase conn = new ConnectionDatabase();
			Connection connection = conn.getConnection();
			PreparedStatement stm = connection.prepareStatement(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			stm.executeUpdate();
			rs  = stm.getGeneratedKeys();
			if (rs.next()) {
				id =  rs.getInt(1);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}



}
