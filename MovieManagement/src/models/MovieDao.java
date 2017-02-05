package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class MovieDao {

	Connector connect = new Connector();
	private PreparedStatement sql = null;
/**
 * 
 * @return will return if the required objects are found.
 */
	public ResultSet getResultset() {

		ResultSet result = null;
		try {
			String state = "select k_naik_movies.movie_name,k_naik_shows.show_date,"
					+ "k_naik_shows.show_time,k_naik_shows.show_seats,k_naik_shows.show_venue,"
					+ "k_naik_shows.show_cost from fp.k_naik_shows inner join k_naik_movies on "
					+ "k_naik_shows.mv_id=k_naik_movies.movie_id";
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
 * 
 * @return will return the movies from the movie table if the required things are found.
 */
	public ResultSet getMovies() {
		ResultSet result2 = null;
		String st = "select k_naik_movies.movie_name,k_naik_movies.movie_description,k_naik_movies.movie_rating from k_naik_movies";

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
 * @param mv_name the movie name
 * @param desc the description of the movie.
 * @param rating the rating for the movie.
 */
	public void Insertdata(String mv_name, String desc, Double rating) {
		String state = "Insert INTO k_naik_movies(movie_name,movie_description,movie_rating) Values(?,?,?)";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setString(1, mv_name);
			sql.setString(2, desc);
			sql.setDouble(3, rating);

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
	 * @param used to delete the movie from the database.
	 */
	public void deletedata(String name) {
		String state = "Delete from k_naik_movies where movie_name=?";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setString(1, name);
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
 * @param name the name of the movie
 * @param desc the description of the movie
 * @param rating the rating of the movie.
 * @param idStr The movie id.
 * Used to update the movie details.
 */
	public void updatedata(String name, String desc, Double rating, String idStr) {
		String state = "Update k_naik_movies set movie_name=?,movie_description=?,movie_rating=? where movie_id=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setString(1, name);
			sql.setString(2, desc);
			sql.setDouble(3, rating);
			sql.setString(4, idStr);
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
 * @param mname the movie name.
 * @return used to return the id of the movie.
 */
	public ResultSet getid(String mname) {
		ResultSet result2 = null;
		String st = "select k_naik_movies.movie_id from k_naik_movies where movie_name=?";

		try {
			sql = connect.getConnection().prepareStatement(st);
			sql.setString(1, mname);
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
	 * @return
	 */
	public ResultSet getmvid() {
		ResultSet result2 = null;
		String st = "select k_naik_movies.movie_name from k_naik_movies";

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
 *  Used to add the show.
 * @param mv_id id of the movie.
 * @param date date of the show.
 * @param time Time of the show
 * @param seats seats required 
 * @param venue venue for the movie
 * @param cost cost of the movie.
 */
	public void Insertshow(Integer mv_id, Date date, Time time, Integer seats, String venue, Double cost) {
		String state = "Insert INTO k_naik_shows(show_date,show_time,show_seats,show_venue,show_cost,mv_id) Values(?,?,?,?,?,?)";
		// String state="Select email_id,password,isAdmin from k_naik_users
		// where email_id= ? and password= ? and isAdmin=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setDate(1, date);
			sql.setTime(2, time);
			sql.setInt(3, seats);
			sql.setString(4, venue);
			sql.setDouble(5, cost);
			sql.setInt(6, mv_id);

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
 * @param dt Date of the show.
 * @param tm time for the show.
 * @param mv_id id for the show
 * Used to delete the show.
 */
	public void deleteshow(Date dt, Time tm, Integer mv_id) {
		String state = "Delete from k_naik_shows where show_date=? and show_time=? and mv_id=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setDate(1, dt);
			sql.setTime(2, tm);
			sql.setInt(3, mv_id);
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
 * @param mv_id id of teh movie.
 * @param dt date of teh movie.
 * @param tm time for the movie.
 * @param venue venue of teh movie.
 * @return will return the id of the show.
 */
	public ResultSet getshwId(Integer mv_id,Date dt,Time tm,String venue)
	{
		ResultSet result2 = null;
		String st = "select k_naik_shows.show_id from k_naik_shows where show_date=? and show_time=? and show_venue=? and mv_id=?";

		try {
			sql = connect.getConnection().prepareStatement(st);
			sql.setDate(1, dt);
			sql.setTime(2, tm);
			sql.setString(3, venue);
			sql.setInt(4, mv_id);
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
 * @param show_id id of the show
 * @param dt date of the show
 * @param tm time of the show
 * @param seats seats of the show
 * @param venue venue for the show
 * @param cost cost for the show
 * @param movieid id for the show
 */
	public void updateshow(Integer show_id, Date dt, Time tm, Integer seats,String venue,Double cost, Integer movieid) {
		String state = "Update k_naik_shows set show_date=?,show_time=?,show_seats=?,show_venue=?,show_cost=?,mv_id=? where show_id=?";
		try {
			sql = connect.getConnection().prepareStatement(state);
			sql.setDate(1,dt);
			sql.setTime(2, tm);
			sql.setInt(3, seats);
			sql.setString(4, venue);
			sql.setDouble(5, cost);
			sql.setInt(6,movieid);
			sql.setInt(7, show_id);
			sql.executeUpdate();
			// sql.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
