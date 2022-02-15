package com.example.aop.introduction.declaratively;

import com.example.aop.introduction.declaratively.config.Config;
import com.example.aop.introduction.declaratively.domain.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class FlyerTest {

    @Autowired
    private Flight flight;

    @Test
    public void flyerTest(){
        assertTrue(flight instanceof Flight);
        System.out.println(flight.getId());
        System.out.println(flight.getCompany());
    }

}
