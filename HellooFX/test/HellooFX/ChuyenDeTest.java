/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HellooFX;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ADMIN
 */
public class ChuyenDeTest {
    
    public ChuyenDeTest() {
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
     * Test of getMaCD method, of class ChuyenDe.
     */
    @Test
    public void testGetMaCD() {
        
        ChuyenDe instance = new ChuyenDe();
        String expResult = "";
        String result = instance.getMaCD();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMaCD method, of class ChuyenDe.
     */
    @Test
    public void testSetMaCD() {
        
        String maCD = "M01";
        String expected = "M01";
        ChuyenDe instance = new ChuyenDe();
        instance.setMaCD(maCD);
        assertEquals(expected, instance.getMaCD());
    }
    
}
