package com.example.aop.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PassengersManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("example3/aop.xml");

        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");

        System.out.println(passengerDao.getPassenger(1));

    }

}
