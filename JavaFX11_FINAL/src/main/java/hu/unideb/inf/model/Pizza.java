package hu.unideb.inf.model;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.beans.property.StringProperty;

/**
 * Pizza osztaly
 * @author zolit
 */
public class Pizza implements Serializable {
    String name;
    int price;
    int size;
    boolean extra;
    ArrayList<String> topping;

    public Pizza(String name, int price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.topping = new ArrayList<String>();
        
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
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

    public void setPrice(int price) {
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

    @Override
    public String toString() {
        return name + " " + topping.toString() + " " + "Méret: " + size + " cm " + "Ár: " + price + " Ft";
    }
    
}
