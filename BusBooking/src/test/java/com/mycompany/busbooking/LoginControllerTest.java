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
public class LoginControllerTest {
    
    public LoginControllerTest() {
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
     * Test of validateLogin method, of class LoginController.
     */
    @Test
    public void testValidateLogin() {
        System.out.println("validateLogin");
        LoginController instance = new LoginController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
        
    }

    /**
     * Test of userBookingFrom method, of class LoginController.
     */
    @Test
    public void testUserBookingFrom() {
        System.out.println("userBookingFrom");
        LoginController instance = new LoginController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of advalidateLogin method, of class LoginController.
     */
    @Test
    public void testAdvalidateLogin() {
        System.out.println("advalidateLogin");
        LoginController instance = new LoginController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of adminBookingFrom method, of class LoginController.
     */
    @Test
    public void testAdminBookingFrom() {
        System.out.println("adminBookingFrom");
        LoginController instance = new LoginController();
        String expResult = instance.toString();
        assertEquals(expResult, instance.toString());
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LoginControllerTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
