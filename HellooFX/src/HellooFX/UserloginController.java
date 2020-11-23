/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import javafx.scene.image.Image;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class UserloginController implements Initializable{
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    
    @Override
    public void initialize(URL url, ResourceBundle resoureBundle){
        File brandingFile = new File("Image/300312063027-thumbnail_DPP_0014.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
        
        File lockFile = new File("Image/tải%20xuống.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }
        
        
    
    
    public void loginButtonOnAction (ActionEvent event){
        
        if(usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false)
        {
            validateLogin();
        }else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }
    
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    public void validateLogin(){
    
    }
}
