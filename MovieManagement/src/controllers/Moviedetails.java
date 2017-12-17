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
 *
 */

public class Moviedetails {

	private final SimpleStringProperty movie_name;
	private final SimpleStringProperty movie_date;
	private final SimpleStringProperty movie_Time;
	
//	private final SimpleStringProperty movie_date;
//	private final SimpleStringProperty movie_Time;
	
	private final SimpleIntegerProperty movie_seats;
	private final SimpleStringProperty movie_venue;
	private final SimpleDoubleProperty movie_cost;
/**
 * 
 * @param name the name of the movie
 * @param date teh date of the show
 * @param time teh time for the show
 * @param seat the seats for the show
 * @param venue teh venue for the show
 * @param cost teh cost for the show
 */
	Moviedetails(String name, Date date, Time time, int seat, String venue, Double cost) {
		this.movie_name = new SimpleStringProperty(name);
//		this.movie_date = new SimpleStringProperty(date);
//		this.movie_Time = new SimpleStringProperty(time);
		
		this.movie_date = new SimpleStringProperty(date.toString());
		this.movie_Time = new SimpleStringProperty(time.toString());
		this.movie_seats = new SimpleIntegerProperty(seat);
		this.movie_venue = new SimpleStringProperty(venue);
		this.movie_cost = new SimpleDoubleProperty(cost);
	}

	public String getMovie_name() {
		return movie_name.get();
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
	
	

	


