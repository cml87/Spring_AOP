package com.example.aop.flightsapp;

import com.example.aop.flightsapp.dao.PassengerDao;
import com.example.aop.flightsapp.domain.Flight;
import com.example.aop.flightsapp.domain.Passenger;
import com.example.aop.flightsapp.domain.Ticket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlightsManagement {

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightsapp/aop.xml");
        Flight flight = (Flight) context.getBean("flight");

        System.out.println("Calling Flight.print() ...");
        flight.print();
        System.out.println("");

        System.out.println("Calling Flight.getId() ...");
        System.out.println("Flight id: "+flight.getId());
        flight.setId("AA5678");

        System.out.println("Flight company: "+flight.getCompany());
        System.out.println();

        System.out.println("List of passengers in the flight:");
        for (Passenger passenger: flight.getPassengers()){
            System.out.print(" " + passenger.getName() + ": ");
            System.out.println(">> Calling Person.print() ...");
            passenger.print();
            System.out.println();
        }

        Ticket ticket = (Ticket) context.getBean("ticket");
        System.out.println("Setting number of a ticket ...");
        ticket.setNumber("0987654321");

        System.out.println("---------------");

        PassengerDao passengerDaoImpl = (PassengerDao) context.getBean("passengerDaoImpl");

        passengerDaoImpl.getPassenger(1);
        System.out.println("looking for passenger with id " + 9807);
        passengerDaoImpl.getPassenger(9807);

        Passenger mike = new Passenger();
        mike.setName("Mike");
        mike.setCountry("XX");

        passengerDaoImpl.insertPassenger(mike);


        // do we need to close the context explicitly??
        context.close();

    }
}
