/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

/**
 *
 * @author MaximFoit
 */
public class PrintPrice extends Thread {
    private Vehicle vehicle;
    public PrintPrice (Vehicle vehicle){this.vehicle = vehicle;}
    
    @Override
    public void run()
    {
         int[] pr = vehicle.getModelPrices(); 
         for (int i = 0; i<pr.length; i++)System.out.print("1. " + pr[i]+ "\n");
    }
}
