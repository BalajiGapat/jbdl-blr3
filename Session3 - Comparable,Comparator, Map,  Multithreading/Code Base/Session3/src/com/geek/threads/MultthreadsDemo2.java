package com.geek.threads;

public class MultthreadsDemo2 {
public static void main(String[] args) throws InterruptedException {
	Task2 task= new Task2();
	Thread t1= new Thread(task);
	Thread t2= new Thread(task);
	Thread t3= new Thread(task);
	t1.start();
	t2.start();
	t3.start();
	//i want main thread shud complete last 
	t1.join();
	t2.join();
	t3.join();
	System.out.println("Counter : "+task.counter);
	System.out.println("Main Ends");
}
}
class Task2 implements Runnable{
	 int counter=0;
	public void run() {
		for(int i=1;i<=10000;i++) {
			  synchronized(this) {
				 counter++; //read/update/write
			  }
		}
		System.out.println("Child ends");
	}
	
}