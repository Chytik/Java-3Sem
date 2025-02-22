/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab21;

/**
 *
 * @author MaximFoit
 */
import java.util.Arrays;
/**
 *
 * @author MaximFoit
 */
public class Automobile implements vehicle
{
    private String brand;
    private Model[] models; 

    public Automobile(String brand, int modelCount) 
    {
        this.brand = brand; this.models = new Model[modelCount];
        for (int i = 0; i < modelCount; i++) this.models[i] = new Model(brand + (i + 1), 10000 + i); 
    }

    @Override
    public String getBrand() {return brand;}

    @Override
    public void setBrand(String brand) {this.brand = brand;}

    private class Model 
    {
        private String name = ""; 
        private int price = 0; 

        public Model(String Name, int Price) 
        {
            name = Name;
            price = Price;
        }

        public void setName(String Name) {name = Name;}

        public int getPrice() {return price;}

        public void setPrice(int Price) {price = Price;}
    }

    @Override
    public String[] getModelNames() 
    {
        String[] names = new String[models.length];
        for (int i = 0; i < models.length; i++) names[i] = models[i].name;
        return names;
    }

    @Override
    public int getModelPrice(String modelName) throws NoSuchModelNameException
    {
        int price = -1; 
        for (Model model : models) 
        {
            if (model.name.equals(modelName))
            {
                price = model.price;
                break;
            }
        }
        if(price==-1){throw new NoSuchModelNameException();}
        return price;
    }  

    @Override
    public void setModelPrice(String modelName, int price) throws NoSuchModelNameException
    {
        if(price<0)throw new ModelPriceOutOfBoundsException();
        boolean F = false;
        for (Model model : models)
        {
            if (model.name.equals(modelName)) 
            {
                model.price = price;
                F =true;
                break;
            }
        }
        if(!F)throw new NoSuchModelNameException();
    }

    @Override
    public double[] getModelPrices() 
    {
        double[] prices = new double[models.length];
        for (int i = 0; i < models.length; i++) prices[i] = models[i].price;
        return prices;
    }

    @Override
    public void addModel(String modelName, int price) throws DuplicateModelNameException
    {
        if(price<0) throw new ModelPriceOutOfBoundsException();
        int c = 0;
        while (c<models.length) 
        {
            if (!modelName.equals(models[c].name)) c += 1;
            else throw new DuplicateModelNameException();
        }
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(modelName, price);
    }

    @Override
    public void removeModel(String modelName) throws NoSuchModelNameException
    {
        int index = -1;
        for (int i = 0; i < models.length; i++) 
        {
            if (models[i].name.equals(modelName))
            {
                index = i;
                break;
            }
        }
        if (index != -1) 
        {
            System.arraycopy(models, index + 1, models, index, models.length - index - 1);
            models = Arrays.copyOf(models, models.length - 1);
        }
        else throw new NoSuchModelNameException();    
    }
    
    @Override
    public void renameModel(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException
    {
        int pos=-1;
        for(int i=0; i<models.length;i++) 
        {
            if(models[i].name.equals(newName)) throw  new DuplicateModelNameException();
            if(models[i].name.equals(oldName))
            {
                pos=i;
                models[i].name = newName;

            }
        }
        if (pos==-1) throw new NoSuchModelNameException();
        else models[pos].name = newName;

    }

    @Override
    public int getModelCount() {return models.length;}
}
