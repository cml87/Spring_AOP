package com.example.aop.flightsapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect1 {

    private Logger logger = null;//Logger.getLogger(LoggingAspect1.class.getName());

    {
        InputStream stream = LoggingAspect1.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(LoggingAspect1.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Before("execution(public String com.example.aop.flightsapp.domain.Flight.getId())")
    public void loggingAdviceGetId(){
        logger.info("Flight.getId() will be called");
    }

}
