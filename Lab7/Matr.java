/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.genious7;

import java.io.Serializable;
import java.util.Random;
/**
 *
 * @author MaximFoit
 */
public class Matr implements Serializable
{
    private double[][] matr;
    public Matr(int r, int c)
    {
       this.matr = new double[r][c];
       for(int i = 0; i < matr.length; i++)
        {
           for(int j = 0; j < matr[i].length; j++)
           {
             Random random = new Random();
             this.matr[i][j] = random.nextInt(100,300);
           }
        }
    }
    public double[][] getMatrixDouble() {return matr;}
    public int getMatrixSizeRow() 
    {
        if (matr != null)return matr.length;
        else throw new NullPointerException("Matrix null"); 
    }
    public int getMatrixSizeCount(int r) 
    {
        if (r >= 0 && r < matr.length) 
        {
            if (matr[r] != null)return matr[r].length; 
            else throw new NullPointerException("Row null");
        }
        else throw new IndexOutOfBoundsException("invalid");
    }
    public double getElement(int r, int c) 
    {
        if (c >= 0 && c < matr[r].length && r >= 0 && r < matr.length) return matr[r][c];
        else throw new IndexOutOfBoundsException("invalid");
    }
    public void setElement(int r, int c, double d) 
    {
        if (c >= 0 && c < matr[r].length && r >= 0 && r < matr.length) matr[r][c] = d;
        else throw new IndexOutOfBoundsException("invalid");
    }
    public static double SumOdd (Matr m)
    {
        double sum = 0;
        double[][] matrix = m.getMatrixDouble();
        for(int i = 0; i <  matrix.length; i++)
        {
           for(int j = 0; j <  matrix[i].length; j++)
           {
              if(matrix[i][j] % 2 != 0)sum += matrix[i][j];
           }
        }
        return sum;
    }
}
