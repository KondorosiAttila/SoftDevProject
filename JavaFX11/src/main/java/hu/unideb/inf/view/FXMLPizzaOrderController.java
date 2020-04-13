/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author tisaa
 */
public class FXMLPizzaOrderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Model model;

    public void setModel(Model model) {
        this.model = model;
        termekneve.setText("egy termek neve");
    }
    
    @FXML
    private Button gomb;
    
    @FXML
    private Button resetbutton;

    @FXML
    private CheckBox checkbox;

    @FXML
    private Text termekneve;

    @FXML
    void isButtonpressed(ActionEvent event) {
        if(checkbox.isSelected())
        {
            System.out.println("rendeles kivalasztva");
        }
        else
            System.out.println("nem tortent valasztas.");

    }

    @FXML
    void ischecked(ActionEvent event) {
        checkbox.setSelected(true);
        termekneve.setText("Hurra");
    }
    
    @FXML
    void isResetPressed(ActionEvent event) {
        checkbox.setSelected(false);
        termekneve.setText("Termek");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
