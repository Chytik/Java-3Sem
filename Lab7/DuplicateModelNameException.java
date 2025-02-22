/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.genious7;

/**
 *
 * @author MaximFoit
 */
public class DuplicateModelNameException extends Exception 
{
    public DuplicateModelNameException() {super("Error, model already exist"); }
    public void printmessage() {System.out.println("Error, model already exist"); }
}
