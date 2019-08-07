/*
 * Excepcion que se arroja cuando se pasa de un estado a otro prohibido.
 *  Ejemplo, en Buy, se quiere pasar de RECHAZADO a PAGADO.
 */
package exceptions;

/**
 *
 * @author Gabriel
 */
public class IllegalStateException extends Exception{
    protected String message;
    public IllegalStateException(String msg){
        message = msg;
    }
    
}
