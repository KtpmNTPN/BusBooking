/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Date;

/**
 * FXML Controller class
 *
 * @author Hau Exoty
 */
public class BookingController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ComboBox Box;
    ObservableList<BusNo> busNo = FXCollections.observableArrayList();
    ObservableList<Table> table = FXCollections.observableArrayList();
    @FXML
    private Button bCheckButton;
    private ResultSet rs = null;
    @FXML
    private Button bBackButton;
    @FXML
    private TableView<Table> tbView;
    @FXML
    private TableColumn<Table, Integer> id;
    @FXML
    private TableColumn<Table, String> busno;
    @FXML
    private TableColumn<Table, Integer> seats;
    @FXML
    private TableColumn<Table, String> date;
    @FXML
    private TableColumn<Table, String> time;
    @FXML
    private TableColumn<Table, String> status;
    @FXML
    private Button bBookingButton;
    @FXML
    private TextField txtSeats;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtCustomer;
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtPrice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        busNo.add(new BusNo(1, "Sài Gòn -> Nha Trang"));
        busNo.add(new BusNo(2, "Sài Gòn -> Đà Lạt"));
        busNo.add(new BusNo(3,"Nha Trang -> Sài Gòn"));
        busNo.add(new BusNo(3,"Nha Trang -> Đà Lạt"));
        Box.setItems(busNo);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        busno.setCellValueFactory(new PropertyValueFactory<>("busno"));
        seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
    }    

    @FXML
    private void bCheckButtonOnAction(ActionEvent event) {
        tbView.getItems().clear();
        Date now = new Date();
        DateFormat dateFormat = null;
        DateFormat timeFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        timeFormat = new SimpleDateFormat("HH:mm");
        String cdate = dateFormat.format(now);
        String ctime = timeFormat.format(now);
        long expireTime = 1*60*5*1000;
        long expireTimeb = 1 * 60 * 30 * 1000;
        String busno = Box.getSelectionModel().getSelectedItem().toString();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                PreparedStatement pst = connectDB.prepareStatement("select busseat.id, busseat.busno,busseat.seats,busseat.date,busseat.time, busseat.status from busseat where busseat.busno = ?");
                pst.setString(1, busno);
                rs = pst.executeQuery();
                
                
                String status = "revoked";
                
                while(rs.next())
                {
                    String  time = rs.getString(5);
                    DateFormat format = new SimpleDateFormat("HH:mm");
                    Date date1 = format.parse(ctime);
                    Date date2 = format.parse(time);
                    long difference = date2.getTime() - date1.getTime();
                    
                    if(((difference <= expireTimeb) == true && cdate.equals(rs.getString(4))&& rs.getString(6).equals("booked")))
                    {
                        try {
                            PreparedStatement pst1 = connectDB.prepareStatement("update busseat set status = ? where status = 'booked' ");
                            pst1.setString(1, status);
                            pst1.executeUpdate();
                            table.add(new Table(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6)));
                            tbView.setItems(table);
                        } catch (Exception e) {
                        }
                    }
                    else if(((difference <= expireTime) == true && cdate.equals(rs.getString(4))&& !rs.getString(6).equals("revoked"))){
                    for (int i = 1; i <= 45; i++) {
                        try {
                            int seats = i;
                            PreparedStatement pst1 = connectDB.prepareStatement("update busseat set status = ? where busseat.seats = ? and busseat.status = 'unbooked' ");
                            pst1.setString(1, status);
                            pst1.setInt(2, seats);
                
                            pst1.executeUpdate();

                        } catch (Exception e) {
                                e.printStackTrace();
                                e.getCause();
                            }
                    }
                        table.add(new Table(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6)));
                        tbView.setItems(table);
                    
                    }else
                        table.add(new Table(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4), rs.getString(5),rs.getString(6)));        
                
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
    private void bBookingButtonOnAction(ActionEvent event) {
        Table table = tbView.getSelectionModel().getSelectedItem();
        String id = txtID.getText();
        String busno = table.getBusno();
        String seat = txtSeats.getText();
        String customer = txtCustomer.getText();
        String mobile = txtMobile.getText();
        String date = txtDate.getText();
        String time = txtTime.getText();
        String price = txtPrice.getText();
        String status = "booked";
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
            try {
                
                PreparedStatement pst = connectDB.prepareStatement("insert into busbooking(id,busno,seat,customer,mobile,date,time,price)values(?,?,?,?,?,?,?,?)");
                pst.setString(1, id);
                pst.setString(2, busno);
                pst.setString(3, seat);
                pst.setString(4, customer);
                pst.setString(5, mobile);
                pst.setString(6, date);
                pst.setString(7, time);
                pst.setString(8, price);
                pst.executeUpdate();
                PreparedStatement pst1 = connectDB.prepareStatement("update busseat set status = ? where busseat.seats = ? ");
                pst1.setString(1, status);
                pst1.setString(2, seat);
                
                pst1.executeUpdate();
                txtID.clear();
                
                txtSeats.clear();
                txtCustomer.clear();
                txtMobile.clear();
                txtDate.clear();
                txtTime.clear();
                txtPrice.clear();
                
                

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        
    }

    @FXML
    private void bBackButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) bBackButton.getScene().getWindow();
        stage.close();
        UserBookingFrom();
    }

    @FXML
    private void tableMouseClicked(MouseEvent event) throws ParseException {
        Table table = tbView.getSelectionModel().getSelectedItem();
        String status = table.getStatus();
        Date now = new Date();
        DateFormat dateFormat = null;
        DateFormat timeFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        timeFormat = new SimpleDateFormat("HH:mm");
        String cdate = dateFormat.format(now);
        String ctime = timeFormat.format(now);
        String time2 = table.getTime();
        DateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = format.parse(ctime);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        long expireTime = 1*60*60*1000;
        
        if(!cdate.equals(table.getDate()) || (status.equals("unbooked") && ((difference>expireTime) && cdate.equals(table.getDate()) )== true && !status.equals("revoked") && !status.equals("bought")))
        {
            txtID.setText(Integer.toString(table.getId()));
            txtSeats.setText(Integer.toString(table.getSeats()));
            txtDate.setText(table.getDate());
            txtTime.setText(table.getTime());
        }
        else
        {
            System.out.println("Ticket Booked");
        }
        
        
        
        
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
