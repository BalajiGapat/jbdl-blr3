package com.geek.exceptions;

public class Ex2 {
public static void main(String[] args) {
	int x=10;
	int y=5;
	System.out.println("Welcome....");
	try {
	int arr[]= {1,2,3,4,5};
	System.out.println(arr[4]);
	int result=x/(y*2-x); // 10/0
	System.out.println("Result "+result);
	}
	catch(ArithmeticException e) {
		System.out.println("Exception occured ");
	}
	System.out.println("END .....");
}
}
