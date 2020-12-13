/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import java.net.URL;
import java.util.ResourceBundle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ACER
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
        testValidateLogin();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of initialize method, of class LoginController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        LoginController instance = new LoginController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateLogin method, of class LoginController.
     */
    @Test
    public void testValidateLogin() {
        System.out.println("validateLogin");
        LoginController instance = new LoginController();
        String expResult = "Login success";
        String result = instance.toString();
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userBookingFrom method, of class LoginController.
     */
    @Test
    public void testUserBookingFrom() {
        System.out.println("userBookingFrom");
        LoginController instance = new LoginController();
        instance.userBookingFrom();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of advalidateLogin method, of class LoginController.
     */
    @Test
    public void testAdvalidateLogin() {
        System.out.println("advalidateLogin");
        LoginController instance = new LoginController();
        instance.advalidateLogin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adminBookingFrom method, of class LoginController.
     */
    @Test
    public void testAdminBookingFrom() {
        System.out.println("adminBookingFrom");
        LoginController instance = new LoginController();
        instance.adminBookingFrom();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
