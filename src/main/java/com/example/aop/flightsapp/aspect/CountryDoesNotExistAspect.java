package com.example.aop.flightsapp.aspect;

import com.example.aop.flightsapp.exception.CountryDoesNotExistException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class CountryDoesNotExistAspect {

    private Logger logger = Logger.getLogger(CountryDoesNotExistAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.example.aop.flightsapp.dao.PassengerDaoImpl.insertPassenger(..))",
                    throwing = "ex")
    public void log(CountryDoesNotExistException ex){
        logger.severe("Attempt to insert a passenger with an unexisting country code: "+ex.getCountryCode());
    }

}
