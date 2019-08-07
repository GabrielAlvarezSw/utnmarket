/*
 *  Clase principal. Representa al Carrito de Compras . 
 *  Tiene que tener los metodos para agregar, eliminar productos y hacer el checkout.
 *
 *
 */
package utnmarket.src.models;

import exceptions.IllegalTransactionException;
import java.util.HashMap;
import java.util.Map;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Gabriel
 */
public class Cart {
    //Guarda la lista de Productos con su cantidad (int)
    private  HashMap<Product, Integer> products;
    public Client client;
    
    public void addProduct(Product product, int qty){
        throw new NotImplementedException();
    }
    public void removeProduct(Product product, int qty){
        throw new NotImplementedException();
    }
    
    //Hace el checkout del carrito, retorna el map con todos los productos
    // resetea a 0 el carrito (lista de productos y cantidades)
    public HashMap<Product,Integer> checkout() throws IllegalTransactionException{
       //Checkeamos que hayan productos. Si no, falla y tira una IllegalTransactionException.
       if(products.isEmpty()){
           throw new IllegalTransactionException("El carrito no puede estar vacio.");
       }
       HashMap<Product,Integer>aux = products;
       products = new HashMap<>();
       return aux;
       
    }
    
   
}
