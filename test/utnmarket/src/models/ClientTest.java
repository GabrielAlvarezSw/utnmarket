/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utnmarket.src.models;

import exceptions.IllegalTransactionException;
import java.util.Date;
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
public class ClientTest {

    public ClientTest() {
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
     * Test of VerificarUserAndPass method, of class Client.
     */
    @Test //Verificar usuario y contraseña que devuelve True cuando hay coincidencia
    public void testVerificarUserAndPass() throws Exception {
        System.out.println("VerificarUserAndPass");
        String nombre = "";
        String email = "";
        String contraseña = "";
        Card card = new Card("card", "123", new Date());
        Cart cart = new Cart();
        Client cliente = new Client(cart, card, nombre, email, contraseña);
        boolean result = cliente.VerificarUserAndPass(nombre, email, contraseña);
        assertTrue(result);
    }

    @Test(expected = IllegalTransactionException.class) // Vericar que es test lanzo una excepcion cuando se le paso algo incorrecto
    public void testVerificarUserAndPassExcepcion() throws IllegalTransactionException {
        System.out.println("VerificarUserAndPassConException");
        String nombre = "";
        String email = "";
        String contraseña = "";
        Card card = new Card("card", "123", new Date());
        Cart cart = new Cart();
        Client cliente = new Client(cart, card, nombre, email, contraseña);
        boolean result = cliente.VerificarUserAndPass(nombre, "em", "cont");
    }

    /**
     * Test of VerificarCamposVacios method, of class Client.
     */
    @Test // Verificar lance true cuando no hayan campos vacios 
    public void testVerificarCamposVacios() throws Exception {
        System.out.println("VerificarCamposVacios");
        String nombre = "algo";
        String email = "algo";
        String contraseña = "algo";
        Card card = new Card("card", "123", new Date());
        Cart cart = new Cart();
        Client client = new Client(cart, card, nombre, email, contraseña);
        boolean result = client.VerificarCamposVacios(nombre, email, contraseña);
        assertTrue(result);
     
    }

    @Test (expected = IllegalTransactionException.class) // Verificar que lance una excepcion cuando hayan campos vacíos
    public void testVerificarCamposVaciosException()throws IllegalTransactionException {
        System.err.println("VerificarCamposVaciosConExcepcion");
        String nombre = "";
        String email = "";
        String contraseña = "";
        Card card = new Card("card", "123", new Date());
        Cart cart = new Cart();
        Client cliente = new Client(cart, card, nombre, email, contraseña);
        boolean result = cliente.VerificarCamposVacios(nombre, email, contraseña);
    }

}
