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
import java.time.LocalTime;
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
    String id;

    public static String settingId() {
        String[] d = LocalDate.now().toString().split("-");
        String[] s = LocalTime.now().toString().split("[:.]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(d[i]);
        }
        for (int i = 0; i < s.length-1; i++) {
            sb.append(s[i]);
        }
        return sb.toString();
    } 
    
    public Order() {
    }

    public Order(Client client, ArrayList<Pizza> orderlist, LocalDate date) {
        this.client = client;
        this.orderlist = orderlist;
        this.date = date;
        this.id = Order.settingId();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append(":").append(this.client.name);
        sb.append("(").append(this.client.phonenumber).append("): ");
        for(Pizza p : this.orderlist)
        {
            if(this.orderlist.indexOf(p) != 0) {
                sb.append(", ");
            }
            sb.append(p.name);
        }
        return sb.toString();
    }

    
}
