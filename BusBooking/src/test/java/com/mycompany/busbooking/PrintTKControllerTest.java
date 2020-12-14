/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 *
 * @author ADMIN
 */
public class PrintTKControllerTest {
    
    public PrintTKControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class PrintTKController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        PrintTKController instance = new PrintTKController();
        assertNotNull(instance.table);
    }

    /**
     * Test of UserBookingFrom method, of class PrintTKController.
     */
    @Test
    public void testUserBookingFrom() {
        System.out.println("UserBookingFrom");
        PrintTKController instance = new PrintTKController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of ticketFrom method, of class PrintTKController.
     */
    @Test
    public void testTicketFrom() {
        System.out.println("ticketFrom");
        PrintTKController instance = new PrintTKController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PrintTKControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
