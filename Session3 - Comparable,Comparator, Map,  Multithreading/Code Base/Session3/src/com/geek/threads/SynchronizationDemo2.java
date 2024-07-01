package com.geek.threads;
public class SynchronizationDemo2 {
public static void main(String[] args) throws InterruptedException {
	Banking bank=new Banking();
	Thread t1= new Thread(bank);
	Thread t2= new Thread(bank);
	t1.setName("GPAY");
	t2.setName("ATM");
	t1.start();
	t2.start();
	t1.join();
	t2.join();
	System.out.println("Bank balance : "+bank.balanceAmt);
}
}
class Banking implements Runnable{
	float balanceAmt=5000;
	public void run() {
		//synchronized (this) {
			debit(3000);
		//}
	}
	private  void debit(float debitAmt) {
		Thread t=Thread.currentThread();
		if(balanceAmt >= debitAmt && balanceAmt>0 ) {
			System.out.println(t.getName()+" trying to debit");
			try {
				System.out.println("sleeping....");
				Thread.sleep(5000);
				//wait() --> releases the lock
				//wait(5000);//this methid is in Object class
			} catch (InterruptedException e) {
			}
			balanceAmt=balanceAmt-debitAmt;
			System.out.println(t.getName()+" successfully debited");
		}
		else
			System.out.println(t.getName()+" insufficient funds");
	}
	
}