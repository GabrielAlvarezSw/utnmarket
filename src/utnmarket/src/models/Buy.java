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
    
    //Hago el constructor privado para poder generar un metodo estatico , createFromCart,
    //factoría. La unica forma de instanciar una compra, es con un carrito, invocando a
    // Buy.createFromCart(cart)
    private Buy(){
       this.state = State.PENDIENTE;    //por defecto arranca en pendiente.
       this.payMethod = "efectivo";     //metodo de pago por defecto es efectivo
       this.details= new ArrayList<>();
       
    }
    //Le paso un carrito como parametro, hace el checkout e instanciaa compra.
    
    public static Buy createFromCart(Cart cart) throws IllegalTransactionException{
        Buy buy = new Buy();
        HashMap<Product, Integer>products = cart.checkout();
        buy.client = cart.client;
        //Por cada producto en el hashmap genero un detalle.
        for(Product p : products.keySet()){
            int cantidad = products.get(p);
            int total = p.price* cantidad;
            BuyDetail detail= new BuyDetail(p,cantidad,total);
            buy.details.add(detail);
        }
       
        return buy;
        
    }
    //Devuelve la suma de todos los productos.
    public int getTotal(){
       int sum = 0;
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
    public void accept(){
       throw new NotImplementedException();
    }
    //El cliente rechaza la compra
    public void decline(){
        throw new NotImplementedException();
    }
    //El cliente paga la compra.
    public void pay(){
      throw new NotImplementedException();

    }
    
    
    
}
