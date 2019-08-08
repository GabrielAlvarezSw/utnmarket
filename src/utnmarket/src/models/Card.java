/*
 * Tarjeta de Credito del cliente.
 
 */
package utnmarket.src.models;

import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Card {
    public String number;
    public String code;
    public Date expiration;
        
    //Constructor
    public Card(String number, String code, Date expiration) {
        this.number = number;
        this.code = code;
        this.expiration = expiration;
    }
    
   //METODOS
    
   //Verificar que los digitos ingresados sean 16
   public static Boolean verificarCantDigitos (String number){
       if (number.length() == 16){
           return true;
       }else {
           System.out.print("La cantidad de digitos ingresados es incorrecto.");
           return false;
       }
   
   }
   
   //Verificar que los digitos ingreados sean enteros
   public static Boolean isNumeric (String number){
    
     for(int i = 0; i<number.length(); i++)
        if( !Character.isDigit(number.charAt(i)) ){
            return false;
        }
    return true;
 }
   
    

   

 
  
}
   
  
