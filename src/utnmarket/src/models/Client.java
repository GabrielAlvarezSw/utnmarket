/*
 * Entidad Cliente.
 */
package utnmarket.src.models;

import exceptions.IllegalTransactionException;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Client {

    public Cart cart;
    public Card card;
    public String name;
    public String email;
    public String password;

    //Constructor
    public Client(Cart cart, Card card, String name, String email, String password) {
        this.cart = cart;
        this.card = card;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean VerificarUserAndPass(String nombre, String email, String contraseña) throws IllegalTransactionException {

        if (nombre == name && contraseña == password || email == this.email && contraseña == password) {
            return true;
        } else {
            throw new IllegalTransactionException("Usuario inexistente");

        }
    }

    public  boolean VerificarCamposVacios(String nombre, String email, String contraseña) throws IllegalTransactionException {
        if (nombre.length() == 0 || email.length() == 0 || contraseña.length() == 0) {
            throw new IllegalTransactionException("Hay campos vacíos");
        } else {
            return true;

        }
    }
}
