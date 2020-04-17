/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.model.Client;
import hu.unideb.inf.model.Model;
import hu.unideb.inf.model.Order;
import hu.unideb.inf.model.Pizza;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.*;
import javafx.scene.control.SelectionMode;

/**
 * FXML Controller class
 *
 * @author zolit
 */


public class FXMLOrderSceneController implements Initializable {
    
    
    public static Pizza toPizza(String sor)
    {  
        char c = '[';

        sor = sor.replace(c, ';');
        
        c = ']';
   
        int db = 1;
        for (int i = 0; i < sor.length(); i++) {
            if(sor.charAt(i) == ',')
            {
                db++;
            }
        }
       
        
        sor = sor.replace(c, ';');
        sor = sor.trim();
        sor = sor.replace(" ", ";");
        
        String[] tmp = sor.split(";");

        String name = tmp[1].trim();
        ArrayList<String> topping = new ArrayList<>();
         
        for (int i = 3; i < db+3; i++) {
            
            if(tmp[i].contains(","))
            {
                tmp[i] = tmp[i].replace(",", " ");
            }
            
            topping.add(tmp[i].strip());
        }
        
        int size = Integer.parseInt(tmp[tmp.length - 5]);
        
        int price = Integer.parseInt(tmp[tmp.length - 2]);
        
        Pizza p = new Pizza(name, price, size);
        p.setTopping(topping);
        
        return p;
    }

    private Model model;
    public Integer osszeg = 0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /* 
            itt be kellene tolteni a szerializalt pizzakat 
            a Pizzas ArrayListbe
            majd ezutan a loadKinalat metodusban Stringeket csinálni belőlük
            és kitenni a GUI-ra
        */
        Pizzas = new ArrayList<Pizza>();
        Pizza p = new Pizza("Gyrosos", 1400, 32);
        Pizza p1 = new Pizza("Margherita", 1200, 32);
        Pizza p2 = new Pizza("Songoku", 1400,32);
        
        
        
        ArrayList<String> a = new ArrayList<>(){
            {
                add("Sonka");
                add("Gomba");
                add("Kukorica");
            }
        };
        
        p2.setTopping(a);
        Pizzas.add(p2);
        
        ArrayList<String> feltet = new ArrayList<>(){
            {
                add("Mozarella");
                add("Parmezan");
                add("Paradicsom");
            }
        };
        
        p1.setTopping(feltet);
        Pizzas.add(p1);
        
        ArrayList<String> topping = new ArrayList<>(){
            {
                add("Tarja");
                add("Sonka");
                add("Voroshagyma");
                add("Lilahagyma");
                add("Paradicsom");
                add("Uborka");
            }
        };
        p.setTopping(topping);
        Pizzas.add(p);
        
        
        kosar = new ArrayList<Pizza>();
        loadKinalat();
        
        
    }


    ArrayList<Pizza> Pizzas;
    ObservableList list = FXCollections.observableArrayList();
    String DateOfTheOrder;
    ArrayList<Pizza> kosar;
    boolean kipipalva;
    
    
    
    ArrayList<ObservableList> elemek = new ArrayList<>();
    
    //ObservableList tmp = FXCollections.observableArrayList(); //a kipipált tétel
    
    
    
    @FXML
    private ListView<String> kinalat;
    
    @FXML
    private ListView<?> basket;
    
    @FXML
    private TextField namebox;

    @FXML
    private TextField addressbox;

    @FXML
    private TextField sumbox;
    
     @FXML
    private TextField filter1;

    @FXML
    private TextField filter2;

    @FXML
    private TextField filter3;


     

    // https://www.youtube.com/watch?v=gvBGu3mw7YU
    
    private void loadKinalat() {
        //list.removeAll(list);
        list.clear();
        ArrayList<String> PizzasToString = new ArrayList<String>();
        for (Pizza pizza : Pizzas) {
            String s = pizza.toString();
            PizzasToString.add(s);
        }
        list.addAll(PizzasToString);
        kinalat.getItems().addAll(list);
        
        osszeg = 0;
        
        sumbox.setText(osszeg.toString());
    }
    
    
    
    @FXML
    void checkedOnBox() {
        kipipalva = true; 
    }
    
    
    
  
    @FXML
    void hozzaadClicked(ActionEvent event) {
        
            list.clear();
            String s;
            Pizza p = new Pizza();
            /*ArrayList<String> PizzasToString = new ArrayList<String>();
            for (Pizza pizza : Pizzas) {
                String s = pizza.toString();
                PizzasToString.add(s);
            }
            list.addAll(PizzasToString);
            */
            
            list.add(kinalat.getSelectionModel().getSelectedItem());
            
            
            System.out.println(list);
            
            //FXMLOrderSceneController.toPizza(list.toString());
            
            basket.getItems().addAll(list);
           
            s = list.toString();
            p = FXMLOrderSceneController.toPizza(s);
            osszeg += p.getPrice();
            
            sumbox.setText(osszeg.toString() + " Ft");
    }
    

    @FXML
    void resetClicked(ActionEvent event) {
        filter1.setText("");
        filter2.setText("");
        filter3.setText("");
    }
    
    @FXML
    void torlesClicked(ActionEvent event) {
        basket.getItems().clear();
        sumbox.setText("");
        osszeg = 0;
    }
       
     @FXML
    void addSelected(MouseEvent event) {
        String s = kinalat.getSelectionModel().getSelectedItem();
        System.out.println(s);
    }
    
    /* MINTA */
    
    @FXML
    void sendOrder(ActionEvent event) {
        
        Client c = new Client(namebox.getText(), addressbox.getText());
        LocalDate d = LocalDate.now();
        Order o = new Order(c, kosar, d);
            /**
             * TODO
             * saveOrder(o);
             */
        //System.out.println(o.toString());
        //System.out.println("MEGRENDELÉS RÖGZÍTVE!");
    }
    
    
    
    
    

    public void setModel(Model model) {
        this.model = model;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
