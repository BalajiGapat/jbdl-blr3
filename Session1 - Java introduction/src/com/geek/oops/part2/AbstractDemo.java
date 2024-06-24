package com.geek.oops.part2;

public class AbstractDemo {
public static void main(String[] args) {
	//new Employee();
}
}


 abstract class Employee{
	abstract void info();
}
 
 class PerEmp extends Employee{
	 void info() {
		 System.out.println("I m PerEmp");
	 }
 }
 class ContractEmp extends Employee{

	@Override
	void info() {
		// TODO Auto-generated method stub
		
	}
	 
 }