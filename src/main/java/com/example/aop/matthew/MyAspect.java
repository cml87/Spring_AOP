package com.example.aop.matthew;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component // aspects need to be Spring managed beans as well!
public class MyAspect {

    // the class MyService will be looked for in this package
    @Before("execution(void MyService.doSomething(..))")
    public void intercept(){
        System.out.println("Intercepted!");
    }

    // intercept all methods
    @Before("execution(void MyService.*(..))")
    public void intercept2(){
        System.out.println("Intercepted all!");
    }

    // using the JoinPoint
    @After("execution(void MyService.*(int))")
    public void intercept3(JoinPoint joinPoint){
        System.out.println("Using Join Point "+ Arrays.toString(joinPoint.getArgs()));
    }

}

