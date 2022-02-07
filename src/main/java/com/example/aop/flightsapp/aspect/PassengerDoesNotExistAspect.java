package com.example.aop.flightsapp.aspect;

import com.example.aop.flightsapp.exception.CountryDoesNotExistException;
import com.example.aop.flightsapp.exception.PassengerDoesNotExistException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class PassengerDoesNotExistAspect {

    private Logger logger = Logger.getLogger(PassengerDoesNotExistAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* com.example.aop.flightsapp.dao.PassengerDaoImpl.getPassenger(..))",
                    throwing = "ex")
    public void log(PassengerDoesNotExistException ex){
        logger.severe("There is no passenger with id: "+ex.getPassengerId());
    }

}
