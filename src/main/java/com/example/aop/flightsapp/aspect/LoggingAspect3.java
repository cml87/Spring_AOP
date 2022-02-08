package com.example.aop.flightsapp.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggingAspect3 {

    private Logger logger = null;//Logger.getLogger(LoggingAspect1.class.getName());

    // logger format set up
    {
        InputStream stream = LoggingAspect3.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(LoggingAspect3.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. log in/out for any public method  in PassengerDaoImpl
    @Before("allPassengerDaoImplPublicMethods()")
    public void logIn() {
        logger.info("in");
    }

    @AfterReturning("allPassengerDaoImplPublicMethods()")
    public void logOut() throws InterruptedException {
        logger.info("out");
        Thread.sleep(200);
    }

    @Pointcut("execution(public * com.example.aop.flightsapp.dao.PassengerDaoImpl.*(..))")
    public void allPassengerDaoImplPublicMethods() {
    }

}