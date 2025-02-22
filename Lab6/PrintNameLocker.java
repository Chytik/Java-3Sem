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
public class PrintNameLocker implements Runnable
{
    private Vehicle vehicle;
    private ReentrantLock locker;
    public PrintNameLocker(Vehicle vehicle, ReentrantLock locker)
    {
        this.vehicle = vehicle;
        this.locker = locker;
    }
    public void run() 
    {
        try
        { //обязательно так как при ошибке он не разлочит поток 
            locker.lock();         
            String[] nm = vehicle.getModelNames();
            for (int i = 0; i<nm.length; i++)System.out.print("2. " + nm[i] + "\n");
        }finally{locker.unlock();}
    }
}
