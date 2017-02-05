package controllers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */

public class Movie_Details_pt2 {

	private final SimpleStringProperty movie_name;
	private final SimpleStringProperty movie_desc;
	private final SimpleDoubleProperty movie_rating;

	// private final SimpleStringProperty movie_date;
	// private final SimpleStringProperty movie_Time;
/**
 * 
 * @param name the name of the movie. 
 * @param descrip the description of the movie.
 * @param rating the rating for the movie.
 */
	Movie_Details_pt2(String name, String descrip, Double rating) {
		this.movie_name = new SimpleStringProperty(name);
		this.movie_desc = new SimpleStringProperty(descrip);
		this.movie_rating = new SimpleDoubleProperty(rating);
	}

	public String getMovie_name() {
		return movie_name.get();
	}

	public String getMovie_desc() {
		return movie_desc.get();
	}

	public double getMovie_rating() {
		return movie_rating.get();
	}

}
