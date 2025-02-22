/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

import java.util.Random;
import java.io.Serializable;

/**
 *
 * @author MaximFoit
 */
public class Bike implements Vehicle
{
    private class Model implements Serializable
    {
        String name = null;
        int price = 0;
        Model prev = null;
        Model next = null;
        public Model(String n, int p) 
        {
            name = n;
            price = p;
        }        
        public void setName(String n) {name = n;}
    }

    private String brand;
    private int size;
    private Model head;
    transient private long lastModified = 0;{getLastVodified();}//!!!{}ЕСТЬ!

    public void getLastVodified(){lastModified = System.currentTimeMillis();System.out.println(lastModified);} 

    public Bike (String brand1, int size) 
    {
        brand = brand1;
        head = new Model("", 0);
        head.next = head;
        head.prev = head;
        for (int i = 0; i<size;i++) 
        {
            Model m = new Model(brand1 + (i + 1), 10000 + i);
            m.next = head;
            m.prev = head.prev;
            head.prev.next = m;
            head.prev = m;
        }
        this.size = size;
    }
    
    @Override
    public String getBrand() {return brand;}
    
    @Override
    public void setBrand(String brand1) 
    {
        brand = brand1;
        getLastVodified();
    }
    
    @Override
    public String[] getModelNames()
    {
        String[] names = new String[getModelCount()];
        Model tl = head.next;
        int c = 0;
        while (tl!=head) 
        {
            names[c] = tl.name;
            tl = tl.next;
            c+=1;
        }
        return names;
    }
    
    @Override
    public int getModelCount(){return size;}
    
    @Override
    public int getModelPrice(String n) throws NoSuchModelNameException 
    { 
        int a = 0;
        Model tl = head.next;
        while ((tl!=head)&(!tl.name.equals(n)))tl = tl.next;
        if (tl==head) throw new NoSuchModelNameException();
        a = tl.price;
        return a;
    }
    
    @Override
    public void setModelPrice(String n, int p) throws NoSuchModelNameException 
    { 
        if (p < 0) throw new ModelPriceOutOfBoundsException();
        Model tl = head.next;
        while ((tl!=head)&(!tl.name.equals(n)))tl = tl.next;
        if (tl==head)throw new NoSuchModelNameException();
        tl.price = p;
        getLastVodified();
    }
    
    @Override
    public int [] getModelPrices()
    {
        int [] prices = new int[getModelCount()];
        Model tl = head.next;
        int c = 0;
        while (tl!=head) 
        {
            prices[c] = tl.price;
            tl = tl.next;
            c+=1;
        }
        return prices;
    }
    
    @Override
    public void addModel(String modelName, int price) throws DuplicateModelNameException
    {
        if (price < 0)throw new ModelPriceOutOfBoundsException();
        Model tl = head.next;
        while (tl!=head) 
        {
            if (tl.name.equals(modelName))throw new DuplicateModelNameException();
            tl = tl.next;
        }
        Model a = new Model(modelName, price);
        a.next = head;
        a.prev = head.prev;
        head.prev.next = a;
        head.prev = a;
        size++;
        getLastVodified(); 
    }

    @Override
    public void removeModel(String modelName) throws NoSuchModelNameException
    {
        boolean F = false;
        Model current = head;
        while (current.next != head) 
        {
            if (current.name.equals(modelName)) 
            {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--; F = true;
                getLastVodified();
                break;
            }
            current = current.next;
        }
        if(!F) throw new NoSuchModelNameException();
    }
    
    @Override
    public void renameModel(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException
    {
        Model pos = null;
        Model tl = head.next;
        while (tl != head) 
        {
            if(tl.name.equals(newName)) throw new DuplicateModelNameException();
            if (tl.name.equals(oldName)) pos= tl;
            tl = tl.next;
        }
        if (pos==null) throw new NoSuchModelNameException();
        else pos.name = newName;
        getLastVodified(); 
    }

    public long getLastModified() {return lastModified;}
    
    public String toString() 
    {
        StringBuffer strb = new StringBuffer();
        strb.append(brand);
        strb.append("\n");
        strb.append(size);
        strb.append("\n");
        Model tl = head.next;
        while (tl!=head)
        {
            strb.append(tl.name);
            strb.append("\n");
            strb.append(tl.price);
            strb.append("\n");
            tl = tl.next;
        }
        return strb.toString();
    }
    
    public boolean equals(Object obj)
    {
        boolean b = true;
        if(this==obj) return b;
        if (obj instanceof Vehicle) 
        {
            Vehicle c = (Vehicle)obj;
            int[] prices = c.getModelPrices();
            if ((c.getBrand().equals(brand))&&(prices.length == size)) 
            {
                //double[] prices = c.getAllPrices();
                String[] names = c.getModelNames();
                Model tl = head.next;
                int count = 0;
                while ((tl!=head)&&(count < prices.length)) 
                {
                    if (!((tl.name.equals(names[count]))&(tl.price == prices[count]))) 
                    {
                        b = false;
                        tl = head;
                    }
                    tl = tl.next;
                    count += 1;
                }
            }
            else b = false;
        }
        else b = false;
        return b;
    }
    
    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + brand.hashCode();
        Model tl = head.next;
        while (tl!=head)
        {
            hash = 3*hash + tl.name.hashCode() + (int)tl.price;
            tl = tl.next;
        }
        return hash;
    }
    
    @Override
    public Bike clone() throws CloneNotSupportedException 
    {
        Bike newm = (Bike)super.clone();
       // newm.setMark(mark);
        newm.head = new Model("", 0);
        newm.head.next = newm.head;
        newm.head.prev = newm.head;
        Model tl = head.next;
        while (tl!=head) 
        {
            Model m = new Model(tl.name, tl.price);
            m.next = newm.head;
            m.prev = newm.head.prev;
            newm.head.prev.next = m;
            newm.head.prev = m;
            tl = tl.next;
        }
        return newm;
    }
}
