package com.mycompany.busreservation;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class UserloginController{
    @FXML
    private Button cancelButton;
    
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
