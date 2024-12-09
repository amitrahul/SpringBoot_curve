package com.codingjourney.backend.basic.springbootStartJourney;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
* -> through @Component annotation,
* -> we have defined 'AppleProduct' class as Beans.
* -> here we can also use @Service annotation which internally using component annotation.
*
* */

//@Component
//@Service
public class AppleProduct {


    void  displayPhone(){
        System.out.println("new version of iphone will be launched.");
    }

    /*
     *   -> @PostConstruct annotation will be used whenever
     *   -> 'AppleProduct' class is defined in main class (SpringbootStartJourneyApplication).
     * */
    @PostConstruct
    void callBeforeApplePhoneUsed(){
        System.out.println("creating apple phone before use");
    }

//    as soon as close the application, then only this annotation will be called.
    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("destroying the apple bean");
    }
}
