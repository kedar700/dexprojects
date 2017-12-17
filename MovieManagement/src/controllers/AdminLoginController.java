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
public class AdminLoginController  implements Initializable, ControlledScreen{

	ScreensController myController;

	private String user;
	private String pass;
/**
 * 
 * @return returns the user 
 */
    public String getUser() {
		return user;
	}
/**
 * 
 * @param user sets the private user.
 */
	public void setUser(String user) {
		this.user = user;
	}

/**
 * 
 * @return returns the password variable.
 * 
 */
	public String getPass() {
		return pass;
	}

/**
 * 	
 * @param pass sets the password variable.
 */
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
     * @param event The event occuring on login.
     * @throws IOException if an input/output expression occurs.
     * @throws SQLException if SQL exception occurs.
     */
    
    @FXML
    void LoginCon(ActionEvent event) throws IOException, SQLException {
    	setUser(user_field.getText());
    	setPass(user_pass.getText());	
    	
    	ResultSet rs =logindata.getResult(getUser(), getPass(),"No");
    			if(rs.next()){
    				
    				System.out.println("U have logged in successfully");
    				myController.setScreen(ScreensFramework.screen5ID);
    			}else{
    				AlertDao.Display("Incorrect credentials", "Incorrect Username and/Or Password");
    				System.out.println("Unsuccessful");
    			}
    }
/**
 * 
 * @param validates the screen and hence sets it.
 * @throws IOException if an IOException occurs the sets it.
 */
    @FXML
    void SignUpcon(ActionEvent event) throws IOException {	
		myController.setScreen(ScreensFramework.screen3ID);
    }
/**
 * set to the main screen.
 */
	@Override
	 public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println("[LOG] Intialized");
	}

	
}
