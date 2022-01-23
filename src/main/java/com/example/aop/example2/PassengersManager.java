package com.example.aop.example2;

import com.example.aop.example2.PassengerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PassengersManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("example2/aop.xml");

        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");

        System.out.println(passengerDao.getPassenger(1));

    }

}
