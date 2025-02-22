/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab21;

/**
 *
 * @author MaximFoit
 */
public class ModelPriceOutOfBoundsException extends RuntimeException 
{
    public ModelPriceOutOfBoundsException() {super("Error, incorrect model price"); }
    public void printmessage() {System.out.println("Error, incorrect model price"); }
}
