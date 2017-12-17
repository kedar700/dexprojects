package controllers;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import models.AlertDao;
import models.SelectionDao;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */

public class PaymentController extends MovieSelectionController implements Initializable, ControlledScreen{
	
	SelectionDao sr=new SelectionDao();
	private static String crd_nm;
	private static String crd_num;
	private static int crd_mnt;
	private static int crd_yr;
	private static int crd_cv;
	private static Date date;
	private static int pyt_id;
	private static Timestamp cur_tm;
	
		public static Timestamp getCur_tm() {
		return cur_tm;
	}

	public static void setCur_tm(Timestamp cur_tm) {
		PaymentController.cur_tm = cur_tm;
	}

		public static int getPyt_id() {
		return pyt_id;
	}

	public static void setPyt_id(int pyt_id) {
		PaymentController.pyt_id = pyt_id;
	}

		public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		PaymentController.date = date;
	}

		public static String getCrd_nm() {
		return crd_nm;
	}

	public static void setCrd_nm(String crd_nm) {
		PaymentController.crd_nm = crd_nm;
	}

	public static String getCrd_num() {
		return crd_num;
	}

	public static void setCrd_num(String crd_num) {
		PaymentController.crd_num = crd_num;
	}

	public static int getCrd_mnt() {
		return crd_mnt;
	}

	public static void setCrd_mnt(int crd_mnt) {
		PaymentController.crd_mnt = crd_mnt;
	}

	public static int getCrd_yr() {
		return crd_yr;
	}

	public static void setCrd_yr(int crd_yr) {
		PaymentController.crd_yr = crd_yr;
	}

	public static int getCrd_cv() {
		return crd_cv;
	}

	public static void setCrd_cv(int crd_cv) {
		PaymentController.crd_cv = crd_cv;
	}

		MovieSelectionController cr= new MovieSelectionController();
		ScreensController myController;
		@FXML
	    private JFXTextField crd_name;

	    @FXML
	    private JFXTextField crd_number;

	    @FXML
	    private JFXComboBox<Integer> crd_month;

	    @FXML
	    private JFXComboBox<Integer> crd_year;

	    @FXML
	    private JFXButton showbtn;

	    @FXML
	    private Label setFinalCost;

	    @FXML
	    private JFXTextField card_cvv;
	
	@FXML
	void goBack3(ActionEvent event) {
		myController.setScreen(ScreensFramework.screen7ID);
	}

	@FXML
	void keytyped(KeyEvent event) {
		String key = event.getCharacter();
		if (!key.isEmpty() && !(Character.isDigit(key.charAt(0)))) {
			event.consume();
		}
	}

	@FXML
	void setCostLabel(ActionEvent event) {
		crd_month.getItems().clear();
		crd_year.getItems().clear();
		for (int i = 1; i <= 12; i++) {
			crd_month.getItems().add(i);
		}
		for (int i = 2016; i <= 2026; i++) {
			crd_year.getItems().add(i);
		}
		System.out.println(getFinal_cost());
		setFinalCost.setText("Final Payable Value: $" +getFinal_cost());
	}
/**
 * 
 * @param event used to submit the payment button.
 * @throws SQLException
 */
	@FXML
	void submitPayment(ActionEvent event) throws SQLException {
		if(!(crd_name.getText().isEmpty() && crd_number.getText().isEmpty() && card_cvv.getText().isEmpty() )){
			setCrd_nm(crd_name.getText());
			setCrd_num((crd_number.getText()));
			setCrd_cv(Integer.parseInt(card_cvv.getText()));
			setCrd_mnt(crd_month.getValue());
			setCrd_yr(crd_year.getValue());
			LocalDateTime pt=LocalDateTime.now();
			setCur_tm(Timestamp.valueOf(pt));
			sr.Insertdt(getCrd_nm(), getCrd_num(), getCrd_yr(), getCrd_mnt(), getCrd_cv(),getCur_tm());
			ResultSet rs=sr.getpyt_id(getCrd_nm(), getCur_tm());
			if(rs.next()){
				setPyt_id(rs.getInt(1));
			}
			int vr=getShow_seats()-getSeats_selected();
			setShow_seats(vr);
			sr.updatedta(getShow_seats(), getSend_shwid());
			LocalDate dt=LocalDate.now();
			setDate(Date.valueOf(dt));
			sr.Insertinv(getDate(), getSeats_selected(), getFinal_cost(), getUsr_id(), getSend_shwid(), getPyt_id());
			myController.setScreen(ScreensFramework.screen11ID);
	}else{
		AlertDao.Display("Incorrect credentials", "Please enter all the fields correctly");
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
}
