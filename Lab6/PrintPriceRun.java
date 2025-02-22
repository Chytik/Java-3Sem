/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

/**
 *
 * @author MaximFoit
 */
public class PrintPriceRun implements Runnable
{
    private VehicleSynchronizer transports;
    public PrintPriceRun (VehicleSynchronizer transports){this.transports = transports;}
    public void run()
    {
        while (transports.canPrintPrice())
        {
            try {transports.printPrice();} 
            catch (InterruptedException ex) {}
        }
    }
}
