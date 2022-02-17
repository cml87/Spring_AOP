package com.example.aop.matthew;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void doSomething(){
        System.out.println("doing business method");
    }

    public void doSomeOtherThing(int number){
        System.out.println("doing a different business method. Number: "+number);
    }

}
