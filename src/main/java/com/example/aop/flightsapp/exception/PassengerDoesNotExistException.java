package com.example.aop.flightsapp.exception;

public class PassengerDoesNotExistException extends RuntimeException{

    private Long passengerId;

    public PassengerDoesNotExistException(Long passengerId){
        this.passengerId = passengerId;
    }

    public Long getPassengerId(){
        return passengerId;
    }

}
