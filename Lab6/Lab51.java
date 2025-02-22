/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab51;

import java.io.*;
import java.lang.reflect.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MaximFoit
 */
public class Lab51 
{
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchModelNameException, DuplicateModelNameException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException 
    {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        //показывать по заданиям остальное коментить
        Vehicle car = new Automobile("Lada", 7777);//ставить обязательно большое число элементов(>5000) чтобы было заметно, что при координально различных приоритетах не будет горантированных дополнительных реализаций.
        PrintPrice prp = new PrintPrice(car);// при отсутствии синхронизации происходит разрыв
        Thread pr = new Thread(prp);
        PrintName prn = new PrintName(car);
        Thread pn = new Thread(prn);
        pn.setPriority(Thread.MAX_PRIORITY); //это очень важно потому что задает приоритеты выполнения потоков 
        pr.setPriority(Thread.MIN_PRIORITY); //не  вписываем цифры так как могут измениться значения максимального и минимального
        pn.start();        
        pr.start();//их нужно запускать вместе для экономии вычислительных мощностей
        
        VehicleSynchronizer trs = new VehicleSynchronizer(car);
        PrintNameRun tpnr = new PrintNameRun(trs);
        Thread pnr = new Thread(tpnr); //передаем так как от раннабл 
        //pnr.start();
        PrintPriceRun ppr = new PrintPriceRun(trs);
        Thread tppr = new Thread(ppr);
        //tppr.start();      
        
        ReentrantLock locker = new ReentrantLock();
        PrintNameLocker pnl = new PrintNameLocker(car,locker);
        Thread tpnl = new Thread(pnl);
        PrintPriceLocker ppl = new PrintPriceLocker(car,locker);
        Thread tppl = new Thread(ppl);
        //tppl.start();
        //tpnl.start();       
        
        /*Vehicle motoBike = new Bike("Suzuki", 0);
        Vehicle moped = new Moped("Tarantina", 0);
        Vehicle quadBike = new Kvadr("Yaguar", 0);
        ExecutorService es = Executors.newFixedThreadPool(2);//Обязательно писать минимум в 2 раза меньше число. Рандомно выберает с кем будет работать первоначально.
        PrintMark pm1 = new PrintMark(car);
        PrintMark pm2 = new PrintMark(motoBike);
        PrintMark pm3 = new PrintMark(moped);
        PrintMark pm4 = new PrintMark(quadBike);
        es.submit(pm1);//помещает в пул
        es.submit(pm2);
        es.submit(pm3);
        es.submit(pm4);
        es.shutdown(); //ждет пока все потоки доработают и закроет пул*/
        
        /*ArrayBlockingQueue abq = new ArrayBlockingQueue(5); //ставим меньше минимум в двое чем кол-во файлов.
        String [] files = {"Granta.txt","Kalina.txt","Kopeika.txt","Priora.txt","Vesta.txt" };
        for (int i = 0; i < files.length; i++)
        {
            GetFileMarks gfm = new GetFileMarks(files[i],abq);
            Thread th = new Thread(gfm);
            th.start();
        }
        for (int i=0; i < files.length; i++)System.out.println(abq.take().toString());*/
    }
}
