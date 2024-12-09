package com.codingjourney.backend.basic.springbootStartJourney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 @SpringBootApplication annotation indicates :-
 			-> staring point of an application.
 			-> one application must have one 'SpringBootApplication' annotation.
 			-> through this we can define one starting point for the application.
 */
@SpringBootApplication
public class SpringbootStartJourneyApplication implements CommandLineRunner {
	/*
	-> here defined the class of AppleProduct.
	-> through '@Autowired' annotation we tell that the 'SpringbootStartJourneyApplication' class
	-> have a object as ap, and it is injected whenever it is required.
	-> '@Autowired' annotation is called as dependency injection.
	 */
	@Autowired
	AppleProduct ap;
	@Autowired
	AppleProduct apd;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootStartJourneyApplication.class, args);

		/*
		* 	Through new keyword, we are creating the object and call the method of that class.
		* 	but this is not the beans
		* 	AppleProduct ap = new AppleProduct();
		     ap.displayPhone();
		* */

		/*	 => spring boot creating the object without new keyword.
			-> just define the class of beans and spring boot create the object of class.
			->
		* */

	}

	@Override
	public void run(String... args) throws Exception {
		ap.displayPhone();
		apd.displayPhone();
	}
}
