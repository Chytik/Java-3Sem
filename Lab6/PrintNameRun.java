/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

/**
 *
 * @author MaximFoit
 */
public class PrintNameRun implements Runnable 
{
    private VehicleSynchronizer vehicles;
    public PrintNameRun (VehicleSynchronizer transports){this.vehicles = transports;}
    public void run()
    {
        while (vehicles.canPrintModel())
        {
            try {vehicles.printModel();} 
            catch (InterruptedException ex) {}
        }
    }
}
