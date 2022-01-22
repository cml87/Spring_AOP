package com.example.aop.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PassengersManager {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("example1/aop.xml");

        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        System.out.println(passengerDao.getPassenger(1));


        System.out.println("hello!");
    }

}
