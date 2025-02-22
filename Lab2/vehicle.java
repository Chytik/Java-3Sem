/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab21;

/**
 *
 * @author MaximFoit
 */
public interface vehicle 
{
    public String getBrand();
    public void setBrand(String mark2);
    public String[] getModelNames();
    public int getModelPrice(String n) throws NoSuchModelNameException;
    public void setModelPrice(String n, int p) throws NoSuchModelNameException;
    public double[] getModelPrices();
    public void addModel(String name1, int price1) throws DuplicateModelNameException;
    public void removeModel(String n) throws NoSuchModelNameException;
    public int getModelCount();
    public void renameModel(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException;
}
