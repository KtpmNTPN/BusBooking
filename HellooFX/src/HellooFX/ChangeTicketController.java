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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Hau Exoty
 */
public class ChangeTicketController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button chCheckButton;
    @FXML
    private Button chBackButton;
    
    ObservableList<TableCheck> table = FXCollections.observableArrayList();
    private ResultSet rs = null;
    @FXML
    private TableView<TableCheck> tbView;
    @FXML
    private TableColumn<TableCheck, Integer> id;
    @FXML
    private TableColumn<TableCheck, String> busno;
    @FXML
    private TableColumn<TableCheck, Integer> seats;
    @FXML
    private TableColumn<TableCheck, String> date;
    @FXML
    private TableColumn<TableCheck, String> time;
    @FXML
    private TextField txtCustomer;
    @FXML
    private TextField txtSeats;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtID;
    @FXML
    private Button chChangeButton;
    @FXML
    private TextField txtIDCheck;
    @FXML
    private TableColumn<TableCheck, String> customer;
    @FXML
    private TableColumn<TableCheck, String> price;
    @FXML
    private TableColumn<TableCheck, String> mobile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        busno.setCellValueFactory(new PropertyValueFactory<>("busno"));
        seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        customer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    }    

    @FXML
    private void chCheckButtonOnAction(ActionEvent event) {
        tbView.getItems().clear();
        String id = txtIDCheck.getText();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                PreparedStatement pst = connectDB.prepareStatement("select busbooking.id, busbooking.busno,busbooking.seats,busbooking.customer,busbooking.date,busbooking.time,busbooking.price from busseat where busbooking.id = ?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    table.add(new TableCheck(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        tbView.setItems(table);
    }

    @FXML
    private void chBackButtonOnAction(ActionEvent event) {
        
    }

    @FXML
    private void tableMouseClicked(MouseEvent event) {
        
    }

    @FXML
    private void chChangeButtonOnAction(ActionEvent event) {
        
    }
    
}
