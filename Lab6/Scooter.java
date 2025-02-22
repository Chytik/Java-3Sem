/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;

/**
 *
 * @author MaximFoit
 */
public class Scooter implements Vehicle
{
    private static int idNum = 0;
    private String mark;
    private HashMap<String, Integer> models;//<ключ, значение> ключи уникальны

    public Scooter(String mark, int modelsAmount) 
    {
        this.mark = mark;
        this.models = new HashMap<>();
        Random rnd = new Random();
        for (int i = 0; i < modelsAmount; i++) 
        {
            models.put(mark + idNum, rnd.nextInt(5, 50));
            idNum++;
        }
    }
    
    @Override
    public String getBrand() {return mark;}
    
    @Override
    public void setBrand(String mark2) {mark = mark2;}
    
    @Override
    public String[] getModelNames(){return models.keySet().toArray(new String[0]);}
    
    @Override
    public int getModelPrice(String n) throws NoSuchModelNameException 
    {
        if (models.containsKey(n)) return models.get(n);
        else throw new NoSuchModelNameException();
    }
    
    @Override
    public void setModelPrice(String n, int p) throws NoSuchModelNameException 
    { 
        if (p < 0) throw new ModelPriceOutOfBoundsException();
        if (models.containsKey(n)) models.put(n, p);//проверяет наличие ключа, меняет цену.
        else throw new NoSuchModelNameException();
    }
    
    @Override
    public int[] getModelPrices()
    {
        Object[] vals = models.values().toArray();
        int[] vs = new int[vals.length];
        for (int i = 0; i<vals.length; i++)vs[i] = Integer.parseInt(vals[i].toString());
        return vs;
    }
    
    @Override
    public void addModel(String name1, int price1) 
    {
        if (price1 < 0) throw new ModelPriceOutOfBoundsException();
        models.put(name1, price1);
    }
    
    @Override
    public void removeModel(String n) throws NoSuchModelNameException 
    {
            if (models.containsKey(n)) models.remove(n);
            else {throw new NoSuchModelNameException();}
    }
    
    @Override
    public int getModelCount() {return models.size();}
    
    @Override
    public void renameModel(String a, String b) throws NoSuchModelNameException, DuplicateModelNameException 
    {
        if (models.containsKey(a)) 
        {
            if (!models.containsKey(b)) 
            {
                int h = models.get(a);
                models.remove(a);
                models.put(b, h);
            }
            else {throw new DuplicateModelNameException();}
        }
        else {throw new NoSuchModelNameException();}
    }
    
    public String toString() 
    {
        StringBuffer strb = new StringBuffer();
        strb.append(mark);
        strb.append("\n");
        strb.append(models.size());
        strb.append("\n");
        int[] vals = getModelPrices();
        String[] names = getModelNames();
        for (int i = 0; i<models.size(); i++) 
        {
            strb.append(names[i]);
            strb.append("\n");
            strb.append(vals[i]);
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
                String[] names = c.getModelNames();
                int[] TPrices = getModelPrices();
                String[] TNames = getModelNames();
                if (!(Arrays.equals(TNames, names) & Arrays.equals(TPrices, prices))) b = false;
        }
        else b = false;
        return b;
    }
    
    public int hashCode()
    {
        int hash = 7;
        hash = 31 * hash + mark.hashCode();
        int[] TPrices = getModelPrices();
        String[] TNames = getModelNames();
        for (int i = 0; i<models.size(); i++)hash = 3*hash + TNames[i].hashCode() + (int)TPrices[i];
        return hash;
    }
    
    public Scooter clone() throws CloneNotSupportedException 
    {
        Scooter newcar = (Scooter)super.clone();
        newcar.models = new HashMap<>();
        int[] TPrices = getModelPrices();
        String[] TNames = getModelNames();
        for (int i = 0; i < models.size(); i++) newcar.models.put(TNames[i], TPrices[i]);
        return newcar;
    }   
}
