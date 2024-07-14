package com.geek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.geek" )
public class Application {
	public static void main(String[] args) {
		//initialize ApplicationContext
		ApplicationContext ctx=
		SpringApplication.run(Application.class, args);
		/*
		String beans[]=ctx.getBeanDefinitionNames();
		for(String b:beans) {
			System.out.println(b);
		}*/
	}
}
