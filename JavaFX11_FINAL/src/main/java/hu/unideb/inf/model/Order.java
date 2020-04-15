/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 * Rendelés = megrendelő, dátum, vásárolt termékek listája
 * @author zolit
 */
public class Order implements Serializable{
    Client client;
    LocalDate date;
    ArrayList<Pizza> orderlist;

    public Order() {
    }

    public Order(Client client, ArrayList<Pizza> orderlist, LocalDate date) {
        this.client = client;
        this.orderlist = orderlist;
        this.date = date;
    }
    
    

    public Client getClient() {
        return client;
    }

    public ArrayList<Pizza> getOrderlist() {
        return orderlist;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOrderlist(ArrayList<Pizza> orderlist) {
        this.orderlist = orderlist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    /* TODO */
     private void writeOrder(ObjectOutputStream s) throws IOException {
        
    }

    private void readOrder(ObjectInputStream s) throws IOException, ClassNotFoundException {
        
    }
    
    
}
