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
public class RemoveSeatControllerTest {
    
    public RemoveSeatControllerTest() {
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
     * Test of initialize method, of class RemoveSeatController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        RemoveSeatController instance = new RemoveSeatController();
        assertNotNull(instance.busNo);
    }
    @Test
    public void testInitialize1() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        RemoveSeatController instance = new RemoveSeatController();
        assertNotNull(instance.busTime);
    }

    /**
     * Test of adminBookingFrom method, of class RemoveSeatController.
     */
    @Test
    public void testAdminBookingFrom() {
        System.out.println("adminBookingFrom");
        RemoveSeatController instance = new RemoveSeatController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }
    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RemoveSeatControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
