package controllers;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
//import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.AlertDao;
import models.MovieDao;
import models.SelectionDao;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */

public class MovieSelectionController extends UserLoginController implements Initializable, ControlledScreen {

	private static String movie_nm;
	private static String movie_des;
	private static Double movie_rating;
	private static Date show_date;
	private static Time show_time;
	private static String show_venue;
	private static int show_seats;
	private static double show_cost;
	public static double final_cost = 0;
	public static int seats_selected;
	private double cost_ticket;
	public static int send_shwid;
	private static int send_mvid;

	private static int usr_id;

	MovieDao dv = new MovieDao();

	public static int getSend_mvid() {
		return send_mvid;
	}

	public static void setSend_mvid(int send_mvid) {
		MovieSelectionController.send_mvid = send_mvid;
	}

	public static int getUsr_id() {
		return usr_id;
	}

	public static void setUsr_id(int usr_id) {
		MovieSelectionController.usr_id = usr_id;
	}

	public static int getSend_shwid() {
		return send_shwid;
	}

	public static void setSend_shwid(int send_shwid) {
		MovieSelectionController.send_shwid = send_shwid;
	}

	@FXML
	private Label cost_label;

	public int getSeats_selected() {
		return seats_selected;
	}

	public void setSeats_selected(int seats_selected) {
		MovieSelectionController.seats_selected = seats_selected;
	}

	public double getCost_ticket() {
		return cost_ticket;
	}

	public void setCost_ticket(double cost_ticket) {
		this.cost_ticket = cost_ticket;
	}

	public String getMovie_nm() {
		return movie_nm;
	}

	public void setMovie_nm(String movie_nm) {
		MovieSelectionController.movie_nm = movie_nm;
	}

	public String getMovie_des() {
		return movie_des;
	}

	public void setMovie_des(String movie_des) {
		MovieSelectionController.movie_des = movie_des;
	}

	public Double getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(Double movie_rating) {
		MovieSelectionController.movie_rating = movie_rating;
	}

	public Date getShow_date() {
		return show_date;
	}

	public void setShow_date(Date show_date) {
		MovieSelectionController.show_date = show_date;
	}

	public Time getShow_time() {
		return show_time;
	}

	public void setShow_time(Time show_time) {
		MovieSelectionController.show_time = show_time;
	}

	public String getShow_venue() {
		return show_venue;
	}

	public void setShow_venue(String show_venue) {
		MovieSelectionController.show_venue = show_venue;
	}

	public int getShow_seats() {
		return show_seats;
	}

	public void setShow_seats(int show_seats) {
		MovieSelectionController.show_seats = show_seats;
	}

	public double getShow_cost() {
		return show_cost;
	}

	public void setShow_cost(double show_cost) {
		MovieSelectionController.show_cost = show_cost;
	}

	public double getFinal_cost() {
		return final_cost;
	}

	public void setFinal_cost(double final_cost) {
		MovieSelectionController.final_cost = final_cost;
	}

	ObservableList<UserMovieDetails> list = FXCollections.observableArrayList();

	ScreensController myController;

	@FXML
	private JFXButton loadDetaisl;

	SelectionDao mv = new SelectionDao();

	@FXML
	private TableView<UserMovieDetails> tblview;

	@FXML
	private TableColumn<UserMovieDetails, String> mv_name;

	@FXML
	private TableColumn<UserMovieDetails, String> mv_description;

	@FXML
	private TableColumn<UserMovieDetails, Double> mv_rating;

	@FXML
	private TableColumn<UserMovieDetails, String> shw_date;

	@FXML
	private TableColumn<UserMovieDetails, String> shw_time;

	@FXML
	private TableColumn<UserMovieDetails, String> shw_venue;

	@FXML
	private TableColumn<UserMovieDetails, Double> shw_cost;

	@FXML
	private TableColumn<UserMovieDetails, Integer> shw_seats;

	@FXML
	private JFXComboBox<Integer> cmbbox;

	@FXML
	private JFXButton nextbtn;

	@FXML
	void goBack(ActionEvent event) {
		myController.setScreen(ScreensFramework.screen5ID);
	}

	@FXML
	void setLabel(ActionEvent event) {

		int value = cmbbox.getValue();
		setSeats_selected(value);
		double cost = value * getCost_ticket();

		setFinal_cost(cost);
		cost_label.setText("Total Cost: $" + cost);
		// System.out.println(getFinal_cost());
		// System.out.println(cost_label);

	}
/**
 * 
 * @param event go to payment page.
 * @throws SQLException
 */
	@FXML
	void gotoNext(ActionEvent event) throws SQLException {
		ObservableList<UserMovieDetails> getlist = FXCollections.observableArrayList();
		getlist = tblview.getSelectionModel().getSelectedItems();
		if (!(getlist.isEmpty())) {
			setMovie_nm(getlist.get(0).getMovie_name());
			setShow_date(Date.valueOf(getlist.get(0).getMovie_date()));
			setShow_time(Time.valueOf(getlist.get(0).getMovie_Time()));
			setShow_venue(getlist.get(0).getMovie_venue());
			setShow_seats(getlist.get(0).getMovie_seats());
			if ((getShow_seats() - getSeats_selected()) < 0) {
				AlertDao.Display("Unavilable seats", "Seats not available");
			} else {
				ResultSet rs = dv.getid(getMovie_nm());
				while (rs.next()) {
					setSend_mvid((rs.getInt(1)));
				}
				ResultSet rp = dv.getshwId(getSend_mvid(), getShow_date(), getShow_time(), getShow_venue());
				while (rp.next()) {
					setSend_shwid(rp.getInt(1));

				}
			}
		} else {
			AlertDao.Display("Selection Error", "Select movie first");
		}
		if (cmbbox.getValue() != null) {
			myController.setScreen(ScreensFramework.screen10ID);
		} else {
			AlertDao.Display("Selection Alert", "Select number of seats and click next");
		}

	}

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
/**
 * 
 * @param event Load the tickets for the show.
 */
	@FXML
	void LoadTickets(ActionEvent event) {

		cmbbox.getItems().clear();
		ObservableList<UserMovieDetails> loadtkt;
		loadtkt = tblview.getSelectionModel().getSelectedItems();
		setSeats_selected(loadtkt.get(0).getMovie_seats());
		setCost_ticket(loadtkt.get(0).getMovie_cost());

		for (int i = 0; i <= 10; i++) {
			cmbbox.getItems().add(i);

		}
		setUsr_id(getUserid());
	}

	@FXML
	void Load(ActionEvent event) throws SQLException {
		init();
		ResultSet rs = mv.getResult();

		while (rs.next()) {

			String name = rs.getString("movie_name");
			String desc = rs.getString("movie_description");
			Double rating = rs.getDouble("movie_rating");
			Date date = rs.getDate("show_date");
			Time time = rs.getTime("show_time");
			Integer seat = rs.getInt("show_seats");
			String venue = rs.getString("show_venue");
			Double cost = rs.getDouble("show_cost");
			System.out.println();
			list.add(new UserMovieDetails(name, desc, rating, date, time, seat, venue, cost));
		}
		tblview.getItems().setAll(list);
		list.clear();

	}

	private void init() {
		mv_name.setCellValueFactory(new PropertyValueFactory<>("movie_name"));
		mv_description.setCellValueFactory(new PropertyValueFactory<>("movie_descrip"));
		mv_rating.setCellValueFactory(new PropertyValueFactory<>("movie_rating"));
		shw_date.setCellValueFactory(new PropertyValueFactory<>("movie_date"));
		shw_time.setCellValueFactory(new PropertyValueFactory<>("movie_Time"));
		shw_seats.setCellValueFactory(new PropertyValueFactory<>("movie_seats"));
		shw_venue.setCellValueFactory(new PropertyValueFactory<>("movie_venue"));
		shw_cost.setCellValueFactory(new PropertyValueFactory<>("movie_cost"));

	}

}