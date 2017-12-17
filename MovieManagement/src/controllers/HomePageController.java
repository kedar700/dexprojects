package controllers;

import java.net.URL; 
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class HomePageController implements Initializable, ControlledScreen{
	 
	
	
	ScreensController myController;

		@FXML
		void Logout(ActionEvent event) {
			myController.setScreen(ScreensFramework.screen1ID);
		}

		@Override
		public void setScreenParent(ScreensController screenPage) {
			
			myController = screenPage;
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}
		 	
		    @FXML
		    void gotoOrder(ActionEvent event) {
		    	myController.setScreen(ScreensFramework.screen11ID);
		    }

		    @FXML
		    void gotoShow(ActionEvent event) {
		    	myController.setScreen(ScreensFramework.screen7ID);
		    }

}
