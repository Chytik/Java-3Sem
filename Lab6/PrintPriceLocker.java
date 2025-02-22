/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author MaximFoit
 */
public class PrintPriceLocker implements Runnable
{
    private Vehicle vehicle;    
    private ReentrantLock locker;
    public PrintPriceLocker(Vehicle vehicle, ReentrantLock locker)
    {
        this.vehicle = vehicle;
        this.locker = locker;
    }
    public void run()
    {
        try 
        {
            locker.lock();
            int[] nm = vehicle.getModelPrices();
            for (int i = 0; i<nm.length; i++)System.out.print("2. " + nm[i] + "\n");
        }finally{locker.unlock();}
    }
}
