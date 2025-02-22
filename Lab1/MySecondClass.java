package MyFirstPackage;
import java.util.Random;
import java.util.Scanner;

public class MySecondClass
{
  int[] arr;
  public int Vvod()
  { 
    int num = 0;
    boolean flag = false;
    while(flag == false)
    { 
      Scanner sc = new Scanner(System.in);
      flag = sc.hasNextInt();
      if(flag==false)
      {
          System.out.println("Ошибка, убедитесь, что ввели число");
      }
      else 
      {
          num = sc.nextInt();
      }
    }
    return num;
  }
  public int TargetElem()
  {
    System.out.print("Введите номер элемента массива: ");
    int n = Vvod();
    int x = 0;
    if((0<n)&&(n<=arr.length))
    {
        x=arr[n-1];
    }
    else 
    {
        System.out.println("Ошибка, введите число в рамках длины массива");
    }
    return x;
  }
  public void ModElem()
  {
      System.out.print("Введите номер элемента массива: ");
      int x = Vvod();
      if((0<x)&&(x<=arr.length))
      {
          System.out.print("Введите новое значение: ");
          int z = Vvod();
          arr[x-1] = z;
      }
      else
      {
          System.out.println("Ошибка, введите число в рамках длины массива");
      }
  }
  public MySecondClass()
  {
    System.out.print("Задайте длину массива: ");
    int num = Vvod();
    arr = new int[num];
    Random rnd = new Random();
    for(int i = 0; i<arr.length; i++)
    {
        arr[i] = rnd.nextInt(11);
    }
  }
  public double MidArifm()
  {
    int n = 0;
    for(int i = 0; i<arr.length; i++)
    {
        n+=arr[i];
    }
    double x = n/arr.length;
    return x;
  }
  public void Print()
  {
    for(int i = 0; i<arr.length; i++)
    {
        System.out.print(arr[i] +" ");
    }
  }
}