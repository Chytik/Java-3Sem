/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab21;

/**
 *
 * @author MaximFoit
 */
public class vehicleMethods 
{
    public static double getAverage(vehicle a) 
    {
        double[] intPrices = a.getModelPrices();
        double[] prices = new double[intPrices.length];
        //for (int i = 0; i < intPrices.length; i++)prices[i] = (double) intPrices[i];
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
        double b[] = a.getModelPrices();
        for (int i = 0; i<b.length; i++)System.out.println(b[i]);
        System.out.println();
    }
}
