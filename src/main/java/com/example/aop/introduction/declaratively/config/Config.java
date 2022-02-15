package com.example.aop.introduction.declaratively.config;

import com.example.aop.introduction.declaratively.domain.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // equivalent of     <aop:aspectj-autoproxy/> in xml configuration, finally!
public class Config {

    @Bean
    public Flight flight(){
        Flight flight = new Flight();
        flight.setId("AA1234");
        flight.setCompany("ABC Flights");
        return flight;
    }




}
