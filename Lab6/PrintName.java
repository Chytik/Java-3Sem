/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

/**
 *
 * @author MaximFoit
 */
public class PrintName extends Thread  
{
    private Vehicle vehicle;
    public PrintName (Vehicle vehicle){this.vehicle = vehicle;}
         
    @Override
    public void run()
    {
        String[] nm = vehicle.getModelNames();
        for (int i = 0; i<nm.length; i++)System.out.print("1. " + nm[i] + "\n");
    }
}
