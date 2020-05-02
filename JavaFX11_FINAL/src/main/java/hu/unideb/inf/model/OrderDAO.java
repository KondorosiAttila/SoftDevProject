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
public class OrderDAO {

    /*
        TODO
    */
    public static void SaveOrder(Order order) {
        
    }

    /*
        TODO
    */
    public static ArrayList<Pizza> LoadOrders() {
        return null;
    }

    /*
        A metódus a kinalatunk.txt szöveges fájlból betölti a termékek (Pizzák)
        adatait, és visszaad egy Pizza objektumokat tartalmazó ArrayList-et
    */
    public static ArrayList<Pizza> loadProducts() {
        ArrayList<Pizza> kinalat = new ArrayList<Pizza>();
        // itt kellene txt-t nyitni, kiolvasni a pizza adatokat
        File file = new File("kinalatunk.txt");
        try {
            Scanner sc = new Scanner(file, "UTF-8"); // ékezeteket is megjeleníti
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
