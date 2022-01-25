package com.example.aop.example5;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("passengerDao")
public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengersMap = new HashMap<>();

    public Passenger getPassenger(int id) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("inside PassengerDaoImp.getPassenger()");

        if (null != passengersMap.get(id)) {
            return passengersMap.get(id);
        }

        // throw an exception here
        if (id < 1)
            throw new RuntimeException("incorrect id");

        Passenger passenger = new Passenger(id);
        passengersMap.put(id, passenger);

        System.out.println("quiting PassengerDapImpl.getPassenger()");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return passenger;
    }

}
