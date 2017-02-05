package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
/**
 * 
 * @author Kedar Naik
 * @since 2016-12-02
 *
 */
public class LandingPageController implements Initializable, ControlledScreen{

	/**
	 * 
	 */
	ScreensController myController;
	
    @FXML
    private JFXButton user_login;

    @FXML
    private JFXButton admin_login;

    /**
     * 
     * @param event the login button event where it loads the next screen upon
     * button clicked.
     */
    @FXML
    void admin_login(ActionEvent event) {
    	myController.setScreen(ScreensFramework.screen4ID);

    }
/**
 * 
 * @param event event the login button event where it loads the next screen upon
 * button clicked.
 */
    @FXML
    void user_login(ActionEvent event) {
    	myController.setScreen(ScreensFramework.screen2ID);

    }
	
    /**
     * @param screenPage This will set thsi creen to the main screen.
     */
	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
