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
import java.text.ParseException;
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
    private TableColumn<TableCheck, Integer> seat;
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
    private TextField txtMobileCheck;
    @FXML
    private TableColumn<TableCheck, String> customer;
    @FXML
    private TableColumn<TableCheck, String> price;
    @FXML
    private TableColumn<TableCheck, String> mobile;
    @FXML
    private TextField txtOldSeat;

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
    private void chCheckButtonOnAction(ActionEvent event) {
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
                    String  time = rs.getString(7);
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
    private void chBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) chBackButton.getScene().getWindow();
        stage.close();
        UserBookingFrom();
    }

    @FXML
    private void tableMouseClicked(MouseEvent event) throws ParseException {
        TableCheck table = tbView.getSelectionModel().getSelectedItem();
        Date datee = new Date();
        DateFormat dateFormat = null;
        DateFormat timeFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        String cdate = dateFormat.format(datee);
        String ctime = timeFormat.format(datee);
        String time2 = table.getTime();
        DateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(ctime);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        long expireTime = 1*60*60*1000;
        
        if(!cdate.equals(table.getDate()) || (((difference>expireTime) && cdate.equals(table.getDate()) )== true))
        {
            txtID.setText(Integer.toString(table.getId()));
            txtSeats.setText(Integer.toString(table.getSeat()));
            txtCustomer.setText(table.getCustomer());
            txtMobile.setText(table.getMobile());
            txtDate.setText(table.getDate());
            txtTime.setText(table.getTime());
            txtPrice.setText(table.getPrice());
            txtOldSeat.setText(Integer.toString(table.getSeat()));
        }
        else
        {
            System.out.println("Time Change End");
        }
    }

    @FXML
    private void chChangeButtonOnAction(ActionEvent event) {
        TableCheck table = tbView.getSelectionModel().getSelectedItem();
        String id = txtID.getText();
        String busno = table.getBusno();
        String seat = txtSeats.getText();
        String oldseat = txtOldSeat.getText();
        String customer = txtCustomer.getText();
        String mobile = txtMobile.getText();
        String date = txtDate.getText();
        String time = txtTime.getText();
        String price = txtPrice.getText();
        String status = "booked";
        String status1 = "unbooked";
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                PreparedStatement pst2 = connectDB.prepareStatement("update busseat set status = ? where seats = ? ");
                pst2.setString(1, status1);
                pst2.setString(2, oldseat);
                pst2.executeUpdate();
                PreparedStatement pst = connectDB.prepareStatement("update busbooking set seat = ?, customer = ?, mobile = ?, date = ?, time = ?, price = ? where id = ?");
                pst.setString(1, seat);
                pst.setString(2, customer);
                pst.setString(3, mobile);
                pst.setString(4, date);
                pst.setString(5, time);
                pst.setString(6, price);
                pst.setInt(7, Integer.valueOf(id));
                pst.executeUpdate();
                PreparedStatement pst1 = connectDB.prepareStatement("update busseat set status = ? where seats = ? ");
                pst1.setString(1, status);
                pst1.setString(2, seat);
                pst1.executeUpdate();
                

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        
    }
    
}
