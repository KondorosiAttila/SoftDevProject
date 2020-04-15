/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.util.ArrayList;
import javafx.beans.property.StringProperty;

/**
 * Pizza osztaly
 * @author zolit
 */
public class Pizza {
    String name;
    double price;
    int size;
    boolean extra;
    ArrayList<String> topping;

    public Pizza(String name, int size) {
        this.name = name;
        this.size = size;
        this.extra = true;
        this.topping = new ArrayList<String>();
        this.topping.add("cheese");
        
        // ebben a constructorban még be kell állítani: topping, price
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public boolean isExtra() {
        return extra;
    }

    public ArrayList<String> getTopping() {
        return topping;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public void setTopping(ArrayList<String> topping) {
        this.topping = topping;
    }
    
    
    
    
    
}
