package com.example.aop.introduction.declaratively.aspect;

import com.example.aop.introduction.declaratively.flyer.Flyer;
import com.example.aop.introduction.declaratively.flyer.FlyerImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class FlightAspect {

    @DeclareParents(value = "com.example.aop.introduction.declaratively.domain.Flight", defaultImpl = FlyerImpl.class)
    private Flyer flight;

    // This means that the Flight field will have as new parent the Flyer interface, with default implementation
    // (methods of the interface) FlyerImpl

}

