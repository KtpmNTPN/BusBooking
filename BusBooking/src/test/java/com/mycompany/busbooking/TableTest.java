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
public class TableTest {
    Table instance = new Table(0, "", 1, "", "", "");
    
    
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
     * Test of getId method, of class Table.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Table.
     */
    
    @Test
    public void testGetBusno() {
        System.out.println("getBusno");
        String expResult = "";
        String result = instance.getBusno();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setBusno method, of class Table.
     */
    
    @Test
    public void testGetSeats() {
        System.out.println("getSeats");
        int expResult = 1;
        int result = instance.getSeats();
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
    public void testGetStatus() {
        System.out.println("getStatus");
        
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        String expResult = "";
        String result = instance.getTime();
        assertEquals(expResult, result);
        
    }

    
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TableTest.class);
        

        if (!result.wasSuccessful()) {
            result.getFailures().forEach((failure) -> {
                System.err.println(failure);
            });
            
        } else {
            System.out.println("success");
        }
    }
}
