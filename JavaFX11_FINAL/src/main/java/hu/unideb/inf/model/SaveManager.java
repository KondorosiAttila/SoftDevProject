/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zolit
 */
public class SaveManager {

    public static void SaveOrder() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Pizza> LoadOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Pizza> LoadProducts() {
        ArrayList<Pizza> kinalat = new ArrayList<Pizza>();
        // itt kellene txt-t nyitni, kiolvasni a pizza adatokat
        File file = new File("kinalatunk.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String datas[] = sc.nextLine().split(":");
                Pizza p = new Pizza(datas[0], Integer.parseInt(datas[1]), Integer.parseInt(datas[2]));
                ArrayList<String> topping = new ArrayList<>();
                for(int i = 3; i < datas.length; i++)
                {
                    topping.add(datas[i]);
                }
                p.topping = topping;
                kinalat.add(p);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("FILE NEM TALALHATO");
        }
        return kinalat;
    }
    
}
