/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;


import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author Hau Exoty
 */
public class DatabaseConnection {
     public Connection databaseLink;
     
     public Connection getConnection(){
         String databaseName = "busbooking";
         String databaseUser = "root";
         String databasePassword = "123456";
         String url = "jdbc:mysql://localhost/" + databaseName;
         
         try {
             Class.forName("com.mysql.jdbc.Driver");
             databaseLink =DriverManager.getConnection(url,databaseUser,databasePassword);
             
         } catch (Exception e) {
             e.printStackTrace();
             e.getCause();
         }
         return databaseLink;
         
     }
     
     
}
