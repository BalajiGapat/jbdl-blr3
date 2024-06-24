package com.geek;
public class LambdaEx2 {
public static void main(String[] args) {
	//Function without name
	Greeting g= (String name)-> {
		return "Hello "+name+" Happy Birthday !!!!";
	};
	System.out.println(g.wish("Arun"));
	
	Greeting g2=n-> {int x=10; return  " Hello "+n+" Happy Anniversary";};
}
}
@FunctionalInterface //it wont allow to make more than one abstract methods
interface Greeting{
	String wish(String name);
	//void f1();
}
interface Greeting2 extends Greeting{
	String w(String s);
}
/*
class GreetingImpl implements Greeting{
	public String wish(String name) {
		return "Hello "+name+" Happy Birthday !!!!";
	}
}*/