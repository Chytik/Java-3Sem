/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab31;
import java.io.*;
/**
 *
 * @author MaximFoit
 */
public class Lab31 
{
    public static void main(String[] args)  throws Exception
    {

            vehicle a1 = new Automobile("mobile", 1);
            a1.addModel("N6", 100);
            a1.addModel("N7", 888);
            a1.addModel("N8", 100);
            //vehicleMethods.printModels(a1);
            
            OutputStream out = new FileOutputStream("data.byte");
            vehicleMethods.outputVehicle(a1, out);
            InputStream in = new FileInputStream("data.byte");
            vehicle a2 = vehicleMethods.inputVehicle(in);
            
            /*FileWriter out2 = new FileWriter("data2.txt");
            vehicleMethods.writeVehicle(a1, out2);
            out2.close();          
            FileReader in2 = new FileReader("data2.txt");
            vehicle a2 = vehicleMethods.readVehicle(in2);
            in2.close();*/
            
            /*FileOutputStream fos = new FileOutputStream("data3.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a1);
            oos.close();
            FileInputStream fis = new FileInputStream("data3.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            vehicle a2 = (vehicle)ois.readObject();*/
            
            //vehicle a22 = vehicleMethods.readVehicle(new InputStreamReader(System.in));
            vehicleMethods.writeVehicle(a2, new OutputStreamWriter(System.out));
          
          //System.out.println("ser");
            //vehicleMethods.printModels(a2);
            vehicleMethods.printPrices(a2);
    }
}
