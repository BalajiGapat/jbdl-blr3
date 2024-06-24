package com.geek.exceptions;

import java.util.Scanner;

public class OwnExceptionDemo {
public static void main(String[] args) {
	System.out.println("Welcome to HDFC ATM");
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter the Amount to withdraw");
	int amt=scanner.nextInt();
	if(amt%100!=0) {
		//throw --> to throw a exception explicitly ....
		//throw new NullPointerException();
		try {
			throw new InvalidInputException();
		} 
		
		catch (InvalidInputException e) {
			System.out.println("Invalid input..");
		}
		catch(ArithmeticException e) {
			
		}
		catch(Exception e) {
			System.out.println("Some other error");
		}
	}
	else {
		System.out.println("Transaction success !!!!");
	}
}
}
class InvalidInputException extends Exception{
	
}
