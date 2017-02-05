/**
 * <h1>Cinema Management System</h1> 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 */
package controllers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * 
 * Extends the main Application class and hence load the pages.
 * Used like a framework
 *
 */
public class ScreensFramework extends Application {
	
/**
 * 
 */
	public static String screen1ID = "Landing Page";
	public static String screen1File = "/views/LandingPage.fxml";
	public static String screen2ID = "User Login";
	public static String screen2File = "/views/UserLogin.fxml";
	public static String screen3ID = "User SignUp";
	public static String screen3File = "/views/UserSignup.fxml";
	public static String screen4ID = "Admin Login";
	public static String screen4File = "/views/AdminLogin.fxml";
	public static String screen5ID = "User Homepage";
	public static String screen5File = "/views/HomePageUser.fxml";
	public static String screen6ID = "Admin Homepage";
	public static String screen6File = "/views/HomePageAdmin.fxml";
	public static String screen7ID = "Movie Select Page";
	public static String screen7File = "/views/UserMovieSelect.fxml";
	public static String screen8ID = "Admin Movie Page";
	public static String screen8File = "/views/AddMovie.fxml";
	public static String screen9ID = "Admin Show Page";
	public static String screen9File = "/views/AddShow.fxml";
	public static String screen10ID = "Payment Page";
	public static String screen10File = "/views/Payment_PageUser.fxml";
	public static String screen11ID = "Orders Page";
	public static String screen11File = "/views/UserOrderDetails.fxml";

	/**
	 * @param primaryStage used to set the main stage and hence
	 * load all the other screens.
	 */
	@Override
	public void start(Stage primaryStage) {

		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
		mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
		mainContainer.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
		mainContainer.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
		mainContainer.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
		mainContainer.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);
		mainContainer.loadScreen(ScreensFramework.screen7ID, ScreensFramework.screen7File);
		mainContainer.loadScreen(ScreensFramework.screen8ID, ScreensFramework.screen8File);
		mainContainer.loadScreen(ScreensFramework.screen9ID, ScreensFramework.screen9File);
		mainContainer.loadScreen(ScreensFramework.screen10ID, ScreensFramework.screen10File);
		mainContainer.loadScreen(ScreensFramework.screen11ID, ScreensFramework.screen11File);
		
		mainContainer.setScreen(ScreensFramework.screen1ID);

		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
/**
 * 
 * @param args used to launch the fx application.
 */
	public static void main(String[] args) {
		launch(args);
	}
}
