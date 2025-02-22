/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab21;

/**
 *
 * @author MaximFoit
 */


public class Lab21 
{
    public static void main(String[] args) 
    {
        try 
        {
            vehicle a1 = new Automobile("mobile", 5);
            Test(a1);
            //System.out.println("Last changes: "+ a1.getLastModified());
            System.out.println();
            vehicle a2 = new Bike("cycle", 4);
            Test(a2);
            //System.out.println("Last changes: "+ a2.getLastModified());
            /*vehicleMethods.printModels(a1);
            a1.addModel("N6", 100);
            a1.addModel("N7", 888);
            a1.addModel("N8", 100);
            vehicleMethods.printModels(a1);
            a1.removeModel("N6");
            vehicleMethods.printModels(a1);
            System.out.println(a1.getModelPrice("N7"));
            CarTest();
            MotorcycleTest();*/
        }
        catch (DuplicateModelNameException e){System.out.println(e.getMessage());}
        //catch (ModelPriceOutOfBoundsException e){System.out.println(e.getMessage());}
        catch (NoSuchModelNameException e){System.out.println(e.getMessage());}
    }

    public static void Test(vehicle V)throws DuplicateModelNameException, NoSuchModelNameException
    {
        System.out.println(V.getBrand());
        V.setBrand("22:47");
        System.out.println(V.getBrand());
        System.out.println();
        String[] names = V.getModelNames();
        for (String name : names)System.out.println(name);
        System.out.println();
        double[] prices = V.getModelPrices();
        for(double price:prices)System.out.println(price);
        System.out.println();
        V.addModel("NikePro 1", 100);
        V.addModel("NikePro 2", 200);
        //V.addModel("NikePro 0", -777);
        V.addModel("NikePro 3", 300);
        vehicleMethods.printModels(V);
        System.out.println();
        System.out.println();
        V.removeModel("NikePro 2");
        ///V.removeModel("NikePro 777");
        System.out.println();
        vehicleMethods.printModels(V);
        System.out.println();
        vehicleMethods.printPrices(V);
        System.out.println();
        System.out.println("Average cost: " + vehicleMethods.getAverage(V));       
        System.out.println();
        V.setModelPrice("NikePro 3", 777);
        //V.setModelPrice("NikePro 3", -777);
        System.out.println();
        System.out.println(V.getModelPrice("NikePro 3"));
        //System.out.println(V.getModelPrice("NikePro 777"));
        System.out.println();
        V.renameModel("NikePro1", "NikePro 39");
        System.out.println();
        vehicleMethods.printModels(V);
        System.out.println();
    }
    
    /*public static void CarTest() throws DuplicateModelNameException, NoSuchModelNameException 
    {
        Automobile a = new Automobile ("cringemobile", 10);
        vehicleMethods.printModels(a);
        System.out.println();
        vehicleMethods.printPrices(a);
        System.out.println();
        a.addModel("N7", 199);
        a.addModel("N8", 199);
        //a.AddModel("N9999", -1);
        a.addModel("N9", 199);
        vehicleMethods.printModels(a);
        System.out.println();
        a.removeModel("N7");
        vehicleMethods.printModels(a);
        System.out.println();
        System.out.println(a.getModelPrice("N8"));
        System.out.println();
    }

    public static void MotorcycleTest() throws DuplicateModelNameException, NoSuchModelNameException 
    {
        Bike c = new Bike ("cringecycle", 10);
        vehicleMethods.printModels(c);
        System.out.println();
        vehicleMethods.printPrices(c);
        System.out.println();
        c.addModel("N7", 199);
        c.addModel("N8", 199);
        //c.AddModel("N9999", -1);
        c.addModel("N9", 199);
        vehicleMethods.printModels(c);
        System.out.println();
        c.removeModel("N7");
        vehicleMethods.printModels(c);
        System.out.println();
        System.out.println(c.getModelPrice("N8"));
        System.out.println("Last changes: "+ c.getLastModified());
    }*/

    /*public static void main(String[] args) throws NoSuchModelNameException, DuplicateModelNameException
    {
        // Create an instance of Automobile
        Automobile auto = new Automobile("Toyota", 3);

        // Get and print the brand
        System.out.println("Brand: " + auto.getBrand());

        // Set a new brand
        auto.setBrand("Honda");
        System.out.println("New brand: " + auto.getBrand());

        // Get and print the model names
        String[] modelNames = auto.getModelNames();
        System.out.println("Model names: ");
        for (String name : modelNames) System.out.println(name);

        // Get and print the price of a model
        int price = auto.getModelPrice("Model 1");
        System.out.println("Price of Model 1: " + price);

        // Set a new price for a model
        auto.setModelPrice("Model 1", 15000);
        price = auto.getModelPrice("Model 1");
        System.out.println("New price of Model 1: " + price);

        // Get and print the model prices
        int[] modelPrices = auto.getModelPrices();
        System.out.println("Model prices: ");
        for (double priceVal : modelPrices) System.out.println(priceVal);

        // Add a new model
        auto.addModel("Model 4", 20000);
        modelNames = auto.getModelNames();
        System.out.println("Model names after adding a new model: ");
        for (String name : modelNames) System.out.println(name);

        // Remove a model
        auto.removeModel("Model 2");
        modelNames = auto.getModelNames();
        System.out.println("Model names after removing a model: ");
        for (String name : modelNames) System.out.println(name);

        // Get the model count
        int modelCount = auto.getModelCount();
        System.out.println("Model count: " + modelCount);

        Bike bike = new Bike("cringebike", 5000);
        bike.addModel("bike 1", 10000);
        bike.addModel("bike 2", 20000);
        bike.addModel("bike 3", 30000);
        System.out.println("Bike Models: ");
        bike.printModels();
        bike.removeModel("bike 2");
        System.out.println("Models after last changes: ");
        bike.printModels();
        System.out.println("Last changes: "+ bike.getLastModified());
    }*/
}
