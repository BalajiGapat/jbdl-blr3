package com.geek.bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		//new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Initialized spring container");
		//default name is camel case of class name
		AccountService service=(AccountService) ctx.getBean("service");
		System.out.println(service.creditService(100000));
	}
}
