package com.codingjourney.backend.basic.springbootStartJourney;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
* By using @Primary annotation, we are executing this class.
* @ConditionalOnProperty annotation, is used to create the bean on certain condition.
* name = "deploy.dev", havingValue = "production" , condition should be match from application.properties
* */
@Component
//@Primary
@ConditionalOnProperty(name = "deploy.dev", havingValue = "production")
public class ProdDB implements DB{

    public String getData(){
        return "prod data fetched.";
    }
}
