package controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.AlertDao;
import models.LoginDao;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */
public class AdminController implements Initializable, ControlledScreen{

	ScreensController myController;
	
	private String Adminuser;
	private String Adminpass;
    
	public String getAdminuser() {
		return Adminuser;
	}

	public void setAdminuser(String adminuser) {
		Adminuser = adminuser;
	}

	public String getAdminpass() {
		return Adminpass;
	}

	public void setAdminpass(String adminpass) {
		Adminpass = adminpass;
	}

	@FXML
    private JFXTextField admin_user;

    @FXML
    private JFXPasswordField admin_pass;

    @FXML
    private JFXButton Admin_login;

    LoginDao logindata=new LoginDao();
   /**
    *  
    * @param event used for admin login
    * @throws SQLException throw SQL exceptionn
    */
    @FXML
    void Admin_Login(ActionEvent event) throws SQLException {
    setAdminuser(admin_user.getText());
    setAdminpass(admin_pass.getText());
    
    ResultSet rs =logindata.getResult(getAdminuser(), getAdminpass(),"yes");
    	if(rs.next()){
    		myController.setScreen(ScreensFramework.screen6ID);
    	System.out.println("[LOG] Admin Login Successful");
    	}else{
    		
    		AlertDao.Display("Incorrect credentials", "Incorrect Username and/Or Password");
    		System.out.println("Invalid Login");	
    	}
    	admin_user.clear();
    	admin_pass.clear();
    }
    
    /**
     * 
     * @param event go back to the previous screen.
     */
    @FXML
    void goBack(ActionEvent event) {
	  myController.setScreen(ScreensFramework.screen1ID);
    }
    
	@Override
	public void setScreenParent(ScreensController screenPage) {
		// TODO Auto-generated method stub
		myController = screenPage;
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("");
	}

}
