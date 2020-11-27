/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hau Exoty
 */
public class UserBookingController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView tabPane;
    @FXML
    private Button uBExitButton;
    @FXML
    private Button ubBookingButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void uBExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) uBExitButton.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void ubBookingButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ubBookingButton.getScene().getWindow();
        stage.close();
        
    }
    
    
}
