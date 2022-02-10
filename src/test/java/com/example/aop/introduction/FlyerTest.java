package com.example.aop.introduction;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlyerTest {

    @Test
    public void flyerTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("introduction/aop.xml");

        Flight flight = (Flight) context.getBean("flight");

        FlyerAdvisor flyerAdvisor = new FlyerAdvisor();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(flight);
        proxyFactory.addAdvisor(flyerAdvisor);
        proxyFactory.setOptimize(true); // to use CGLIB  strategy. The proxy class will be a subclass of Flight


        Flight proxyFlight = (Flight) proxyFactory.getProxy();

        // Show that the proxy class is a subclass of Flight
        assertTrue(proxyFlight instanceof Flight);
        System.out.println(proxyFlight.getId());  // calling a method of the superclass
        System.out.println(proxyFlight.getCompany()); // calling a method of the superclass


        // Show that the proxy class implements the Flyer interface
        assertTrue(proxyFlight instanceof Flyer);
        ((Flyer) proxyFlight).takeOff();
        ((Flyer) proxyFlight).fly();
        ((Flyer) proxyFlight).land();

        // The proxy class belongs to a class that extends Flight
       // assertTrue(proxyFlight instanceof FlyerImpl);

        // The effective type of the proxy class will be something like: com.example.aop.introduction.Flight$$EnhancerBySpringCGLIB$$a33440e5
        // ie. a CGLIB class
        System.out.println("The effective class of proxyFlight object is: " + proxyFlight.getClass().getName());


//        FlyerAdvisor flyerAdvisor = new FlyerAdvisor();
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(flight);
//        proxyFactory.addAdvisor(flyerAdvisor);
//        proxyFactory.setOptimize(true);
//
//        Flight proxyFlight = (Flight)proxyFactory.getProxy();
//
//        assertTrue(proxyFlight instanceof Flight);
//        System.out.println(proxyFlight.getId());
//        System.out.println(proxyFlight.getCompany());
//
//        assertTrue(proxyFlight instanceof Flyer);
//        ((Flyer)proxyFlight).takeOff();
//        ((Flyer)proxyFlight).fly();
//        ((Flyer)proxyFlight).land();
//
//        System.out.println(proxyFlight.getClass().getName());

        context.close();
    }
}