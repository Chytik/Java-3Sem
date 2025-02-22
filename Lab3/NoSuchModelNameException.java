/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab31;

/**
 *
 * @author MaximFoit
 */
public class NoSuchModelNameException extends Exception 
{
    public NoSuchModelNameException() {super("Error, model does not exist"); }
    public void printmessage() {System.out.println("Error, model does not exist"); }
}
