package com.example.aop.introduction.programmatically;

// this is the additional interface we want the Flight object to implement
// It will be implemented already by the FlyerImpl class, which will provide implementations
// for its methods
public interface Flyer {
    void takeOff();
    void fly();
    void land();
}
