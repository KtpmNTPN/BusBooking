/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class CreateAccountController implements Initializable {

    @FXML
    private ImageView tabPane;
    @FXML
    private Label lblLogin;
    @FXML
    private AnchorPane anchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openLoginScene(MouseEvent event) throws IOException {
        //Creating fancy slide transition to switch between scenes
        //Load the Create FXML file First, and assign Parent variable
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //get current scene
        Scene accountScene = lblLogin.getScene();
        //Place the new scene at the bottom of current scene
        root.translateYProperty().set(accountScene.getHeight());
        //Add it to our holder pain, which is stack pane.
        //get an instance of stackpane from the parent
        StackPane rootPane = (StackPane) accountScene.getRoot();
       
        rootPane.getChildren().add(root);
        //We create sliding up animation using timeline
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
        //add keyframe to animation
        timeline.getKeyFrames().add(keyFrame);
        
        //play the animation
        timeline.play();
        //remove old anchorpane after animation is complete
        timeline.setOnFinished((ActionEvent event2) -> {
            //remove node from stackpane
        rootPane.getChildren().remove(anchorpane);
            
        });
    }
    
}
