package com.example.aop.flightsapp.domain;

import java.util.List;

public class Flight {

    private String id;
    private String company;
    private List<Passenger> passengers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    // prints the list of passengers
    public void print(){
        System.out.printf("Flight [%s], company [%s]:\n",id, company);
        for (Passenger passenger: passengers)
            System.out.println(" " + passenger);
    }

}
