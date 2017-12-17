
package controllers;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * 
 * @author Kedar Naresh Naik
 * @since 2016-12-02
 * Extends the stack pane and hence loads all the other panes.
 */
public class ScreensController  extends StackPane {

	/**
	 * The screens are access through a hashmap.
	 */
    private HashMap<String, Node> screens = new HashMap<>();
    /**
     * Cconstructor of the class used to setup screens.
     */
    public ScreensController() {
        super();
    }

   /**
    * 
    * @param name The name of the screen given.
    * @param screen The screen to add to a hashmap.
    *  This adds the screen to the map.
    */
    public void addScreen(String name, Node screen) {
        screens.put(name, screen);
    }

   /**
    * 
    * @param name this takes the name of the screen as an input.
    * @return Returns the screen from the map.
    */
    public Node getScreen(String name) {
        return screens.get(name);
    }
    
    /**
     * 
     * @param name the name of the file 
     * @param resource The .fxml that is to be loaded
     * @return this will return the screen that is to be loaded.
     * 
     */
    public boolean loadScreen(String name, String resource) {
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
/**
 * 
 * @param name The name of the screen that will be set on the existing pane.
 * @return This will load the screen on the existing pane with a fade in effect.
 */
     public boolean setScreen(final String name) {       
        if (screens.get(name) != null) {   //screen loaded
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()) {    //if there is more than one screen
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(100), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        getChildren().remove(0);                    //remove the displayed screen
                        getChildren().add(0, screens.get(name));     //add the screen
                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(100), new KeyValue(opacity, 1.0)));
                        fadeIn.play();
                    }
                }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));       //no one else been displayed, then just show
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        } else {
            System.out.println("screen hasn't been loaded!!! \n");
            return false;
        }


    }

    /**
     * 
     * @param name The name of the screen needs to be checked.
     * @return If the screen does not exist it will return the message.
     */
    public boolean unloadScreen(String name) {
        if (screens.remove(name) == null) {
            System.out.println("Screen didn't exist");
            return false;
        } else {
            return true;
        }
    }
}

