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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Hau Exoty
 */
public class PrintTKController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button ptCheckButton;
    @FXML
    private Button ptBackButton;
    ObservableList<TableCheck> table = FXCollections.observableArrayList();
    private ResultSet rs = null;
    @FXML
    private TableView<TableCheck> tbView;
    @FXML
    private TableColumn<TableCheck, Integer> id;
    @FXML
    private TableColumn<TableCheck, String> busno;
    @FXML
    private TableColumn<TableCheck, Integer> seat;
    @FXML
    private TableColumn<TableCheck, String> customer;
    @FXML
    private TableColumn<TableCheck, String> mobile;
    @FXML
    private TableColumn<TableCheck, String> date;
    @FXML
    private TableColumn<TableCheck, String> time;
    @FXML
    private TableColumn<TableCheck, String> price;
    @FXML
    private Button ptPrintButton;
    @FXML
    private TextField txtMobileCheck;
    @FXML
    private Label lblBusNo;
    @FXML
    private Label lblDT;
    @FXML
    private Label lblSeat;
    @FXML
    private Label lblName;
    @FXML
    private Label lblMobile;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblPD;
    @FXML
    private Label lblEmployee;
    @FXML
    private Label lblID;
    @FXML
    private AnchorPane boardingPass;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        busno.setCellValueFactory(new PropertyValueFactory<>("busno"));
        seat.setCellValueFactory(new PropertyValueFactory<>("seat"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        customer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        mobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
    }    

    @FXML
    private void ptCheckButtonOnAction(ActionEvent event) {
        tbView.getItems().clear();
        Date now = new Date();
        DateFormat dateFormat = null;
        DateFormat timeFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        timeFormat = new SimpleDateFormat("HH:mm");
        String cdate = dateFormat.format(now);
        String ctime = timeFormat.format(now);
        long expireTime = 1*60*5*1000;
        String mobile = txtMobileCheck.getText();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                PreparedStatement pst = connectDB.prepareStatement("select * from busbooking where busbooking.mobile = ? ");
                pst.setString(1, mobile);
                rs = pst.executeQuery();
                
                String status = "revoked";
                
                while(rs.next())
                {
                    String  time = rs.getString(5);
                    DateFormat format = new SimpleDateFormat("HH:mm");
                    Date date1 = format.parse(ctime);
                    Date date2 = format.parse(time);
                    long difference = date2.getTime() - date1.getTime();
                    if((difference < expireTime) == true && cdate.equals(rs.getString(6))){
                    for (int i = 1; i <= 45; i++) {
                        try {
                            int seats = i;
                            PreparedStatement pst1 = connectDB.prepareStatement("update busseat set status = ? where busseat.seats = ? ");
                            pst1.setString(1, status);
                            pst1.setInt(2, seats);
                
                            pst1.executeUpdate();

                        } catch (Exception e) {
                                e.printStackTrace();
                                e.getCause();
                            }
                    }
                    table.add(new TableCheck(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
                    tbView.setItems(table);
                    
                }else
                    table.add(new TableCheck(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));        
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
            
        tbView.setItems(table);
    }
    
     public void UserBookingFrom(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("UserBooking.fxml"));
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
    private void ptBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ptBackButton.getScene().getWindow();
        stage.close();
        UserBookingFrom();
    }

    @FXML
    private void tableMouseClicked(MouseEvent event) {
        TableCheck table = tbView.getSelectionModel().getSelectedItem();
        Date datee = new Date();
        DateFormat dateFormat = null;
        DateFormat timeFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        String cdate = dateFormat.format(datee);
        String ctime = timeFormat.format(datee);
        try {
                lblID.setText(Integer.toString(table.getId()));
                lblSeat.setText(Integer.toString(table.getSeat()));
                lblName.setText(table.getCustomer());
                lblMobile.setText(table.getMobile());
                lblDT.setText(table.getTime() + "  " + table.getDate());
                lblPrice.setText(table.getPrice());
                lblPD.setText(ctime + "  " + cdate );
                lblEmployee.setText("Thiên Phong");
                lblBusNo.setText(table.getBusno());
                
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        
            
        
    }

    public void ticketFrom(){
        try {
            AnchorPane root = new AnchorPane(boardingPass);
            Stage busSeatStage1 = new Stage();
            busSeatStage1.initStyle(StageStyle.DECORATED);
            busSeatStage1.setScene(new Scene(root, 600  , 580));
            busSeatStage1.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    private void ptPrintButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ptPrintButton.getScene().getWindow();
        stage.close();
        ticketFrom();
    }


    
}
