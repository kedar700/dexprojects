package models;

import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class LoginDao {

	Connector connect =new Connector();
	private PreparedStatement sql=null;
	/**
	 * 
	 * @param user Username of the user
	 * @param pass Password of the user.
	 * @param isAdmin if the given user is admin or not.
	 * @return will return result if the user is validated.
	 */
	public ResultSet getResult(String user, String pass, String isAdmin){
		
		ResultSet result=null;
		try{
			String state="Select email_id,password,isAdmin from k_naik_users where email_id= ? and password= ? and isAdmin=?";
			sql=connect.getConnection().prepareStatement(state);
			sql.setString(1, user);
			sql.setString(2, pass);
			sql.setString(3, isAdmin);
			result=sql.executeQuery();
			//sql.close();
			System.out.println("The verification is in process");
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	} 
	/**
	 * 
	 * @param user username of the user.
	 * @param pass password of the user.
	 * @return will return the id if the user is found.
	 */
	public ResultSet getusrid(String user,String pass) {
		ResultSet result2 = null;
		String st = "select k_naik_users.User_id from k_naik_users where email_id=? and password=?";

		try {
			sql = connect.getConnection().prepareStatement(st);
			sql.setString(1, user);
			sql.setString(2, pass);
			result2 = sql.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result2;

	}
}
