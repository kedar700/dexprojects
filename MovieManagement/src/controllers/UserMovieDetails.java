package controllers;

import java.sql.Date; 
import java.sql.Time;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *Used for the tableview in the controller.
 */

public class UserMovieDetails {

	private final SimpleStringProperty movie_name;
	private final SimpleStringProperty movie_descrip;
	private final SimpleDoubleProperty movie_rating;
	private final SimpleStringProperty movie_date;
	private final SimpleStringProperty movie_Time;
	private final SimpleIntegerProperty movie_seats;
	private final SimpleStringProperty movie_venue;
	private final SimpleDoubleProperty movie_cost;

	UserMovieDetails(String name, String descrip,Double rating,Date date, Time time, int seat, String venue, Double cost) {
		this.movie_name = new SimpleStringProperty(name);
		this.movie_descrip=new SimpleStringProperty(descrip);
		this.movie_rating=new SimpleDoubleProperty(rating);
		this.movie_date = new SimpleStringProperty(date.toString());
		this.movie_Time = new SimpleStringProperty(time.toString());
		this.movie_seats = new SimpleIntegerProperty(seat);
		this.movie_venue = new SimpleStringProperty(venue);
		this.movie_cost = new SimpleDoubleProperty(cost);
	}

	public String getMovie_name() {
		return movie_name.get();
	}
	public String getMovie_descrip() {
		return movie_descrip.get();
	}

	public double getMovie_rating(){
		return movie_rating.get();
	}
	public String getMovie_date() {
		return movie_date.get();
	}

	public String getMovie_Time() {
		return movie_Time.get();
	}

	public int getMovie_seats() {
		return movie_seats.get();
	}

	public String getMovie_venue() {
		return movie_venue.get();
	}

	public double getMovie_cost() {
		return movie_cost.get();
	}

}
	
	

	


