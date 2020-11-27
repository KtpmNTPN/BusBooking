/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hau Exoty
 */
public class BusSeatController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView tabPane;
    @FXML
    private Button bSBackButton;
    @FXML
    private ComboBox Box;
    ObservableList<String> busNo = FXCollections.observableArrayList("Sài Gòn -> Đà Lạt","Sài Gòn -> Nha Trang");
    @FXML
    private Button bSAddButton;
    @FXML
    private DatePicker date;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Box.setItems(busNo);
    }    

    @FXML
    private void bSBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) bSBackButton.getScene().getWindow();
        stage.close();
        adminBookingFrom();
        
    }
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

    @FXML
    private void bSAddButtonOnAction(ActionEvent event) {
        
        String busno = busNo.toString();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        for(int i = 1; i <= 45 ; i++)
        {
            try {
                int seats = i;
                String status = "unbooked";
                PreparedStatement pst = connectDB.prepareStatement("insert into busseat(busno,seats,date,status)values(?,?,?,?)");
                pst.setString(1, busno);
                pst.setInt(2,seats);
                pst.setString(3, ((TextField)date.getEditor()).getText());
                pst.setString(4, status);
                pst.executeUpdate();
                
                
                
                
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        
    }
    
}
