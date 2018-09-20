package com.dawang;




 class Zurich extends Thread{
     @Override
     public String toString(){
         return "SWITZERLAND";

     }
    public void run(){
        System.out.println(getName()+" Welcome to Zurich");
    }

 }
public class Switzerland {
     public static void main(String[] args) {
         System.out.println("Welcome to Switzerland");
         Zurich zr = new Zurich();
         zr.start();
         System.out.println("Goodbye Switzerland");
     }

}
