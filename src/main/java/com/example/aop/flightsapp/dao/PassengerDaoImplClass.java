package com.example.aop.flightsapp.dao;

import com.example.aop.flightsapp.domain.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImplClass implements PassengerDao{

    // map of the passengers that have already been created
    private static Map<Integer, Passenger> passengersMap = new HashMap<>();

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Override
    public Passenger getPassenger(int id) {
        return null;
    }
}
