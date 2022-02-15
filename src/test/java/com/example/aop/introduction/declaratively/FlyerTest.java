package com.example.aop.introduction.declaratively;

import com.example.aop.introduction.declaratively.domain.Flight;

import com.example.aop.introduction.declaratively.flyer.Flyer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = com.example.aop.introduction.declaratively.config.Config.class)
public class FlyerTest {

    @Autowired
    private Flight flight;

    @Test
    public void flyerTest(){
        assertTrue(flight instanceof Flight);
        System.out.println(flight.getId());
        System.out.println(flight.getCompany());

        assertTrue(flight instanceof Flight);

        assertTrue(flight instanceof Flyer);
        System.out.println("The effective class of flight object is: " + flight.getClass().getName());

        ((Flyer) flight).takeOff();
        ((Flyer) flight).fly();
        ((Flyer) flight).land();

    }
}
