/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ResourceBundle;
import java.util.Vector;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class CheckSeatController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ComboBox Box;
    ObservableList<BusNo> busNo = FXCollections.observableArrayList();
    ObservableList<Table> table = FXCollections.observableArrayList();
    @FXML
    private Button cCheckButton;
    private Button bSBackButton;
    @FXML
    private Button cBackButton;
    @FXML
    private TableView tbView;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn busno;
    @FXML
    private TableColumn seats;
    @FXML
    private TableColumn date;
    @FXML
    private TableColumn status;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        busNo.add(new BusNo(1, "cc"));
        busNo.add(new BusNo(2, "ccu"));
        busNo.add(new BusNo(3,"cco"));
        Box.setItems(busNo);
    }    

    @FXML
    private void cCheckButtonOnAction(ActionEvent event) {
        String busno = Box.getSelectionModel().getSelectedItem().toString(); 
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        
        
        
        
    }
    public void adminBookingFrom() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminBooking.fxml"));
            Stage adbookingStage = new Stage();
            adbookingStage.initStyle(StageStyle.UNDECORATED);
            adbookingStage.setScene(new Scene(root, 940, 644));
            adbookingStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    private void cBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) bSBackButton.getScene().getWindow();
        stage.close();
        adminBookingFrom();
    }

        private class BusNo {

        private int id;
        private String name;

        public BusNo(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.getName();
        }

    }
    
}
