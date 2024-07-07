package com.geek.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=
		new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Initialized spring container");
		
		AccountService service=(AccountService) ctx.getBean("accService");
		System.out.println(service.creditService(100000));
	}
}
