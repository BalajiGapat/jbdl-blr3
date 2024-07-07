package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//@ComponentScan + @EnableAutoConfiguration + @SpringBootConfiguration
public class Application {
	public static void main(String[] args) {
		System.out.println("Spring boot started....");
		//internally
		//initializes ApplicationContext
		SpringApplication.run(Application.class, args);
	}

}
