package com.example.aop.flightsapp.domain;

public class Ticket {

    private String number;

    // owner of the ticket
    private Passenger passenger;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // returns the country of the passenger owner of the ticket
    public String emittingCountry(){
        return passenger.getCountry();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "number='" + number + '\'' +
                '}';
    }
}
