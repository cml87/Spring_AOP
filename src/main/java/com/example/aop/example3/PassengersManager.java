package com.example.aop.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PassengersManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("example3/aop.xml");

        PassengerDaoImpl passengerDao = (PassengerDaoImpl) context.getBean("passengerDao");

        Passenger passenger = passengerDao.getPassenger(1);
        System.out.println(passenger);

    }

}
