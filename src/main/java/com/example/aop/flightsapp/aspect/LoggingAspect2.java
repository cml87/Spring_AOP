package com.example.aop.flightsapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect2 {

    private Logger logger = null;//Logger.getLogger(LoggingAspect1.class.getName());

    // logger format set up
    {
        InputStream stream = LoggingAspect2.class.getClassLoader().getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
            logger = Logger.getLogger(LoggingAspect2.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Around("allSetters()")
    public Object log (ProceedingJoinPoint thisJoinPoint) throws Throwable{

        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();
        logger.severe("> Call method " + methodName + " with args " + methodArgs[0]);
        Object result = thisJoinPoint.proceed();
        logger.severe("> Method " + methodName + " returns " + result);
        return result;
    }

    @Pointcut("execution(* com.example.aop.flightsapp.domain.*.*set*(..))")
    public void allSetters(){}

}