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
public class BookingControllerTest {
    
    public BookingControllerTest() {
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
     * Test of initialize method, of class BookingController.
     */
     @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        CheckSeatController instance = new CheckSeatController();
        assertNotNull(instance.table);
    }
    @Test
    public void testInitialize1() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        CheckSeatController instance = new CheckSeatController();
        assertNotNull(instance.busNo);
        
    }

    /**
     * Test of UserBookingFrom method, of class BookingController.
     */
    @Test
    public void testUserBookingFrom() {
        System.out.println("UserBookingFrom");
        BookingController instance = new BookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BookingControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
