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
public class RemoveTicketControllerTest {
    
    public RemoveTicketControllerTest() {
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
     * Test of initialize method, of class RemoveTicketController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        RemoveTicketController instance = new RemoveTicketController();
        assertNotNull(instance.table);
    }

    /**
     * Test of UserBookingFrom method, of class RemoveTicketController.
     */
    @Test
    public void testUserBookingFrom() {
        System.out.println("UserBookingFrom");
        RemoveTicketController instance = new RemoveTicketController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RemoveTicketControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
