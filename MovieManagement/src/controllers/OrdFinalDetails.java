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
 *Order details for the movie.
 */

public class OrdFinalDetails {

	private final SimpleStringProperty movie_name;
	private final SimpleStringProperty movie_date;
	private final SimpleStringProperty movie_Time;	
	private final SimpleIntegerProperty movie_seats;
	private final SimpleStringProperty movie_venue;
	private final SimpleDoubleProperty movie_cost;
	private final SimpleIntegerProperty order_id;
	private final SimpleIntegerProperty show_id;
	
	OrdFinalDetails(String name, Date date, Time time, int seat, String venue, Double cost, Integer order, Integer show) {
		this.movie_name = new SimpleStringProperty(name);
//		this.movie_date = new SimpleStringProperty(date);
//		this.movie_Time = new SimpleStringProperty(time);
		
		this.movie_date = new SimpleStringProperty(date.toString());
		this.movie_Time = new SimpleStringProperty(time.toString());
		this.movie_seats = new SimpleIntegerProperty(seat);
		this.movie_venue = new SimpleStringProperty(venue);
		this.movie_cost = new SimpleDoubleProperty(cost);
		this.order_id=new SimpleIntegerProperty(order);
		this.show_id=new SimpleIntegerProperty(show);
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

	public int getOrder_id() {
		return order_id.get();
	}
	public int getShow_id() {
		return show_id.get();
	}
	
	
}
	
	

	


