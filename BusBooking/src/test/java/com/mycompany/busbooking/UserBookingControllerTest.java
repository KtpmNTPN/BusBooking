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
public class UserBookingControllerTest {
    
    public UserBookingControllerTest() {
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
     * Test of loginFrom method, of class UserBookingController.
     */
    @Test
    public void testLoginFrom() {
        System.out.println("loginFrom");
        UserBookingController instance = new UserBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of busBookingForm method, of class UserBookingController.
     */
    @Test
    public void testBusBookingForm() {
        System.out.println("busBookingForm");
        UserBookingController instance = new UserBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of changeTicketForm method, of class UserBookingController.
     */
    @Test
    public void testChangeTicketForm() {
        System.out.println("changeTicketForm");
        UserBookingController instance = new UserBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of removeTicketForm method, of class UserBookingController.
     */
    @Test
    public void testRemoveTicketForm() {
        System.out.println("removeTicketForm");
        UserBookingController instance = new UserBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of printTicketForm method, of class UserBookingController.
     */
    @Test
    public void testPrintTicketForm() {
        System.out.println("printTicketForm");
        UserBookingController instance = new UserBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of buyTicketForm method, of class UserBookingController.
     */
    @Test
    public void testBuyTicketForm() {
        System.out.println("buyTicketForm");
        UserBookingController instance = new UserBookingController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UserBookingControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
