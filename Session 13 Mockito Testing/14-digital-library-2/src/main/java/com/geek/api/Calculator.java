package com.geek.api;

public class Calculator {
	public Calculator() {
		System.out.println("constructor .....");
	}
public int add(int x,int y) {
	//blogic
	return x+y;
}

public int diff(int x,int y) {
	//blogic
	return x-y;
}

public int div(int x,int y) {
	//if(y==0)
		//throw new RuntimeException("Cant divide by Zero");
	try {
		return x/y;
	} catch (Exception e) {
		//Re throwing exception
		throw new RuntimeException("Cant divide by Zero");
	}
}
}
