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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class LoginController implements Initializable {

    @FXML
    private ImageView tabPane;
    @FXML
    private TabPane tabPaneLogin;
    @FXML
    private Tab tabAdmin;
    @FXML
    private Tab tabUser;
    @FXML
    private Label lblCreateAccount;
    @FXML
    private Pane slidingPane;
    @FXML
    private Label lblAdmin;
    @FXML
    private Label lblUser;
    @FXML
    private Label lblStatus;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane anchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openAdminTab(MouseEvent event) {
        TranslateTransition toLeftAnimation = new TranslateTransition(new Duration(500), lblStatus);
        toLeftAnimation.setToX(slidingPane.getTranslateX());
        toLeftAnimation.play();
        toLeftAnimation.setOnFinished((ActionEvent event2) -> {
            lblStatus.setText("ADMINSTRATOR");
        });
        //set select tab as User
        tabPaneLogin.getSelectionModel().select(tabAdmin);
    }

    @FXML
    private void openUserTab(MouseEvent event) {
        TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500), lblStatus);
        toRightAnimation.setToX(slidingPane.getTranslateX()+(slidingPane.getPrefWidth()-lblStatus.getPrefWidth()));
        toRightAnimation.play();
        toRightAnimation.setOnFinished((ActionEvent event1) -> {
            lblStatus.setText("USER");
        });
        //set select tab as User
        tabPaneLogin.getSelectionModel().select(tabUser);
    }

    @FXML
    private void openCreateAccountScene(MouseEvent event) throws IOException {
        //Creating fancy slide transition to switch between scenes
        //Load the Create FXML file First, and assign Parent variable
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        //get current scene
        Scene loginScene = lblAdmin.getScene();
        //Place the new scene at the bottom of current scene
        root.translateYProperty().set(loginScene.getHeight());
        //Add it to our holder pain, which is stack pane.
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
            rootPane.getChildren().remove(anchorPane);
            
        });
        
    }
    
}
