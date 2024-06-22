package com.geek.oops.part2;

public class PolymorphsimDemo1 {
public static void main(String[] args) {
	//This code is in diff class
	Person p1= new Emp();
	Person p2=new Stud();

	//This code in diff class
	Person persons[]= {p1,p2};
	for(Person p:persons) {
		System.out.println(p.info());
	}
}
}
