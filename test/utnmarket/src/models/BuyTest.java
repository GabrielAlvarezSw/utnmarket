/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utnmarket.src.models;

import junit.framework.Assert;
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
        
        
        Cart cart = new Cart();
        Product p1 = new Product("p1",2);
        Product p2 = new Product("p2",1);
        cart.addProduct(p1, 1);
        cart.addProduct(p1,1);
        cart.addProduct(p2, 1);
        Buy expResult = new Buy();
        expResult.details.add(new BuyDetail(p1,2));
        expResult.details.add(new BuyDetail(p2,1));
        
        
        Buy result = Buy.createFromCart(cart);
       // Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult.details.size(), result.details.size());
        int eqs = 0;
        for(int i=0; i<result.details.size(); i++){
           BuyDetail detailA = result.details.get(i);
           for(int j=0; j<expResult.details.size(); j++){
               BuyDetail detailB = expResult.details.get(j);
               if(detailB.product.name.equals(detailA.product.name)
                       && detailB.qty == detailA.qty){
                   eqs++;
               }
           }
        }
        assertEquals(eqs, result.details.size());
        
    }

    /**
     * Test of getTotal method, of class Buy.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        Buy instance = new Buy();
        instance.details.add(new BuyDetail(new Product("p1",2),1));
        instance.details.add(new BuyDetail(new Product("p2",2),1));
        float  expResult = 4;
        
        float result = instance.getTotal();
        assertEquals(expResult, result,0.01);
        // TODO review the generated test code and remove the default call to fail.
    }
    /*
    /**
     * Test of setCard method, of class Buy.
     
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
        Buy instance = new Buy();
        instance.accept();
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test(expected = IllegalStateException.class)
    public void testAceptFromRejected(){
        System.out.println("accept from  rejected");
        Buy instance = new Buy();
        instance.state = Buy.State.RECHAZADO;
        instance.accept();
    }
    @Test(expected = IllegalStateException.class)
    public void testAceptFromAccepted(){
        System.out.println("accept from  accepted");
        Buy instance = new Buy();
        instance.state = Buy.State.ACEPTADO;
        instance.accept();
    }
    @Test(expected = IllegalStateException.class)
    public void testAceptFromPaid(){
        System.out.println("accept from  paid");
        Buy instance = new Buy();
        instance.state = Buy.State.PAGADO;
        instance.accept();
    }
    
    
    /**
     * Test of decline method, of class Buy.
     */
    @Test
    public void testDecline() {
        System.out.println("decline");
        Buy instance = new Buy();
       
        instance.decline();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of pay method, of class Buy.
     */
    @Test
    public void testPay() {
        System.out.println("pay");
        Buy instance = new Buy();
        instance.state = Buy.State.ACEPTADO;
        instance.pay();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
