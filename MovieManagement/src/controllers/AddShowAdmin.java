package controllers;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
//import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import models.AlertDao;
import models.MovieDao;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class AddShowAdmin implements Initializable, ControlledScreen {

	ObservableList<Moviedetails> list = FXCollections.observableArrayList();

	ScreensController myController;
	private String movie_nme;
	private Date movie_dte;
	private Time movie_tme;
	private Integer movie_sets;
	private String movie_venu;
	private Double movie_ct;
	private Integer movie_id;
	private Integer show_id;

	public Integer getShow_id() {
		return show_id;
	}

	public void setShow_id(Integer show_id) {
		this.show_id = show_id;
	}

	public Integer getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Integer movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovie_nme() {
		return movie_nme;
	}

	public void setMovie_nme(String movie_nme) {
		this.movie_nme = movie_nme;
	}

	public Date getMovie_dte() {
		return movie_dte;
	}

	public void setMovie_dte(Date movie_dte) {
		this.movie_dte = movie_dte;
	}

	public Time getMovie_tme() {
		return movie_tme;
	}

	public void setMovie_tme(Time movie_tme) {
		this.movie_tme = movie_tme;
	}

	public Integer getMovie_sets() {
		return movie_sets;
	}

	public void setMovie_sets(Integer movie_sets) {
		this.movie_sets = movie_sets;
	}

	public String getMovie_venu() {
		return movie_venu;
	}

	public void setMovie_venu(String movie_venu) {
		this.movie_venu = movie_venu;
	}

	public Double getMovie_ct() {
		return movie_ct;
	}

	public void setMovie_ct(Double movie_ct) {
		this.movie_ct = movie_ct;
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

	@FXML
	void goBack(ActionEvent event) {
		myController.setScreen(ScreensFramework.screen6ID);
	}

	MovieDao mv = new MovieDao();

	@FXML
	private JFXDatePicker movie_tm;

	@FXML
	private JFXTextField movie_sts;

	@FXML
	private JFXTextField movie_vnu;

	@FXML
	private JFXTextField movie_cst;

	@FXML
	private JFXDatePicker shw_date;

	@FXML
	private ChoiceBox<String> movie_name = new ChoiceBox<>(); // check for
																// validation

	@FXML
	private TableView<Moviedetails> tblview;

	@FXML
	private TableColumn<Moviedetails, String> mv_name;

	@FXML
	private TableColumn<Moviedetails, String> mv_date;

	@FXML
	private TableColumn<Moviedetails, String> mv_time;

	@FXML
	private TableColumn<Moviedetails, Integer> mv_seats;

	@FXML
	private TableColumn<Moviedetails, String> mv_venue;

	@FXML
	private TableColumn<Moviedetails, Double> mv_cost;

	/**
	 * 
	 * @param event used to add the show.
	 * @throws SQLException used to passs the sql exception.
	 */
	@FXML
	void Add_Show(ActionEvent event) throws SQLException {
		setMovie_nme(movie_name.getValue());
		ResultSet rs = mv.getid(getMovie_nme());
		while (rs.next()) {
			setMovie_id(rs.getInt(1));
		}
		setMovie_dte(Date.valueOf(shw_date.getValue()));
		setMovie_tme(Time.valueOf(movie_tm.getTime()));
		setMovie_sets(Integer.parseInt(movie_sts.getText()));
		setMovie_venu(movie_vnu.getText());
		setMovie_ct(Double.parseDouble(movie_cst.getText()));
		if (getMovie_id() != null && getMovie_dte() != null && getMovie_tme() != null && getMovie_sets() != null
				&& getMovie_ct() != null && getMovie_venu() != null) {
			mv.Insertshow(getMovie_id(), getMovie_dte(), getMovie_tme(), getMovie_sets(), getMovie_venu(),
					getMovie_ct());
			Load_Details(event);
		} else {
			AlertDao.Display("Information Incorrect", "Enter all information correctly");
		}
	}
/**
 * 
 * @param event used to delete the show.
 * @throws SQLException throws the sql exception.
 */
	@FXML
	void Delete_Show(ActionEvent event) throws SQLException {
		ObservableList<Moviedetails> deletelist;
		deletelist = tblview.getSelectionModel().getSelectedItems();
		String deleteval = deletelist.get(0).getMovie_name();
		ResultSet rs = mv.getid(deleteval);
		while (rs.next()) {
			setMovie_id(rs.getInt(1));
			String date = deletelist.get(0).getMovie_date();
			setMovie_dte(Date.valueOf(date));
			String time = deletelist.get(0).getMovie_Time();
			setMovie_tme(Time.valueOf(time));
			mv.deleteshow(getMovie_dte(), getMovie_tme(), getMovie_id());
		}
		Load_Details(event);
	}
/**
 * 
 * @param event used to modify the show.
 * @throws SQLException throws sql exception.
 */
	@FXML
	void Modify_Show(ActionEvent event) throws SQLException {
		ObservableList<Moviedetails> updatelist;
		updatelist = tblview.getSelectionModel().getSelectedItems();
		String nameval = updatelist.get(0).getMovie_name();
		movie_name.setValue(nameval);
		String date1 = updatelist.get(0).getMovie_date();
		String time = updatelist.get(0).getMovie_Time();
		int seats = updatelist.get(0).getMovie_seats();
		String venue = updatelist.get(0).getMovie_venue();
		Double cost = updatelist.get(0).getMovie_cost();
		setMovie_nme(nameval);
		setMovie_dte(Date.valueOf(date1));
		setMovie_tme(Time.valueOf(time));
		setMovie_venu(venue);
		ResultSet rs2 = mv.getid(getMovie_nme());
		while (rs2.next()) {
			setMovie_id(rs2.getInt(1));
		}

		ResultSet rs = mv.getshwId(getMovie_id(), getMovie_dte(), getMovie_tme(), getMovie_venu());
		while (rs.next()) {
			setShow_id(rs.getInt(1));
			System.out.println(getShow_id());
		}
		movie_sts.setText(String.valueOf(seats));
		movie_vnu.setText(venue);
		movie_cst.setText(String.valueOf(cost));

		shw_date.setValue(getMovie_dte().toLocalDate());
		movie_tm.setTime(getMovie_tme().toLocalTime());
	}
/**
 * 
 * @param event Used to update the show.
 * @throws SQLException throw the sql exception.
 */
	@FXML
	void Update_Show(ActionEvent event) throws SQLException {
		setMovie_nme(movie_name.getValue());
		setMovie_dte(Date.valueOf(shw_date.getValue()));
		setMovie_tme(Time.valueOf(movie_tm.getTime()));
		setMovie_sets(Integer.parseInt(movie_sts.getText()));
		setMovie_venu(movie_vnu.getText());
		setMovie_ct(Double.parseDouble(movie_cst.getText()));
		ResultSet rs = mv.getid(getMovie_nme());
		while (rs.next()) {
			setMovie_id(rs.getInt(1));
		}

		mv.updateshow(getShow_id(), getMovie_dte(), getMovie_tme(), getMovie_sets(), getMovie_venu(), getMovie_ct(),
				getMovie_id());
		Load_Details(event);
	}

	@FXML
	void dateAction(ActionEvent event) {

	}
/**
 * 
 * @throws SQLException used to fill the sqlexception.
 */
	@FXML
	void fillbox() throws SQLException {

		ObservableList<String> list2 = FXCollections.observableArrayList();
		ResultSet rs;
		rs = mv.getmvid();
		while (rs.next()) {
			list2.add(rs.getString(1));
		}
		movie_name.setItems(list2);

	}

	@FXML
	private JFXButton loadDetaisl;
/**
 * 
 * @param event load the details in the table.
 * @throws SQLException throw the sql exception.
 */
	@FXML
	void Load_Details(ActionEvent event) throws SQLException {
		init();
		ResultSet rs = mv.getResultset();

		while (rs.next()) {

			String name = rs.getString("movie_name");
			Date date = rs.getDate("show_date");
			Time time = rs.getTime("show_time");
			Integer seat = rs.getInt("show_seats");
			String venue = rs.getString("show_venue");
			Double cost = rs.getDouble("show_cost");
			list.add(new Moviedetails(name, date, time, seat, venue, cost));
		}
		tblview.getItems().setAll(list);
		fillbox();
		list.clear();
		movie_cst.clear();
		movie_sts.clear();
		movie_vnu.clear();
	}

	@FXML
	void movie_act(ActionEvent event) {

	}

	private void init() {
		mv_name.setCellValueFactory(new PropertyValueFactory<>("movie_name"));
		mv_date.setCellValueFactory(new PropertyValueFactory<>("movie_date"));
		mv_time.setCellValueFactory(new PropertyValueFactory<>("movie_Time"));
		mv_seats.setCellValueFactory(new PropertyValueFactory<>("movie_seats"));
		mv_venue.setCellValueFactory(new PropertyValueFactory<>("movie_venue"));
		mv_cost.setCellValueFactory(new PropertyValueFactory<>("movie_cost"));
	}
	
	@FXML
	void keytyped(KeyEvent event) {
		String key = event.getCharacter();
		if (!key.isEmpty() && !(Character.isDigit(key.charAt(0)))) {
			event.consume();
		}
	}


}