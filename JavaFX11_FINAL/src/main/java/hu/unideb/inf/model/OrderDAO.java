package hu.unideb.inf.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
        /*
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
        */
        String orderline = order.toString();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("orderlistsave_bw.txt", true));
            bw.write(orderline);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            //Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("FILE NEM TALALHATO");
            ex.printStackTrace();
        }    
    }

    /** 
     * Az OrderListSaved.ser fileból betölti az Order objektumokat,
     * és visszaad egy rendeléseket tartalmazó ArrayList-et.
     */
    public static ArrayList<Order> LoadOrders() {
        
        ArrayList<Order> retvalue = new ArrayList<Order>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("orderlistsave_bw.txt"));
            String line;
            while(true){
                line = br.readLine();
                if(line == null)
                    break;
                Order o = new Order();
                String[] items = line.split(":");
                o.id = items[0];
                o.client = new Client();
                o.client.name = items[1];
                o.client.phonenumber = items[2];
                o.client.address = items[3];
                o.client.email = items[4];
                o.pricesum = Integer.parseInt(items[5]);
                String[] pizzalist = items[6].split(",");
                ArrayList<Pizza> thispizzalist = new ArrayList<Pizza>();
                ArrayList<Pizza> kinalat = OrderDAO.loadProducts();
                for(int i = 0; i < pizzalist.length; i++){
                    for(Pizza p : kinalat) {
                        if(p.name.equals(pizzalist[i]))
                            thispizzalist.add(p);
                    }
                }
                o.orderlist = thispizzalist;
                retvalue.add(o);               
            }
            br.close();
        } catch (IOException ex) {
            //Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("FILE NEM TALALHATO");
            ex.printStackTrace();
        }    
        
        /*
        Order o = new Order();
        try
        {
            FileInputStream fis = new FileInputStream("OrderListSaved.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // while((o = (Order) ois.readObject()) != null){
            int i = 0;
            while(i < 5){
                o = (Order) ois.readObject();               
                retvalue.add(o);
                i++;
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
        */
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
