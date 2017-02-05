package controllers;

import java.io.IOException;   
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


public class UserLoginController  implements Initializable, ControlledScreen{

	ScreensController myController;

	private String user;
	private String pass;
	private static int userid;
	
    public static int getUserid() {
		return userid;
	}

	public static void setUserid(int userid) {
		UserLoginController.userid = userid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@FXML
    private JFXTextField user_field;

    @FXML
    private JFXPasswordField user_pass;

    @FXML
    private JFXButton user_login;

    @FXML
    private JFXButton user_signup;
    
    LoginDao logindata=new LoginDao();
   /**
    *  
    * @param event used to set the login event.
    * @throws IOException set IOexception
    * @throws SQLException set SQL Exception
    */
    @FXML
    void LoginCon(ActionEvent event) throws IOException, SQLException {
    	setUser(user_field.getText());
    	setPass(user_pass.getText());	
    	
    	ResultSet rs =logindata.getResult(getUser(), getPass(),"No");
    			if(rs.next()){
    				
    				ResultSet pr=logindata.getusrid(getUser(), getPass());
    				while(pr.next()){
    					setUserid(pr.getInt(1));
    				}
    				myController.setScreen(ScreensFramework.screen5ID);
    			}else{
    				AlertDao.Display("Incorrect credentials", "Incorrect Username and/Or Password");
    				//System.out.println("Unsuccessful");
    			}
    			user_field.clear();
    			user_pass.clear();
    
    }

    @FXML
    void SignUpcon(ActionEvent event) throws IOException {	
		myController.setScreen(ScreensFramework.screen3ID);
    }

	@Override
	 public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
	
	@FXML
    void goBack(ActionEvent event) {
	  myController.setScreen(ScreensFramework.screen1ID);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("[LOG] Intialized");
	}

	
}
