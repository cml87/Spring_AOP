package com.example.aop.introduction.declaratively.config;

import com.example.aop.introduction.declaratively.aspect.FlightAspect;
import com.example.aop.introduction.declaratively.domain.Flight;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // equivalent of     <aop:aspectj-autoproxy/> in xml configuration, finally!
@ComponentScan(basePackages = "com.example.aop.introduction.declaratively")
public class Config {

    // This bean will be discovered through component scan, so there is no need to declare it here
//    @Bean
//    public FlightAspect aspect(){
//        return new FlightAspect();
//    }


    @Bean
    public Flight flight(){
        Flight flight = new Flight();
        flight.setId("AA1234");
        flight.setCompany("ABC Flights");
        return flight;
    }

}
