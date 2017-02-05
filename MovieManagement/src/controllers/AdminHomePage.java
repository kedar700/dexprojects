package controllers;

import java.net.URL; 
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 */
public class AdminHomePage implements Initializable, ControlledScreen{
	 
	
	/**
	 * 
	 */
	ScreensController myController;

	/**
	 * 
	 * @param event the logout button event where it loads the next screen upon
     * button clicked.
	 */
		@FXML
		void Logout(ActionEvent event) {
			myController.setScreen(ScreensFramework.screen1ID);
		}

		/**
		 * @param this will set the screenpage to the main page.
		 */
		@Override
		public void setScreenParent(ScreensController screenPage) {
			
			myController = screenPage;
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

	   

	    @FXML
	    private JFXButton show_add;

	    @FXML
	    private JFXButton Add_Movie;
/**
 * 
 * @param eventthe admin movie button event where it loads the next screen upon
     * button clicked.
 */
	    @FXML
	    void admin_movie(ActionEvent event) {
	    	myController.setScreen(ScreensFramework.screen8ID);
	    }
/**
 * 
 * @param event the admin show button event where it loads the next screen upon
     * button clicked.
 */
	    @FXML
	    void admin_show(ActionEvent event) {
	    	myController.setScreen(ScreensFramework.screen9ID);
	    }

}
