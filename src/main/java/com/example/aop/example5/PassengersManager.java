package com.example.aop.example5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PassengersManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("example5/aop.xml");

        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");

        Passenger passenger = passengerDao.getPassenger(0);
        System.out.println(passenger);

    }

}
