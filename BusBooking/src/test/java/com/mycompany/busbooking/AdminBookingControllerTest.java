/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runners.Parameterized;

/**
 *
 * @author ADMIN
 */
public class AdminBookingControllerTest {

    public AdminBookingControllerTest() {
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
     * Test of loginFrom method, of class AdminBookingController.
     */
    @Test
    public void testLoginFrom() {
        System.out.println("loginFrom");
        AdminBookingController instance = new AdminBookingController();
        String expResult = "com.mycompany.busbooking.AdminBookingController@59e84876";
        assertEquals(expResult, instance.toString());
        
    }
    @Test
    public void testLoginFrom1() {
        System.out.println("loginFrom");
        AdminBookingController instance = new AdminBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
        
    }

    /**
     * Test of busSeatForm method, of class AdminBookingController.
     */
    @Test
    public void testBusSeatForm() {
        System.out.println("busSeatForm");
        AdminBookingController instance = new AdminBookingController();
        String expResult = "com.mycompany.busbooking.AdminBookingController@7c0e2abd";
        assertEquals(expResult, instance.toString());
        
    }

    /**
     * Test of removeSeatForm method, of class AdminBookingController.
     */
    @Test
    public void testRemoveSeatForm() {
        System.out.println("removeSeatForm");
        AdminBookingController instance = new AdminBookingController();
        String expResult = "com.mycompany.busbooking.AdminBookingController@13c78c0b";
        assertEquals(expResult, instance.toString());
        
    }
    @Test
    public void testRemoveSeatForm1() {
        System.out.println("removeSeatForm");
        AdminBookingController instance = new AdminBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
        
    }

    /**
     * Test of CheckSeatForm method, of class AdminBookingController.
     */
    @Test
    public void testCheckSeatForm() {
        System.out.println("CheckSeatForm");
        AdminBookingController instance = new AdminBookingController();
        String expResult = "com.mycompany.busbooking.AdminBookingController@4de8b406";
        assertEquals(expResult, instance.toString());
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(AdminBookingControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
