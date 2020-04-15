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

/**
 * FXML Controller class
 *
 * @author zolit
 */
public class FXMLOrderSceneController implements Initializable {

    private Model model;
    
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
        Pizza p = new Pizza("gyros", 32);
        Pizzas.add(p);
        
        
        kosar = new ArrayList<Pizza>();
        loadKinalat();
    }
    
    ArrayList<Pizza> Pizzas;
    ObservableList list = FXCollections.observableArrayList();
    String DateOfTheOrder;
    ArrayList<Pizza> kosar;
    
    @FXML
    private ListView<String> kinalat;

    @FXML
    private TextField namebox;

    @FXML
    private TextField addressbox;

    @FXML
    private TextField datebox;


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
    }
    
  
    @FXML
    void hozzaadClicked(ActionEvent event) {

    }

    @FXML
    void resetClicked(ActionEvent event) {

    }
    
    @FXML
    void torlesClicked(ActionEvent event) {

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
        System.out.println(o.toString());
        System.out.println("MEGRENDELÉS RÖGZÍTVE!");
    }

    public void setModel(Model model) {
        this.model = model;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
