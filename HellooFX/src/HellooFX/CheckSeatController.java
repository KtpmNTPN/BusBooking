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
    private ResultSet rs = null;
    private TableView<Table> tbView;
    @FXML
    private TableColumn<Table,String> busno;
    @FXML
    private TableColumn<Table,Integer> seats;
    @FXML
    private TableColumn<Table,String> date;
    @FXML
    private TableColumn<Table,String> status;
    @FXML
    private TableColumn<Table,Integer> id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        busNo.add(new BusNo(1, "cc"));
        busNo.add(new BusNo(2, "ccu"));
        busNo.add(new BusNo(3,"cco"));
        Box.setItems(busNo);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        busno.setCellValueFactory(new PropertyValueFactory<>("busno"));
        seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        
    }    

    @FXML
    private void cCheckButtonOnAction(ActionEvent event) { 
        String busno = Box.getSelectionModel().getSelectedItem().toString();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                PreparedStatement pst = connectDB.prepareStatement("select busseat.id, busseat.busno,busseat.seats,busseat.date,busseat.status from busseat where busseat.busno = ?");
                pst.setString(1, busno);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    table.add(new Table(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        tbView.setItems(table);
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
