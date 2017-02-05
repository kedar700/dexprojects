package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.AlertDao;
import models.SignUpDao;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 */

public class SignupController implements Initializable, ControlledScreen {

	ScreensController myController;

	private String Fname;
	private String Lname;
	private String email_id;
	private String Pass;
	private String Conpass;
	private String add;

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getConpass() {
		return Conpass;
	}

	public void setConpass(String conpass) {
		Conpass = conpass;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@FXML
	private JFXTextField U_Fname;

	@FXML
	private JFXTextField U_Lname;

	@FXML
	private JFXTextField U_email;

	@FXML
	private JFXPasswordField U_pass;

	@FXML
	private JFXPasswordField U_conpass;

	@FXML
	private JFXTextArea U_address;

	SignUpDao signdata = new SignUpDao();
/**
 * 
 * @param event used to set up the sign up event.
 */
	@FXML
	void SignUp(ActionEvent event) {

		setAdd(U_address.getText());
		setConpass(U_conpass.getText());
		setPass(U_pass.getText());
		setEmail_id(U_email.getText());
		setLname(U_Lname.getText());
		setFname(U_Fname.getText());

		if (getFname() != null && getLname() != null && getPass() != null && getConpass() != null
				&& getEmail_id() != null) {
			System.out.println(getConpass()+" "+getPass());
			if (getPass().equals(getConpass())) {
				signdata.Insertdata(getFname(), getLname(), getAdd(), getEmail_id(), getPass());
				System.out.println("Thank you for Signing Up");
			} else {
				AlertDao.Display("Incorrect credentials", "Password and confirm Password don't match");
			}
		} else {
			AlertDao.Display("Incorrect credentials", "Enter all the fields correctly");
		}
	}

	@FXML
	void Logincone(ActionEvent event) {

		myController.setScreen(ScreensFramework.screen2ID);
	}

	@FXML
	
    void goBack(ActionEvent event) {
	  myController.setScreen(ScreensFramework.screen1ID);
    }
	@Override
	public void setScreenParent(ScreensController screenPage) {
		myController = screenPage;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
