/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

/**
 *
 * @author MaximFoit
 */
public class VehicleSynchronizer {
    private Vehicle v;
    private volatile int current = 0; //индкс элемента в массиве моделей
    private Object lock = new Object(); //объект который блокируется
    private boolean set = false; //флаг
   
    public VehicleSynchronizer(Vehicle v) {
        this.v = v;
    }
   
    //разберите построчно следущие 2 метода
    public void printPrice() throws InterruptedException {
        double val;
        synchronized(lock) //блокирует объект Код нельзя выполнять без блокировки, потому что синхронайзд.
        { 
            int [] p = v.getModelPrices();
            if (!canPrintPrice()) throw new InterruptedException();
            while (!set)lock.wait(); //ждет пока разблокирую и сам разлочивает нижний метод(засыпает). После пробуждения будет лочиться еще раз, потому что синхронайзд и не лочиться нельзя.
            val = p[current++];
            System.out.println("Print price: " + val);
            set = false;
            lock.notifyAll();
        }
    }  
   
    public void printModel() throws InterruptedException 
    {
        synchronized(lock) //блоктровка
        {
            String [] s = v.getModelNames();
            if (!canPrintModel()) throw new InterruptedException();
            while (set)lock.wait();// ждет пока разлочат с верхнего метода(засыпает)
            System.out.println("Print model: " + s[current]);
            set = true;
            lock.notifyAll(); // разлочка верхнего метода
        }
    }
    
    public boolean canPrintPrice() {return current < v.getModelCount();} //проверка длинны массива моделейёё есть ли она
    
    public boolean canPrintModel() {return (!set && current < v.getModelCount()) || (set && current < v.getModelCount() - 1);}
    //для смены порядка помунять сет, карент и условия в нижних методах.
}
