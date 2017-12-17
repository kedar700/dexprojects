package models;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 *
 * DAO for alerts that will occur while in the method.
 * Every Method will have different alert upon situation. 
 */
public class AlertDao {
	public static void Display(String Title,String Message){
		Stage win= new Stage();
		win.initModality(Modality.APPLICATION_MODAL);
		win.setTitle(Title);
		win.setMinWidth(350);
		win.setMinHeight(250);
		Label labl=new Label();
		labl.setText(Message);
		Button Btncls=new Button("OK");
		Btncls.setOnAction(e->win.close());
		
		VBox lay=new VBox(10);
		lay.getChildren().addAll(labl,Btncls);
		lay.setAlignment(Pos.CENTER);
		
		Scene scene=new Scene(lay);
		win.setScene(scene);
		win.showAndWait();
		
	}

}
