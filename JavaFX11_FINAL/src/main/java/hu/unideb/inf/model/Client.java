package hu.unideb.inf.model;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.beans.property.StringProperty;

/**
 * A megrendelő adatait tartalmazó osztály
 * @author zolit
 */
public class Client implements Serializable{
    String name;
    String address;
    String email;
    String phonenumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Client(String name, String address, String email, String phonenumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phonenumber = phonenumber;
    }
    
    public Client() {
    }

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("(").append(this.phonenumber).append(")");
        sb.append(", ").append(this.address).append(", ").append(this.email);
        return sb.toString();
    }
}
