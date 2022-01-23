package com.example.aop.example1;

public class ClassA {

    public void printHello(){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello !");
    }

}
