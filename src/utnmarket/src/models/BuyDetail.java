/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utnmarket.src.models;

/**
 *
 * Detalle de Compra. 
 * Tiene info del producto elegido, su cantidad y el subtotal 
 *  (precio x cantidad). 
 *  Tiene sentido persistir el subtotal por si los precios cambian.
 */
public class BuyDetail {
    public Product product;
    public int qty;
    public float subtotal;    
    
    public BuyDetail(Product product, int qty){
        this.product = product;
        this.qty = qty;
        this.subtotal = product.price * qty;
    }
    
}
