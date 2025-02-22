/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

import java.io.*;
import java.lang.reflect.*;
import java.util.Scanner;

/**
 *
 * @author MaximFoit
 */
public class VehicleMethods 
{
    public static double getAverage(Vehicle a) 
    {
        int[] intPrices = a.getModelPrices();
        int[] prices = new int[intPrices.length];
        for (int i = 0; i < intPrices.length; i++)prices[i] = intPrices[i];
        double b = 0;
        for (int i = 0; i<prices.length; i++)b += prices[i];
        return b/prices.length;
    }
    public static void printModels(Vehicle a) 
    {
        String b[] = a.getModelNames();
        for (int i = 0; i<b.length; i++) System.out.println(b[i]);
        System.out.println();
    }
    public static void printPrices(Vehicle a) 
    {
        int b[] = a.getModelPrices();
        for (int i = 0; i<b.length; i++)System.out.println(b[i]);
        System.out.println();
    }
    public static void outputVehicle(Vehicle a, OutputStream out) throws IOException 
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
    public static Vehicle inputVehicle(InputStream in) throws IOException, DuplicateModelNameException, Exception 
    {
        DataInputStream d = new DataInputStream(in);
        Vehicle a; 
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

    public static void writeVehicle(Vehicle a, Writer out) throws IOException 
    {   
        PrintWriter h = new PrintWriter(out);
        int l = a.getModelCount();
        String[] names = a.getModelNames();
        int[] prices = a.getModelPrices();
        h.printf("%s;", a.getClass().getName());
        h.printf("%s;", a.getBrand());
        h.printf("%d;", l);
        for (int i = 0; i<l; i++) 
        {
            h.printf("%s;", names[i]);
            h.printf("%d;", prices[i]);
        }
        h.flush();
    }
    
    public static Vehicle readVehicle(Reader in) throws Exception 
    { 
        Scanner d = new Scanner(in).useDelimiter(";");
        Class cls = Class.forName(d.next());
        Object t = cls.getConstructor(new Class[] {String.class, Integer.TYPE}).newInstance("", 0);
        Vehicle a = (Vehicle)t;
        a.setBrand(d.next()); 
        int l = d.nextInt();
        for (int i = 0; i<l; i++)a.addModel(d.next(), d.nextInt());
        return a;
    } 
    
    /*private static Vehicle getTransport(String trClassStr, String mark)throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException 
    {
        Class<?> trClass = Class.forName(trClassStr);
        Constructor<?> constructor = trClass.getConstructor(String.class, int.class);
        return (Vehicle) constructor.newInstance(mark, 0);
    }*/

    public static Vehicle createTransport(String mark, int size, Vehicle vehicle) 
    {
        Class<?> trClass = vehicle.getClass();//<?> - Wildcard, говорит, что тип может быть любым(могут накладываться ограничения.
        try 
        {
            Constructor<?> constructor = trClass.getConstructor(String.class, int.class);//Найти конструктор.
            return (Vehicle) constructor.newInstance(mark, size);//Создание экземпляра.
        } 
        catch (Exception e) {return null;}
    }

    public static double getAverageFromAll(Vehicle ... a) 
    {
        double t = 0;
        for (int i = 0; i<a.length; i++) t = t + getAverage(a[i]);
        if (a.length!=0) t = t/a.length;
        return t;
    }
}
