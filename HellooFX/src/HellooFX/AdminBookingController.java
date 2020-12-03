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
public class AdminBookingController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView tabPane;
    @FXML
    private Button adbAddSeatButton;
    @FXML
    private Button adBExitButton;
    @FXML
    private Button adbRemoveSeatButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adbAddSeatButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) adbAddSeatButton.getScene().getWindow();
        stage.close();
        busSeatForm();
    }

    @FXML
    private void adBExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) adBExitButton.getScene().getWindow();
        stage.close();
    }
    public void busSeatForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BusSeat.fxml"));
            Stage busSeatStage = new Stage();
            busSeatStage.initStyle(StageStyle.UNDECORATED);
            busSeatStage.setScene(new Scene(root, 940 , 644));
            busSeatStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void removeSeatForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RemoveSeat.fxml"));
            Stage busSeatStage = new Stage();
            busSeatStage.initStyle(StageStyle.UNDECORATED);
            busSeatStage.setScene(new Scene(root, 940 , 644));
            busSeatStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    private void adbRemoveSeatButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) adbAddSeatButton.getScene().getWindow();
        stage.close();
        removeSeatForm();
    }
}
