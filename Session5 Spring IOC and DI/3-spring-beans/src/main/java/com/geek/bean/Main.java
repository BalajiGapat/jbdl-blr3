package com.geek.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx=
		new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Initialized spring container");
	GreetingBean bean=(GreetingBean) ctx.getBean("greet");
	System.out.println(bean.sayHello("Albin"));
	
	GreetingBean bean2=(GreetingBean) ctx.getBean("greet");
	System.out.println(bean2.sayHello("Balaji"));
	System.out.println(bean==bean2);
	}
}
