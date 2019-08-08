/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utnmarket.src.models;

import exceptions.IllegalTransactionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eLiAs.-
 */
public class CardTest {
    
    public CardTest() {
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
     * Test of verificarCantDigitos method, of class Card.
     */
    @Test
    public void testVerificarCantDigitos() throws IllegalTransactionException {
        System.out.println("verificarCantDigitos");
        String number = "1234567891011121";
        Boolean expResult = true;
        Boolean result = Card.verificarCantDigitos(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of isNumeric method, of class Card.
     */
    @Test
    public void testIsNumeric() throws IllegalTransactionException {
        System.out.println("isNumeric");
        String number = "1234567891011121";
        Boolean expResult = true;
        Boolean result = Card.isNumeric(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
