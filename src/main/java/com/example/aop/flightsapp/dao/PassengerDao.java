package com.example.aop.flightsapp.dao;

import com.example.aop.flightsapp.domain.Passenger;

public interface PassengerDao {

    Passenger getPassenger(int id);
    void insertPassenger(Passenger passenger);


}
