package com.geek.bean;
//This Bean obj is going to be created by the Spring container
public class GreetingBean {
	private String msg;
public GreetingBean() {
	System.out.println("Greeting bean constructor");
}
public void setMsg(String msg) {
	System.out.println("setter called");
	this.msg = msg;
}

public String sayHello(String name) {
	return "Hi "+name+" "+msg;
}
}
