/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.genious7;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author MaximFoit
 */
public class Genious7 
{
    static JFrame frame;
    static JFrame frame1;
    static Matr m;
    public static void main(String[] args) throws Exception
    {
       int r =0;
       int c =0;
       FramePrint();
       FramePrint2();
       JLabel label1 = new JLabel("",SwingConstants.CENTER);
       frame1.add(label1);
       JPanel JPanel = new JPanel();
       frame.add(JPanel);
       JPanel.add(new Label("Rows:"));
       JTextField j1 = new JTextField(20);
       JPanel.add(j1);
       JPanel.add(new Label("Colons:"));
       JTextField j2 = new JTextField(20);
       JPanel.add(j2);     
       JButton but1 = new JButton("Create Matr");
       JPanel.add(but1);
       but1.addActionListener(new ActionListener() 
       {  
           public void actionPerformed(ActionEvent e)
           {
              String s = j1.getText();
              String s2 = j2.getText();
              try
              {
                    double a = Double.parseDouble(s);
                    double b = Double.parseDouble(s2);
                    if(a == 0 | b == 0)
                    {
                        frame1.setVisible(true);
                        frame1.setSize(370,70);
                        label1.setText("You entered the number incorrectly: You entered 0");
                        if(a == 0)j1.setText("");
                        else j2.setText("");             
                    }
                    else if (a%1 != 0 | b%1 != 0) 
                    {
                        frame1.setVisible(true);
                        frame1.setSize(385,70);
                        label1.setText("You entered the number incorrectly: You did not enter an integer");
                        if(a%1 != 0)j1.setText("");
                        else j2.setText("");
                    }
                    else if(a < 0 | b < 0)
                    {
                        frame1.setVisible(true);
                        frame1.setSize(370,70);
                        label1.setText("You entered the number incorrectly: the number is less than 0");
                        if(a < 0)j1.setText("");
                        else j2.setText("");
                    }
                    else if(a >= 9000 | b >= 9000)
                    {
                        frame1.setVisible(true);
                        label1.setText("The number is too high");
                        if(a >= 9000)j1.setText("");
                        else j2.setText("");
                    }
                    else if(a > 0 && b > 0)
                    {
                        int a1 = (int) a;
                        int b1 = (int) b;
                        m = new Matr(a1,b1);
                        frame1.setVisible(true);
                        label1.setText("The matrix has been created");
                    }
              }
              catch (NumberFormatException nfe)
              {
                  frame1.setVisible(true);
                  frame1.setSize(385,70);
                  if("".equals(s) | "".equals(s2))label1.setText("You entered the number incorrectly: Nothing was entered");
                  else label1.setText("You entered the number incorrectly:You have entered the letters");                   
                  j1.setText("");
                  j2.setText("");
              }
           }   
       });
       JButton but2 = new JButton("Print Matrix");
       JPanel.add(but2);
       but2.addActionListener(new ActionListener() 
       {
           public void actionPerformed(ActionEvent e)
           {
               if(m!=null)MatrixPrint(m);
           }
       });
       Label label2 = new Label("Sum:      ");
       JButton but3 = new JButton("Sum");
       JPanel.add(but3);
       JPanel.add(label2);
       JPanel.revalidate();
       but3.addActionListener(new ActionListener() 
       {
           public void actionPerformed(ActionEvent e)
           {
               try (Socket out = new Socket("localhost",8081)) 
               {                    
                    ObjectOutputStream one = new ObjectOutputStream(out.getOutputStream());
                    one.writeObject((Object)m);
                    Scanner in = new Scanner(out.getInputStream());
                    double sum = Double.parseDouble(in.nextLine());
                    frame.setVisible(true);
                    label2.setText("Sum: " + sum     + "       ");
                    in.close();
                    sum = 0;
               } 
               catch (Exception ex) 
               {     
                   frame1.setVisible(true);
                   label1.setText(ex.getMessage());
               }
           }
       }); 
    }
    public static void FramePrint()
    {        
        frame = new JFrame("Laba7");
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    public static void FramePrint2()
    {        
        frame1 = new JFrame("Attention");
        frame1.setSize(260,70);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
    }
    public static void MatrixPrint(Matr m)
    {   
        double[][] d = m.getMatrixDouble();
        Object[][] data = new Object[d.length][d[0].length+1];
        for (int i = 0; i < d.length; i++) 
        {
            data[i][0] = "Row " + (i + 1);
            for (int j = 0; j < d[i].length; j++) data[i][j+1] = d[i][j];
        }
        String[] c = new String[d[0].length+1];
        c[0] = "Rows";
        for (int i = 0; i < d[0].length; i++) c[i+1] = "Colums " + (i + 1);
        DefaultTableModel model = new DefaultTableModel(data, c);
        JTable table = new JTable(model);
        table.setRowHeight(30); 
        JFrame frame2 = new JFrame("Matr");
        frame2 = new JFrame("Matr");
        frame2.setSize(260,70);
        frame2.setLocationRelativeTo(null);
        frame2.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED)); 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setDefaultEditor(Object.class, null);
        frame2.setVisible(true);
    }
}
