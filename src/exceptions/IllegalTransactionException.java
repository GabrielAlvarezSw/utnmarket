/*
 *  Esta clase esta pensada para excepciones de operaciones ilegales.
*   Por ejemplo, cuando se quiere comprar un carrito (metodo checkout) vacío.
*    
-*
 */
package exceptions;

/**
 *
 * @author Gabriel
 */
public class IllegalTransactionException  extends Exception{
   protected String message;
    public IllegalTransactionException(String msg){
        message = msg;
    } 
}
