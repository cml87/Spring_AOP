package com.example.aop.introduction.programmatically;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

// The additional methods we want to add to the proxied class will be delegated to
// this class
public class FlyerImpl extends DelegatingIntroductionInterceptor implements Flyer{
    @Override
    public void takeOff() {
        System.out.println("Taking off");
    }

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }
}
