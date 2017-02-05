package models;


import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 * The main class to connect to the database.
 */
public class Connector {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
		Connection connect = null;
		Class.forName("com.mysql.jdbc.Driver");

		connect = DriverManager
				.getConnection("jdbc:mysql://www.papademas.net:3306/fp?" + "user=dbfp&password=510");
		return connect;
	
	
		}
}
