package com.example.aop.introduction.declaratively.config;

import com.example.aop.introduction.declaratively.aspect.FlightAspect;
import com.example.aop.introduction.declaratively.domain.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // equivalent of     <aop:aspectj-autoproxy/> in xml configuration, finally!
@ComponentScan
public class Config {

    @Bean
    public FlightAspect aspect(){
        return new FlightAspect();
    }


    @Bean
    public Flight flight(){
        Flight flight = new Flight();
        flight.setId("AA1234");
        flight.setCompany("ABC Flights");
        return flight;
    }

}
