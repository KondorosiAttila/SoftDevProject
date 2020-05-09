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
import hu.unideb.inf.model.OrderDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javax.swing.text.View;

/**
 * FXML Controller class
 *
 * @author zolit
 */

public class FXMLOrderSceneController implements Initializable {
    
    private Model model; // DONT TOUCH THIS !
    public Integer osszeg = 0;
    ArrayList<Pizza> Pizzas;
    ObservableList list = FXCollections.observableArrayList();
    String DateOfTheOrder;
    ArrayList<Pizza> kosar;
   
    @FXML
    private ListView<String> kinalat;
    
    @FXML
    private ListView<?> basket;
    
    @FXML
    private TextField namebox;

    @FXML
    private TextField addressbox;
    
    @FXML
    private TextField emailbox;

    @FXML
    private TextField phonebox;

    @FXML
    private TextField sumbox;
    
     @FXML
    private TextField filter1;

    @FXML
    private TextField filter2;

    @FXML
    private TextField filter3;
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Pizzas = new ArrayList<Pizza>();
        
        // fájlból olvasás implementálva
        Pizzas = OrderDAO.loadProducts();
               
        kosar = new ArrayList<Pizza>();
        loadKinalat();                
    }
    
    public boolean isPhoneNumberOK(String s)
    {
        if(s.contains("0620-") || s.contains("0630-") || s.contains("0670-"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
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

    // https://www.youtube.com/watch?v=gvBGu3mw7YU
    /*
        A metódus betölti "list" nevű ObservableListbe a kínálatot.
        
    */
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
        /* itt van a megoldas */
        String mystring = kinalat.getSelectionModel().getSelectedItem();
        String pizzaneve = mystring.split(" ")[0];
        Pizza myPizza = new Pizza();
        for(Pizza x : Pizzas)
        {
            if(x.getName().equals(pizzaneve))
            {
                myPizza = x;
                break;
            }
        }
        kosar.add(myPizza);
        System.out.println(mystring);
        
        
        //
        list.add(kinalat.getSelectionModel().getSelectedItem());   
        basket.getItems().addAll(list);   
        s = list.toString();
        p = toPizza(s);
        osszeg += p.getPrice();
           
        sumbox.setText(osszeg.toString() + " Ft");
    }
       
    @FXML
    void keresClicked(ActionEvent event) {
        
        Pizza p;
        String target = filter1.getText();
        String target2 = filter2.getText();
        String target3 = filter3.getText();
        
        if(target.length() == 0 && target2.length() == 0 && target3.length() == 0)
        {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Hiba!");
            a.setHeaderText("Rossz bevitel!");
            a.setContentText("Ajd meg legalább egy szűrő feltételt!");

            a.showAndWait();   
        }
        else{
            loadKinalat();
            list.clear();
        
        
            if(target.length() > 0)
            {
                for (int i = 0; i < kinalat.getItems().size(); i++) {
                    String sor = kinalat.getItems().get(i);
                    p = toPizza(sor);

                    for (String item : p.getTopping()) {
                        //System.out.println(item.contains(sor) + " " + item + " " + sor);
                        if(item.equals(target) || item.contains(target))
                        {        
                            if(!list.contains(sor))
                            {
                                list.add(sor);
                            }
                        }
                    }
                }     
            }

            if(target2.length() > 0)
            {
                for (int i = 0; i < kinalat.getItems().size(); i++) {
                    String sor = kinalat.getItems().get(i);
                    p = toPizza(sor);

                    for (String item : p.getTopping()) {
                        //System.out.println(item.contains(sor) + " " + item + " " + sor);
                        if(item.equals(target2) || item.contains(target2))
                        {        
                            if(!list.contains(sor))
                            {
                                list.add(sor);
                            }
                        }
                    }
                }     
            }

            if(target3.length() > 0)
            {
                for (int i = 0; i < kinalat.getItems().size(); i++) {
                    String sor = kinalat.getItems().get(i);
                    p = toPizza(sor);

                    for (String item : p.getTopping()) {
                        //System.out.println(item.contains(sor) + " " + item + " " + sor);
                        if(item.equals(target3) || item.contains(target3))
                        {        
                            if(!list.contains(sor))
                            {
                                list.add(sor);
                            }
                        }
                    }
                }
            }

            kinalat.getItems().clear();
            kinalat.getItems().addAll(list);
        }
    }
    

    @FXML
    void resetClicked(ActionEvent event) {
        filter1.setText("");
        filter2.setText("");
        filter3.setText("");
        
        kinalat.getItems().clear();
        loadKinalat();
    }
    
    @FXML
    void torlesClicked(ActionEvent event) {
        basket.getItems().clear();
        kosar.clear();
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
        //System.out.println(o.toString());
        //System.out.println("MEGRENDELÉS RÖGZÍTVE!");
                
        //Now doing
        String email = emailbox.getText();
        String telefonszam = phonebox.getText();
        
        Client c = new Client(namebox.getText(), addressbox.getText(), email, telefonszam);
        LocalDate d = LocalDate.now();
        
        
        Order o = new Order(c, kosar, d);
        if(!email.contains("@") || !isPhoneNumberOK(telefonszam))
        {
            if(!isPhoneNumberOK(telefonszam))
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba!");
                alert.setHeaderText("Nem érvényes telefonszám!");
                alert.setContentText("Próbáld meg '06xx-1234567 (xx = 20, 30, 70)' formában");

                alert.showAndWait();   
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Hiba!");
                alert.setHeaderText("Nem érvényes e-mail cím!");
                alert.setContentText("Próbáld meg 'valami@valahol.com/hu' formában");
                alert.showAndWait();   
            }
        }    
        else{
            //rendelés file-ba mentése
            OrderDAO.SaveOrder(o);
            System.out.println("Rendelés leadva!");
            System.out.println(o);
            
            kosar.clear();
            basket.getItems().clear();
            namebox.clear();
            addressbox.clear();
            phonebox.clear();
            emailbox.clear();
            osszeg = 0;
            
            Alert myalert = new Alert(Alert.AlertType.WARNING);
            myalert.setTitle("SIKER");
            myalert.setHeaderText("Rendelés sikeresen rögzítve!");
            myalert.showAndWait();
        }
    }
    
    
    
    
    
// DONT TOUCH THIS !
    public void setModel(Model model) {
        this.model = model;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
