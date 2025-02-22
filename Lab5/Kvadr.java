/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author MaximFoit
 */
public class Kvadr implements Vehicle 
{
    private static int idNum = 0;
    private String mark;
    private ArrayList<Model> models;//Generic - можем передать туда любой тип.

    public Kvadr(String mark, int modelsAmount) 
    {
        this.mark = mark;
        this.models = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < modelsAmount; i++) 
        {
            models.add(new Model(mark + idNum, rnd.nextInt(5, 50)));
            idNum++;
        }
    }
    
    @Override
    public String getBrand() {return mark;}
    
    @Override
    public void setBrand(String mark2) {mark = mark2;}
    
    @Override
    public String[] getModelNames()
    {
        String[] names = new String[models.size()];
        for (int i = 0; i < models.size(); i++)names[i] = models.get(i).name;
        return names;
    }
    
    @Override
    public int getModelPrice(String n) throws NoSuchModelNameException 
    {
        int a = 0;
        int c = 0;
        while (c<(models.size())) 
        {
            if (models.get(c).name.equals(n)) 
            {
                a = (int)models.get(c).price;
                c = models.size()*2;
            }
            c+=1;
        }
        if (c == models.size())throw new NoSuchModelNameException();
        return a;
    }
    
    @Override
    public void setModelPrice(String n, int p) throws NoSuchModelNameException 
    { 
        if (p < 0) throw new ModelPriceOutOfBoundsException();
        int c = 0;
        while (c<(models.size())) 
        {
            if (models.get(c).name.equals(n)) 
            {
                models.get(c).price = p;
                c = models.size()*2;
            }
            c+=1;
        }
        if (c == models.size())throw new NoSuchModelNameException();
    }
    
    @Override
    public int[] getModelPrices()
    {
        int[] ps = new int[models.size()];
        for (int i = 0; i < models.size(); i++) ps[i] = (int)models.get(i).price;
        return ps;
    }
    
    @Override
    public void addModel(String name1, int price1) throws DuplicateModelNameException 
    {
            if (price1 < 0) throw new ModelPriceOutOfBoundsException();
            int c = 0;
            while (c<models.size()) 
            {
                if ((name1.equals(models.get(c).name))==false) c += 1;
                else throw new DuplicateModelNameException();
            }
            models.add(new Model(name1, price1));
    }
    
    @Override
    public void removeModel(String n) throws NoSuchModelNameException 
    {
        int c = 0;
        while (c<(models.size())) 
        {
            if (models.get(c).name.equals(n)==false) c+=1;
            else 
            {
                models.remove(c);
                c = models.size()*2;
            }
        }
        if (c == models.size())throw new NoSuchModelNameException();
    }
    
    @Override
    public int getModelCount() {return models.size();}
    
    @Override
    public void renameModel(String a, String b) throws NoSuchModelNameException, DuplicateModelNameException 
    {
        int c = 0;
        int g = models.size()*2;
        while (c<models.size()) 
        {
            if ((models.get(c).name.equals(b))&(!a.equals(b))) {throw new DuplicateModelNameException();}
            else if (models.get(c).name.equals(a))g = c;
            c += 1;
        }
        if (g == models.size()*2) {throw new NoSuchModelNameException();}
        else models.get(g).name = b;
    }
    public String toString() 
    {
        StringBuffer strb = new StringBuffer();
        strb.append(mark);
        strb.append("\n");
        strb.append(models.size());
        strb.append("\n");
        for (int i = 0; i<models.size(); i++) {
            strb.append(models.get(i).name);
            strb.append("\n");
            strb.append(models.get(i).price);
            strb.append("\n");
        }
        return strb.toString();
    }
    
    public boolean equals(Object obj)
    {
        boolean b = true;
        if (obj instanceof Vehicle) 
        {
            Vehicle c = (Vehicle)obj;
            int[] prices = c.getModelPrices();
            if ((c.getBrand().equals(mark))&&(prices.length == models.size())) 
            {
             // double[] prices = c.getAllPrices();
                String[] names = c.getModelNames();
                for (int i = 0; i<models.size(); i++) 
                {
                    if (((models.get(i).name.equals(names[i]))&&(models.get(i).price == prices[i]))==false) 
                    {
                        b = false;
                        i = models.size();
                    }
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
        hash = 31 * hash + mark.hashCode();
        for (int i = 0; i<models.size(); i++)hash = 3*hash + models.get(i).name.hashCode() + (int)models.get(i).price;
        return hash;
    }
    
    public Kvadr clone() throws CloneNotSupportedException 
    {
        Kvadr newcar = (Kvadr)super.clone();
        newcar.models = new ArrayList<Model>();
        for (int i = 0; i < models.size(); i++) newcar.models.add(new Model(models.get(i).name, models.get(i).price));
        return newcar;
    }
    
    private class Model implements Serializable 
    {
        String name;
        double price;
        public Model(String n, double p) 
        {
            name = n;
            price = p;
        }        
        public void setName(String n) {name = n;}
    }
}
