package com.example.aop.introduction.declaratively.flyer;


// no need to extend DelegatingIntroductionInterceptor
public class FlyerImpl implements Flyer  {
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
