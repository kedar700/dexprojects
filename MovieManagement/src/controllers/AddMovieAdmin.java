package controllers;

import java.net.URL;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

//import javafx.beans.property.SimpleListProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.MovieDao;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class AddMovieAdmin implements Initializable, ControlledScreen {

	ObservableList<Movie_Details_pt2> list = FXCollections.observableArrayList();

	ScreensController myController;

	/**
	 * 
	 * @param event event when the button is clicked and to redirect.
	 */
	@FXML
	void Logout(ActionEvent event) {
		myController.setScreen(ScreensFramework.screen1ID);
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		myController = screenPage;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	MovieDao mv = new MovieDao();
	private String movie_name;
	private String movie_descrip;
	private Double movie_rating;
	private String prvStr;
	private String itStr;

	public String getItStr() {
		return itStr;
	}

	public void setItStr(String itStr) {
		this.itStr = itStr;
	}

	public String getPrvStr() {
		return prvStr;
	}

	public void setPrvStr(String prvStr) {
		this.prvStr = prvStr;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getMovie_descrip() {
		return movie_descrip;
	}

	public void setMovie_descrip(String movie_descrip) {
		this.movie_descrip = movie_descrip;
	}

	public Double getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(Double movie_rating) {
		this.movie_rating = movie_rating;
	}

	@FXML
	private JFXTextField movie_nm;

	@FXML
	private JFXTextField movie_rt;

	@FXML
	private JFXTextArea movie_des;

	@FXML
	private TableView<Movie_Details_pt2> tblview;

	@FXML
	private TableColumn<Movie_Details_pt2, String> mv_name;

	@FXML
	private TableColumn<Movie_Details_pt2, String> mv_des;

	@FXML
	private TableColumn<Movie_Details_pt2, Double> mv_rt;

	/**
	 * 
	 * @param event used to add the movie to the movie database.
	 * @throws SQLException add the sqlexception to the table.
	 */
	@FXML
	void Add_movie(ActionEvent event) throws SQLException {
		setMovie_name(movie_nm.getText());
		setMovie_descrip(movie_des.getText());
		setMovie_rating(Double.parseDouble(movie_rt.getText()));
		mv.Insertdata(getMovie_name(), getMovie_descrip(), getMovie_rating());
		System.out.println(getMovie_rating());
		movie_nm.clear();
		movie_des.clear();
		movie_rt.clear();
		Load_Details(event);
	}
/**
 * 
 * @param event used to delete the movie.
 * @throws SQLException throw the sql exception.
 */
	@FXML
	void Delete_Movie(ActionEvent event) throws SQLException {
		ObservableList<Movie_Details_pt2> deletelist;
		deletelist = tblview.getSelectionModel().getSelectedItems();
		String deleteval = deletelist.get(0).getMovie_name();
		mv.deletedata(deleteval);
		Load_Details(event);
	}
/**
 * 
 * @param event Used to modify the details in the table.
 * @throws SQLException used to pass the exception.
 */
	@FXML
	void Modify_movie(ActionEvent event) throws SQLException {
		ObservableList<Movie_Details_pt2> updatelist;
		updatelist = tblview.getSelectionModel().getSelectedItems();
		String nameval = updatelist.get(0).getMovie_name();
		String descval = updatelist.get(0).getMovie_desc();
		Double rating = updatelist.get(0).getMovie_rating();
		movie_nm.setText(nameval);
		movie_des.setText(descval);
		movie_rt.setText(rating.toString());
		setPrvStr(nameval);
		ResultSet rs = mv.getid(getPrvStr());
		while (rs.next()) {
			setItStr(rs.getString(1));
			// System.out.println(getItStr());
		}

	}
/**
 * 
 * @param event used to update the movie details.
 * @throws SQLException used to through sql exception.
 */
	@FXML
	void Update_movie(ActionEvent event) throws SQLException {

		setMovie_name(movie_nm.getText());
		setMovie_descrip(movie_des.getText());
		setMovie_rating(Double.parseDouble(movie_rt.getText()));

		mv.updatedata(getMovie_name(), getMovie_descrip(), getMovie_rating(), getItStr());
		movie_nm.clear();
		movie_des.clear();
		movie_rt.clear();
		Load_Details(event);

	}
	
	 @FXML
	    void goBack(ActionEvent event) {
		 myController.setScreen(ScreensFramework.screen6ID);
	    }

	@FXML
	private JFXButton loadDetaisl;
/**
 * 
 * @param event used to load the details in the tableview
 * @throws SQLException
 */
	@FXML
	void Load_Details(ActionEvent event) throws SQLException {
		init();
		ResultSet rs = mv.getMovies();
		while (rs.next()) {
			String name = rs.getString("movie_name");
			String desc = rs.getString("movie_description");
			Double rting = rs.getDouble("movie_rating");
			list.add(new Movie_Details_pt2(name, desc, rting));
		}
		tblview.getItems().setAll(list);
		list.clear();
	}

	private void init() {
		mv_name.setCellValueFactory(new PropertyValueFactory<>("movie_name"));
		mv_des.setCellValueFactory(new PropertyValueFactory<>("movie_desc"));
		mv_rt.setCellValueFactory(new PropertyValueFactory<>("movie_rating"));

	}

}