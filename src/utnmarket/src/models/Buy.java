/*
 *  Esta clase representa una compra . Tiene información del medio de pago,
 *  El carrito al que se le hace el checkout, la currency
 *
 *
 */
package utnmarket.src.models;

import exceptions.IllegalTransactionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Gabriel
 */
public class Buy {
    //Estados en los que puede estar la compra. 
    public static enum State{
        PENDIENTE, ACEPTADO,RECHAZADO , PAGADO
    }
    
    public List<BuyDetail> details;
    public String payMethod;    //metodo de pago. tarjeta, efectivo.
    public Card card;   //tarjeta, nulo cuando sea efectivo.
    public Client client;
    public Buy.State state;
    
    
    public Buy(){
       this.state = State.PENDIENTE;    //por defecto arranca en pendiente.
       this.payMethod = "efectivo";     //metodo de pago por defecto es efectivo
       this.details= new ArrayList<>();
       this.client = null;
       
    }
    //Le paso un carrito como parametro, hace el checkout e instanciaa compra.
    
    public static Buy createFromCart(Cart cart) throws IllegalTransactionException{
        Buy buy = new Buy();
        HashMap<Product, Integer>products = cart.checkout();
        buy.client = cart.client;
        //Por cada producto en el hashmap genero un detalle.
        for(Product p : products.keySet()){
            int cantidad = products.get(p);
            BuyDetail detail= new BuyDetail(p,cantidad);
            buy.details.add(detail);
        }
       
        return buy;
        
    }
    //Devuelve la suma de todos los productos.
    public float  getTotal(){
       float  sum = 0;
        for(BuyDetail detail : details){
           sum += detail.subtotal;
       }
        return  sum;
    }
    //Aca se asigna como medio de pago una tarjeta.
    public void setCard(Card card) throws IllegalTransactionException{
        
       if(card == null){
           throw new IllegalTransactionException("Debe seleccionar una tarjeta.");
       } 
       //checkeo que sea el propietario de la tarjeta.
       if(!client.card.equals(card)){
           throw new IllegalTransactionException("No tienes asociada esa tarjeta");
       }
       payMethod = "tarjeta";
       card = card;
    }
    
    //se elimina la tarjeta, por ejemplo, para pagar en efectivo.
    public void removeCard() throws IllegalTransactionException{
        if(card == null){
            throw new IllegalTransactionException("No hay una tarjeta seleccionada");
        }
        card = null;
        payMethod = "efectivo";
    }
    
    //El cliente confirma la compra.
    public void accept() throws IllegalStateException{
       if(state != State.PENDIENTE){
           throw new IllegalStateException("La compra ya fue aceptada o rechazada");
       }
       state  = State.ACEPTADO;
       
    }
    //El cliente rechaza la compra
    public void decline()throws IllegalStateException{
        if(state != State.PENDIENTE){
            throw new IllegalStateException("La compra ya fue aceptada o rechazada");
        }
        state = State.RECHAZADO;
    }
    //El cliente paga la compra.
    public void pay(){
        if(state != State.ACEPTADO){
            throw new IllegalStateException();
        }
        state = State.PAGADO;

    }
    
    
    
}
