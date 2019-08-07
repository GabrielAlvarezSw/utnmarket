/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utnmarket.src.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel
 */
public class BuyTest {
    
    public BuyTest() {
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
     * Test of createFromCart method, of class Buy.
     */
    @Test
    public void testCreateFromCart() throws Exception {
        System.out.println("createFromCart");
        Cart cart = null;
        Buy expResult = null;
        Buy result = Buy.createFromCart(cart);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal method, of class Buy.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Buy instance = null;
        int expResult = 0;
        int result = instance.getTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCard method, of class Buy.
     */
    @Test
    public void testSetCard() throws Exception {
        System.out.println("setCard");
        Card card = null;
        Buy instance = null;
        instance.setCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCard method, of class Buy.
     */
    @Test
    public void testRemoveCard() throws Exception {
        System.out.println("removeCard");
        Buy instance = null;
        instance.removeCard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of accept method, of class Buy.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        Buy instance = null;
        instance.accept();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decline method, of class Buy.
     */
    @Test
    public void testDecline() {
        System.out.println("decline");
        Buy instance = null;
        instance.decline();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Buy.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        Buy instance = null;
        instance.pay();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
