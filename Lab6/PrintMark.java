/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

/**
 *
 * @author MaximFoit
 */
public class PrintMark implements Runnable
{
    private Vehicle vehicle;
    public PrintMark(Vehicle vehicle){this.vehicle = vehicle;}
    public void run(){System.out.println(vehicle.getBrand());}
}
