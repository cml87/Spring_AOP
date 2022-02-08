package com.example.aop.introduction;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlyerTest {

    @Test
    public void flyerTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("introduction/aop.xml");

        Flight flight = (Flight) context.getBean("flight");

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