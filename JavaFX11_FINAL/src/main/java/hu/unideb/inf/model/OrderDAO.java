package hu.unideb.inf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A rendelések mentésére vonatkozó metódusokat tartalmazó osztály.
 * @author zolit
 */
public class OrderDAO {

/*
    public static void createTheSaveFile(ArrayList<Order> list) {
        
    } 
*/    
    /**
     * A metódus elvégzi a paraméterül kapott rendelés mentését az
     * OrderListSave.ser fileba.
     */
    public static void SaveOrder(Order order){

        try
        {
            FileOutputStream fos = new FileOutputStream("OrderListSaved.ser", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(order);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    /** 
     * Az OrderListSaved.ser fileból betölti az Order objektumokat,
     * és visszaad egy rendeléseket tartalmazó ArrayList-et.
     */
    public static ArrayList<Order> LoadOrders() {
        
        ArrayList<Order> retvalue = new ArrayList<Order>();
        Order o = new Order();
        try
        {
            FileInputStream fis = new FileInputStream("OrderListSaved.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while((o = (Order) ois.readObject()) != null)
            {
                retvalue.add(o);
            }
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Class not found");
            cnfe.printStackTrace();
        }
        
        return retvalue;
    }

    /**
     *  A metódus a kinalatunk.txt szöveges fájlból betölti a termékek (Pizzák)
     *  adatait, és visszaad egy Pizza objektumokat tartalmazó ArrayList-et.
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
