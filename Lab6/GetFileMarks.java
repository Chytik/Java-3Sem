/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab51;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ArrayBlockingQueue;
/**
 *
 * @author MaximFoit
 */
public class GetFileMarks implements Runnable
{
    private String fileName;   
    private ArrayBlockingQueue abq;
    public GetFileMarks(String fileName, ArrayBlockingQueue abq)
    {
        this.fileName = fileName;
        this.abq = abq;
    }
    public void run()
    {
        try 
        {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String brand = (String) br.readLine();
            Vehicle v = new Bike(brand,0);
            abq.add(v); //если put то мы ждем все потоки пока дообработают файлы. При эдд вылетит в эксепшон из за размера в ArrayBlockingQueue.
        } catch (Exception ex) {}
    }
}
