package com.example.aop.example1;

import java.util.logging.Logger;

// This is the aspect class
//public class LoggingAspect {
public class Bluesky {

    private Logger logger = Logger.getLogger(Bluesky.class.getName());

    //public void before() {
    public void pipi() {
        System.out.println("---- Entering method");
        //logger.info("Entering method");
    }

    //public void after() {
    public void popo(){
        System.out.println("---- Exiting method");
        //logger.info("Exiting method");
    }

}
