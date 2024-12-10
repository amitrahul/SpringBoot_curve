package com.codingjourney.backend.basic.springbootStartJourney;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "deploy.dev", havingValue = "development" )
public class DevDB implements DB{

    public String getData(){
        return "dev data fetched.";
    }
}
