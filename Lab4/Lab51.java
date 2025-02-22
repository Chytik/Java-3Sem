/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab51;

import java.lang.reflect.Method;
import java.io.*;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author MaximFoit
 */
public class Lab51 
{
    public static void main(String[] args)  throws Exception//обертки позволяют обычный тип представить ввиде ссылочного.
    {
        //1 задание 

        /*Vehicle vehicle = new Bike("Moto", 1);

        System.out.println(vehicle.getBrand());
        VehicleMethods.printModels(vehicle);
        VehicleMethods.printPrices(vehicle);

        Class<?> trClass = Class.forName(args[0]);
        Method method = trClass.getMethod(args[1], String.class, int.class);
        method.invoke(vehicle, args[2],Integer.parseInt(args[3]));

        System.out.println(vehicle.getBrand());
        VehicleMethods.printModels(vehicle);
        VehicleMethods.printPrices(vehicle);*/

        //2 задание

        Vehicle transport = new Automobile("aron", 1);
        System.out.println(transport);//неявный призыв toString.
        transport = VehicleMethods.createTransport("UVAZ", 2, transport);
        System.out.println(transport);

        //Проверка методов (3, 4, 5 задание)

        /*Vehicle transport = new Automobile("Toyota", 2);
        System.out.println("Brand: " + transport.getBrand());
        transport.setBrand("Nissan");
        System.out.println("New Brand: " + transport.getBrand());

        System.out.println("Names of Models: " + Arrays.toString(transport.getModelNames()));
        transport.renameModel("Toyota1", "Toyota0000");
        System.out.println("New names of models: " + Arrays.toString(transport.getModelNames()));

        System.out.println("Price of the first model: " + transport.getModelPrice("Toyota0000"));
        transport.setModelPrice("Toyota0000", 100);
        System.out.println("New prices: " + Arrays.toString(transport.getModelPrices()));

        System.out.println("Jld models: ");
        VehicleMethods.printModels(transport);
        System.out.println("New models: ");
        transport.removeModel("Toyota0000");
        transport.addModel("Toyota999", 999);
        VehicleMethods.printModels(transport);

        System.out.println("Models' count: " + transport.getModelCount());

        System.out.println("Before: ");
        System.out.println("The old transport: " + transport);
        System.out.println("Hesh-code: " + transport.hashCode());
        Vehicle clonnedTransport = (Vehicle) transport.clone();
        System.out.println("New transport: " + clonnedTransport);
        System.out.println("Hash-code: " + clonnedTransport.hashCode());
        System.out.println("Equals: " + transport.equals(clonnedTransport));

        System.out.println("After: ");
        System.out.println("old transport: " + transport);
        System.out.println("Hesh-code: " + transport.hashCode());
        clonnedTransport.removeModel("Toyota999");
        System.out.println("New transport: " + clonnedTransport);
        System.out.println("Hesh-code: " + clonnedTransport.hashCode());
        System.out.println("Equals: " + transport.equals(clonnedTransport));*/

        //6 задание

        /*Vehicle transport1 = new Moped("Aston Martin", 3);
        Vehicle transport2 = new Scooter("Maserati", 2);
        Vehicle transport3 = new Kvadr("Koenigsegg", 1);
        System.out.println(VehicleMethods.getAverageFromAll(transport1, transport2, transport3));*/

        //7 задание

        /*Vehicle transport = new Scooter("Mercedes", 3);
        VehicleMethods.writeVehicle(transport, new FileWriter("Lamborghini.txt"));
        transport = VehicleMethods.readVehicle(new FileReader("Lamborghini.txt"));
        VehicleMethods.writeVehicle(transport, new OutputStreamWriter(System.out));*/
    }
}
