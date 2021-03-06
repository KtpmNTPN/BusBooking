/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;

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
    @FXML
    private Button ubChangeTicketButton;
    @FXML
    private Button ubRemoveTicketButton;
    @FXML
    private Button ubPrintTicketButton;
    @FXML
    private Button ubBuyButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void loginFrom(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
    private void uBExitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) uBExitButton.getScene().getWindow();
        stage.close();
        loginFrom();
        
    }

    public void busBookingForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Booking.fxml"));
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
    private void ubBookingButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ubBookingButton.getScene().getWindow();
        stage.close();
        busBookingForm();
        
    }
    public void changeTicketForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ChangeTicket.fxml"));
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
    private void ubChangeTicketButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ubChangeTicketButton.getScene().getWindow();
        stage.close();
        changeTicketForm();
    }
    
    public void removeTicketForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RemoveTicket.fxml"));
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
    private void ubRemoveTicketButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ubRemoveTicketButton.getScene().getWindow();
        stage.close();
        removeTicketForm();
    }

    public void printTicketForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PrintTK.fxml"));
            Stage busSeatStage = new Stage();
            busSeatStage.initStyle(StageStyle.UNDECORATED);
            busSeatStage.setScene(new Scene(root, 1161 , 682));
            busSeatStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    @FXML
    private void ubPrintTicketButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ubPrintTicketButton.getScene().getWindow();
        stage.close();
        printTicketForm();
    }

    public void buyTicketForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Buy.fxml"));
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
    private void ubBuyButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) ubPrintTicketButton.getScene().getWindow();
        stage.close();
        buyTicketForm();
    }
    
    
}
