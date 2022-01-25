package com.example.aop.example5;

import com.example.aop.example3.LoggingAspect;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Aspect
@Service
public class ExceptionAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "exception")
    public void processException(RuntimeException exception) throws Throwable{
        System.out.println("aaaa");

        try {  Thread.sleep(100);  }
        catch (InterruptedException e) {  e.printStackTrace(); }

        logger.severe(exception.getMessage());

        try {  Thread.sleep(100);  }
        catch (InterruptedException e) {  e.printStackTrace(); }

        System.out.println("bbbb");
    }
}
