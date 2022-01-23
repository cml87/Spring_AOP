package com.example.aop.example2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* *.*Passenger(..))")
    public void before(){
        logger.info("Entering method");
    }

    @After("execution(* *.*Passenger(..))")
    public void after(){
        logger.info("Exiting method");
    }

}
