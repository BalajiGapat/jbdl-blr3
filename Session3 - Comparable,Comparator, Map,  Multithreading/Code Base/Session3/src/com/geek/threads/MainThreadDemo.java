package com.geek.threads;

public class MainThreadDemo {
	public static void main(String[] args) throws InterruptedException {
	System.out.println("Hello");
//	System.out.println(5/0);
	
	//returns current running thread reference
	Thread t1=  Thread.currentThread();
	System.out.println(t1.getName()+" is running");
	System.out.println("priority : "+t1.getPriority());
	//min priority is 1, max is 10, normal is 5
	t1.setPriority(1);
	System.out.println(t1.getPriority());
	
	for(int i=1;i<=10;i++) {
		System.out.println(i);
		Thread.sleep(1000);//1000 milli sec-  1 sec
	}
	}
}
