package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class SelectionDao extends Connector{
	Connector connect = new Connector();
	private PreparedStatement sql = null;
/**
 * 
 * @return will return the details for the user as requested.
 */
	public ResultSet getResult() {

		ResultSet result = null;
		try {
			String state = "select fp.k_naik_movies.movie_name,fp.k_naik_movies.movie_description,"
					+ "fp.k_naik_movies.movie_rating,fp.k_naik_shows.show_date,fp.k_naik_shows.show_time,"
					+ "fp.k_naik_shows.show_seats,fp.k_naik_shows.show_venue,fp.k_naik_shows.show_cost "
					+ "from fp.k_naik_shows inner join fp.k_naik_movies on fp.k_naik_shows.mv_id=fp.k_naik_movies.movie_id;";
			sql = connect.getConnection().prepareStatement(state);
			result = sql.executeQuery();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
/**
 * used to store card details
 * @param card_name the name of the user 
 * @param card_number tehe card number
 * @param card_year the year of card
 * @param card_month the name on the card
 * @param cvv the card cvv
 * @param st the timestamp for identification
 */
	public void Insertdt(String card_name, String card_number, Integer card_year,Integer card_month,Integer cvv,Timestamp st) {
		String state = "Insert INTO k_naik_card(cvv,card_name,card_number,card_year,card_month,card_dttime) Values(?,?,?,?,?,?)";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setInt(1, cvv);
			sql.setString(2, card_name);
			sql.setString(3, card_number);
			sql.setInt(4, card_year);
			sql.setInt(5, card_month);
			sql.setTimestamp(6, st);

			sql.executeUpdate();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 
 * @param seats seats of the user
 * @param shw_id use to update the show
 */
	public void updatedta(Integer seats,Integer shw_id) {
		String state = "Update k_naik_shows set show_seats=? where show_id=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setInt(1, seats);
			sql.setInt(2, shw_id);
			sql.executeUpdate();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 
 * @param dt date of the show
 * @param seats seats of the show
 * @param amt amount required
 * @param us_id user id required
 * @param shw_id show id.
 * @param pyt_id payment id.
 */
	public void Insertinv(Date dt, Integer seats, Double amt,Integer us_id,Integer shw_id,Integer pyt_id) {
		String state = "Insert INTO k_naik_invoice(inv_date,inv_seats,inv_amt,inv_userid,inv_shwid,payment_id) Values(?,?,?,?,?,?)";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setDate(1, dt);
			sql.setInt(2, seats);
			sql.setDouble(3, amt);
			sql.setInt(4, us_id);
			sql.setInt(5, shw_id);
			sql.setInt(6, pyt_id);

			sql.executeUpdate();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/**
	 * 
	 * @param name name on the card
	 * @param tm timestamp of the class
	 * @return the payment id
	 */
	public ResultSet getpyt_id(String name,Timestamp tm) {
		ResultSet result2 = null;
		String st = "select k_naik_card.card_id from k_naik_card where card_name=? and card_dttime=?  ";

		try {
			sql = connect.getConnection().prepareStatement(st);
			sql.setString(1, name);
			sql.setTimestamp(2, tm);
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

	/**
	 * 
	 * @return the required things for the order details.
	 */
	public ResultSet getRe() {
		ResultSet result2 = null;
		String st = "select fp.k_naik_movies.movie_name,fp.k_naik_shows.show_date,fp.k_naik_shows.show_time,"
				+ "fp.k_naik_shows.show_venue,fp.k_naik_invoice.inv_seats,fp.k_naik_invoice.inv_amt,fp.k_naik_invoice.invoice_id,"
				+ "fp.k_naik_invoice.inv_shwid from fp.k_naik_invoice inner join fp.k_naik_users on "
				+ "fp.k_naik_invoice.inv_userid=fp.k_naik_users.User_id inner join fp.k_naik_shows on fp.k_naik_invoice.inv_shwid=fp.k_naik_shows.show_id inner join fp.k_naik_movies on "
				+ "fp.k_naik_shows.mv_id=fp.k_naik_movies.movie_id;  ";

		try {
			sql = connect.getConnection().prepareStatement(st);
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
	/**
	 * 
	 * @param name used to delete based on the input name.
	 */
	public void deleteinv(Integer name) {
		String state = "Delete from k_naik_invoice where invoice_id=?";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setInt(1, name);
			sql.executeUpdate();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	/**
	 * 
	 * @param id pass the invoice id.
	 * @return the payment id.
	 */
	public ResultSet getp_id(Integer id) {
		ResultSet result2 = null;
		String st = "select k_naik_invoice.payment_id from k_naik_invoice where invoice_id=?  ";

		try {
			sql = connect.getConnection().prepareStatement(st);
			sql.setInt(1, id);
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
	
	/**
	 * 
	 * @param name used to delete the card details based on the name.
	 */
	public void deletept(Integer name) {
		String state = "Delete from k_naik_card where card_id=?";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setInt(1, name);
			sql.executeUpdate();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
/**
 * 
 * @param id the show id.
 * @return the seats in the show.
 */
	public ResultSet getseatsfmdb(Integer id) {
		ResultSet result2 = null;
		String st = "select k_naik_shows.show_seats from k_naik_shows where show_id=?  ";

		try {
			sql = connect.getConnection().prepareStatement(st);
			sql.setInt(1, id);
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
