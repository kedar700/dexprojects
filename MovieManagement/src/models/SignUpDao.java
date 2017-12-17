package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class SignUpDao {

	Connector connect =new Connector();
	private PreparedStatement sql=null;
	/**
	 * Used for signing up the user.
	 * @param Fname the first name of the user.
	 * @param Lname the last name of the user.
	 * @param address the address of the user.
	 * @param email_id the email id of the user.
	 * @param password the password required.
	 */
		public void Insertdata(String Fname,String Lname,String address,String email_id,String password){
			String state="Insert INTO k_naik_users(Fname,Lname,address,email_id,password,isAdmin) Values(?,?,?,?,?,'no')";
		//String state="Select email_id,password,isAdmin from k_naik_users where email_id= ? and password= ? and isAdmin=?";
		try{
		sql=connect.getConnection().prepareStatement(state);
		sql.setString(1, Fname);
		sql.setString(2, Lname);
		sql.setString(3, address);
		sql.setString(4, email_id);
		sql.setString(5, password);
		sql.executeUpdate();
		//sql.close();
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	


