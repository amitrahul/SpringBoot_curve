package com.codingjourney.backend.basic.springbootStartJourney;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


// this is another way through that we can define the beans
@Configuration
public class AppConfig {
    /*
     *  -> through @Bean annotation we are creating the beans.
     *  -> through @Scope("prototype"), we are creating multiple object of beans.which leads to
     *      calls the @PostConstruct each time of creation.
     *
     *  ->  through @Scope("singleton"), we are creating one object of beans.which leads to
     *      calls the @PostConstruct one time of creation.
    */
    @Bean
//    @Scope("prototype")
    @Scope("singleton")
    AppleProduct launchingMessage(){
        //  here developer is responsible for creating the object not the spring framework.
        // here we are creating the object through new keyword.
        return new AppleProduct();
    }

}
