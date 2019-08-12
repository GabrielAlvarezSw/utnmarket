/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utnmarket.src.models;

/**
 *
 * @author Gabriel
 */
public class Product {
    public float price;
    public String name;
    
    public Product(String name, float price){
        this.price= price;
        this.name = name;
    }
    
}
