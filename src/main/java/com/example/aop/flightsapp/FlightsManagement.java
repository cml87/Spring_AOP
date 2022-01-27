package com.example.aop.flightsapp;

import com.example.aop.flightsapp.domain.Flight;
import com.example.aop.flightsapp.domain.Passenger;
import com.example.aop.flightsapp.domain.Ticket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlightsManagement {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightsapp/aop.xml");
        Flight flight = (Flight) context.getBean("flight");

        flight.print();
        System.out.println(flight.getId());
        flight.setId("AA5678");

        System.out.println(flight.getCompany());

        for (Passenger passenger: flight.getPassengers()){
            System.out.println(passenger.getName());
            passenger.print();
        }

        Ticket ticket = (Ticket) context.getBean("ticket");
        ticket.setNumber("0987654321");

        // do we need to close the context explicitly??
        context.close();

    }





}
