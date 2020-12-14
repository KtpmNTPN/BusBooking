/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.busbooking;

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
public class TableCheckTest {
    
    TableCheck instance = new TableCheck(0, "", 1, "", "", "", "", "");
    
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
     * Test of getId method, of class TableCheck.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetBusno() {
        System.out.println("getBusno");
        String expResult = "";
        String result = instance.getBusno();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetSeat() {
        System.out.println("getSeat");
        
        int expResult = 1;
        int result = instance.getSeat();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
       
        String expResult = "";
        String result = instance.getCustomer();
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testGetMobile() {
        System.out.println("getMobile");
        
        String expResult = "";
        String result = instance.getMobile();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        
        String expResult = "";
        String result = instance.getTime();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        
        String expResult = "";
        String result = instance.getPrice();
        assertEquals(expResult, result);
        
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TableCheckTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
    
}
