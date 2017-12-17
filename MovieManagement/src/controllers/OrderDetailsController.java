package controllers;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.AlertDao;
import models.SelectionDao; 

/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 * The controller for the orders page and used accordingly.
 */

public class OrderDetailsController implements Initializable, ControlledScreen {
	ScreensController myController;
	ObservableList<OrdFinalDetails> list = FXCollections.observableArrayList();
	SelectionDao sr=new SelectionDao();
	
	private static int grshw_id;
	private static int seatsdb;
	private static int seatstb;
	private static int invid;
	private static int payment_id;
	public static int getGrshw_id() {
		return grshw_id;
	}

	public static void setGrshw_id(int grshw_id) {
		OrderDetailsController.grshw_id = grshw_id;
	}

	public static int getSeatsdb() {
		return seatsdb;
	}

	public static void setSeatsdb(int seatsdb) {
		OrderDetailsController.seatsdb = seatsdb;
	}

	public static int getSeatstb() {
		return seatstb;
	}

	public static void setSeatstb(int seatstb) {
		OrderDetailsController.seatstb = seatstb;
	}

	public static int getPayment_id() {
		return payment_id;
	}

	public static void setPayment_id(int payment_id) {
		OrderDetailsController.payment_id = payment_id;
	}

	public static int getInvid() {
		return invid;
	}

	public static void setInvid(int invid) {
		OrderDetailsController.invid = invid;
	}

	@FXML
    private TableView<OrdFinalDetails> tblview;

    @FXML
    private TableColumn<OrdFinalDetails, String> mv_name;

    @FXML
    private TableColumn<OrdFinalDetails, String> mv_date;

    @FXML
    private TableColumn<OrdFinalDetails, String> mv_time;

    @FXML
    private TableColumn<OrdFinalDetails, Integer> mv_seats;

    @FXML
    private TableColumn<OrdFinalDetails, String> mv_venue;

    @FXML
    private TableColumn<OrdFinalDetails, Double> mv_cost;

    @FXML
    private TableColumn<OrdFinalDetails, Integer> order_id;

    @FXML
    private TableColumn<OrdFinalDetails, Integer> show_id;

    @FXML
    private JFXButton loadDetaisl;

    @FXML
    private JFXButton deleteOrd;
/**
 * 
 * @param event used to load the movies.
 * @throws SQLException sql exceptions.
 */
    @FXML
    void Load(ActionEvent event) throws SQLException {
    	init();
    	//System.out.println("This is running");
    	ResultSet rs=sr.getRe();
    	while(rs.next()){
    		String name=rs.getString("movie_name");
    		Date date=rs.getDate("show_date");
    		Time tm=rs.getTime("show_time");
    		String venue=rs.getString("show_venue");
    		Integer sts=rs.getInt("inv_seats");
    		Double cts=rs.getDouble("inv_amt");
    		Integer id=rs.getInt("invoice_id");
    		Integer sid=rs.getInt("inv_shwid");
    		list.add(new OrdFinalDetails(name, date, tm, sts, venue, cts, id, sid));
    	}
//    	while(!(rs.next())){
//    		AlertDao.Display("Invalid Credentials", "Not Valid Credentials");
//    		
//    	}
    tblview.getItems().setAll(list);
    list.clear();
    }
/**
 * 
 * @param event used to delete orders.
 */
    @FXML
    void deleteOrd(ActionEvent event)  {
    	ObservableList<OrdFinalDetails> deletelist = FXCollections.observableArrayList();
    	deletelist = tblview.getSelectionModel().getSelectedItems();
    	setInvid(deletelist.get(0).getOrder_id());
    	setGrshw_id(deletelist.get(0).getShow_id());
    	setSeatstb(deletelist.get(0).getMovie_seats());
    	ResultSet pq=sr.getseatsfmdb(getGrshw_id());
    	ResultSet rs=sr.getp_id(getInvid());
    	try {
    		while(pq.next()){
    			
    			setSeatsdb(pq.getInt(1));
    			int qw=getSeatsdb()+getSeatstb();
    			setSeatsdb(qw);
    			sr.updatedta(getSeatsdb(), getGrshw_id());
    		}
    		
			while( rs.next()){
				setPayment_id(rs.getInt(1));
			}
			sr.deleteinv(getInvid());
	    	sr.deletept(getPayment_id());
	    	Load(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AlertDao.Display("No orders", "No Orders for now");
		}
    	
    }
/**
 * 
 * @param event used to go home.
 */
    @FXML
    void goHome(ActionEvent event) {
    	myController.setScreen(ScreensFramework.screen5ID);
    }
/**
 * 
 * @param event logout event.
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

	private void init() {
		mv_name.setCellValueFactory(new PropertyValueFactory<>("movie_name"));
		mv_date.setCellValueFactory(new PropertyValueFactory<>("movie_date"));
		mv_time.setCellValueFactory(new PropertyValueFactory<>("movie_Time"));
		mv_seats.setCellValueFactory(new PropertyValueFactory<>("movie_seats"));
		mv_venue.setCellValueFactory(new PropertyValueFactory<>("movie_venue"));
		mv_cost.setCellValueFactory(new PropertyValueFactory<>("movie_cost"));
		order_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
		show_id.setCellValueFactory(new PropertyValueFactory<>("show_id"));

	}
	

}