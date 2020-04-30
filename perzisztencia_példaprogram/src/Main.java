import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Car c = new Car("Red Bull Racing", "Honda", 1000);
        Driver d = new Driver("Max Verstappen", c, 33);

        ArrayList<Driver> lista = new ArrayList<Driver>();
        lista.add(d);
        try
        {
            FileOutputStream fos = new FileOutputStream("DriverList.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        // ki lett írva

        ArrayList<Driver> kiolvasott = new ArrayList<Driver>();

        try
        {
            FileInputStream fis = new FileInputStream("DriverList.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            kiolvasott = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException cnfe)
        {
            System.out.println("Class not found");
            cnfe.printStackTrace();
            return;
        }

        for (Driver x : kiolvasott) {
            System.out.println(x);
        }

        /*
        ArrayList<String> namesList0 = new ArrayList<String>();
        namesList0.add("zoli1");
        namesList0.add("zoli2");
        namesList0.add("charles");
        try
        {
            FileOutputStream fos = new FileOutputStream("listData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(namesList0);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        ArrayList<String> namesList = new ArrayList<String>();

        try
        {
            FileInputStream fis = new FileInputStream("listData.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            namesList = (ArrayList) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        //Verify list data
        for (String name : namesList) {
            System.out.println(name);
        }
        */
    }
}
