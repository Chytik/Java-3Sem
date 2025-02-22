/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab31;
import java.io.*;
/**
 *
 * @author MaximFoit
 */
public class vehicleMethods 
{
    public static double getAverage(vehicle a) 
    {
        int[] intPrices = a.getModelPrices();
        int[] prices = new int[intPrices.length];
        for (int i = 0; i < intPrices.length; i++)prices[i] = intPrices[i];
        double b = 0;
        for (int i = 0; i<prices.length; i++)b += prices[i];
        return b/prices.length;
    }
    public static void printModels(vehicle a) 
    {
        String b[] = a.getModelNames();
        for (int i = 0; i<b.length; i++) System.out.println(b[i]);
        System.out.println();
    }
    public static void printPrices(vehicle a) 
    {
        int b[] = a.getModelPrices();
        for (int i = 0; i<b.length; i++)System.out.println(b[i]);
        System.out.println();
    }
    public static void outputVehicle(vehicle a, OutputStream out) throws IOException 
    {
        DataOutputStream d = new DataOutputStream(out);
        int l = a.getModelCount();
        String[] names = a.getModelNames();
        int[] prices = a.getModelPrices();
        d.writeUTF(a.getClass().getSimpleName());
        d.write(a.getBrand().length());
        d.write(a.getBrand().getBytes());
        d.write(l);
        for (int i = 0; i < l; i++) 
        {
            d.write(names[i].length());
            d.write(names[i].getBytes());
            d.writeInt(prices[i]);
        }
    }
    public static vehicle inputVehicle(InputStream in) throws IOException, DuplicateModelNameException, Exception 
    {
        DataInputStream d = new DataInputStream(in);
        vehicle a; 
        switch(d.readUTF()) 
        {
            case("Automobile"):
                a = new Automobile("", 0);
                break;
            default:
                a = new Bike("", 0);
                break;
        }
        int j = d.read();
        a.setBrand(new String(d.readNBytes(j)));
        int l = d.read();
        for (int i = 0; i<l; i++) 
        {
            int h = d.read();
            String a1 = new String (d.readNBytes(h));
            int a2 = d.readInt();
            a.addModel(a1, a2);
        }
        return a;
    }

    public static void writeVehicle(vehicle a, Writer out) throws IOException 
    {   
        PrintWriter h = new PrintWriter(out);
        int l = a.getModelCount();
        String[] names = a.getModelNames();
        int [] prices = a.getModelPrices();
        h.println(a.getClass().getSimpleName());
        h.println(a.getBrand()); 
        h.println(l);
        for (int i = 0; i<l; i++) 
        {
            h.println(names[i]);
            h.println(prices[i]);
        }
        h.flush();
    }
    public static vehicle readVehicle(Reader in) throws IOException, DuplicateModelNameException 
    { 
        BufferedReader d = new BufferedReader(in);
        vehicle a;
        switch(d.readLine()) 
        {
            case("Automobile"):
                a = new Automobile("", 0);
                break;
            default:
                a = new Bike("", 0);
                break;
        }
        a.setBrand(d.readLine()); 
        int l = Integer.parseInt(d.readLine()); 
        for (int i = 0; i<l; i++) 
            a.addModel(d.readLine(), Integer.parseInt(d.readLine()));
        return a;
    }
}
