package com.geek.exceptions;

public class Ex1 {
public static void main(String[] args) {
	int x=10;
	int y=5;
	System.out.println("Welcome....");
	//the pgm stops here ....
	int result=x/(y*2-x); // 10/0
	
	System.out.println("Result "+result);
	System.out.println("END .....");
}
}
