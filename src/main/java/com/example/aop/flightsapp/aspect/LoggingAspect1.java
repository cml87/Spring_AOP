package com.example.aop.flightsapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect1 {

    private Logger logger = null;//Logger.getLogger(LoggingAspect1.class.getName());

    // logger format set up
    {
        InputStream stream = LoggingAspect1.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(LoggingAspect1.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. log a message every time `Flight.getId()` is called.
    @Before("execution(public String com.example.aop.flightsapp.domain.Flight.getId())")
    public void loggingAdviceGetIdIn(){
        logger.info("in");
    }
    @AfterReturning("execution(public String com.example.aop.flightsapp.domain.Flight.getId())")
    public void loggingAdviceGetIdOut() throws InterruptedException {
        logger.info("out");
        Thread.sleep(200);

    }

    // 2. log a message after successfully executing _any_ `print()` method.
    @AfterReturning("execution(public * *.print())")
    public void loggingAdvicePrint() throws InterruptedException {
        logger.warning("A print method has been called");
        Thread.sleep(200);
    }


    // 3. log a message for any Ticket method that is called
    @Pointcut("within(com.example.aop.flightsapp.domain.Ticket)")
    public void allTicketsMethods(){}

    @After("allTicketsMethods()")
    public void loggingAdvice(JoinPoint joinPoint) throws InterruptedException {
        logger.info("A ticket method has been called");
        logger.info("join point: "+joinPoint.toString());
        logger.info("signature: "+joinPoint.getSignature().toString());
        logger.info("signature name: "+joinPoint.getSignature().getName());
        logger.info("signature short string: "+joinPoint.getSignature().toShortString());
        logger.info("signature long string: "+joinPoint.getSignature().toLongString());
        logger.info("object after method exec: "+joinPoint.getTarget().toString());
        Thread.sleep(200);
    }
}