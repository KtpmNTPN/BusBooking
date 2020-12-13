/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    @FXML
    private TextField adusernameTextField;
    @FXML
    private PasswordField adpasswordTextField;
    @FXML
    private Button adloginButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Label adloginMessageLabel;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button adexitButton;
    @FXML
    private Button exitButton;

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
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5), keyValue);
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

    @FXML
    private void adloginButtonAction(ActionEvent event) {
        if(adusernameTextField.getText().isBlank() == false && adpasswordTextField.getText().isBlank() == false)
        {
            advalidateLogin();
            Stage stage = (Stage) adloginButton.getScene().getWindow();
            stage.close();
        }else{
            adloginMessageLabel.setText("Please enter username and password");
        }
    }

    @FXML
    private void loginButtonAction(ActionEvent event) {
        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
        {
            validateLogin();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        }else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    @FXML
    private void adexitButtonAction(ActionEvent event) {
        Stage stage = (Stage) adexitButton.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void exitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        
    }
    @FXML
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        
        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() +"'";
        
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            
            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    //loginMessageLabel.setText("Congratulations");
                    userBookingFrom();
                    System.out.println("Login success");
                }else{
                    loginMessageLabel.setText("Invaild login. Please try again");
                }
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        
    }
    @FXML
    public void userBookingFrom(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UserBooking.fxml"));
            Stage bookingStage = new Stage();
            bookingStage.initStyle(StageStyle.UNDECORATED);
            bookingStage.setScene(new Scene(root, 940 , 644));
            bookingStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    public void advalidateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        
        String verifyLogin = "SELECT count(1) FROM admin_account WHERE username = '" + adusernameTextField.getText() + "' AND password = '" + adpasswordTextField.getText() +"'";
        
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            
            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    //loginMessageLabel.setText("Congratulations");
                    adminBookingFrom();
                }else{
                    adloginMessageLabel.setText("Invaild login. Please try again");
                }
                
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        
    }
    @FXML
    public void adminBookingFrom(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminBooking.fxml"));
            Stage adbookingStage = new Stage();
            adbookingStage.initStyle(StageStyle.UNDECORATED);
            adbookingStage.setScene(new Scene(root, 940 , 644));
            adbookingStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
