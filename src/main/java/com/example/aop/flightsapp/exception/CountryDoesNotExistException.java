package com.example.aop.flightsapp.exception;

public class CountryDoesNotExistException extends RuntimeException{

    private String countryCode;

    public CountryDoesNotExistException(String countryCode){
        this.countryCode = countryCode;
    }

    public String getCountryCode(){
        return countryCode;
    }

}
