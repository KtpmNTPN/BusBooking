/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
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
    @FXML
    private Button crexitButton;
    @FXML
    private Button createMessageButton;
    @FXML
    private Label createMessageLabel;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label confirmPasswordLabel;
    @FXML
    private TextField fullnameTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField usernameTextField;

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
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
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

    @FXML
    private void crexitButtonAction(ActionEvent event) {
        Stage stage = (Stage) crexitButton.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void createMessageButtonOnAction(ActionEvent event) {
        
        createUser();
        if(setPasswordField.getText().equals(confirmPassword.getText())){
            confirmPasswordLabel.setText("");
            
        }else{
            confirmPasswordLabel.setText("Password does not match");
        }
    }
    
    public void createUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        
        String fullname = fullnameTextField.getText();
        String username = usernameTextField.getText();
        String phone = phoneTextField.getText();
        String password = setPasswordField.getText();
        
        String insertFields = "INSERT INTO user_account( fullname, username, phone, password) VALUES('";
        String insertValues = fullname + "','" + username + "','" + phone + "','" + password + "')" ;
        String inserttoRegister = insertFields + insertValues;
        
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(inserttoRegister);
            createMessageLabel.setText("User has been registered successfully!");
            
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            
        }
        }
    
}
