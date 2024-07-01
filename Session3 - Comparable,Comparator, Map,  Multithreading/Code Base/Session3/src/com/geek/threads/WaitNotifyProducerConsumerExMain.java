package com.geek.threads;
public class WaitNotifyProducerConsumerExMain {
public static void main(String[] args) {
	Producer p=new Producer();
	Consumer c=new Consumer();
	
	p.setConsumer(c);
	c.setProducer(p);
	
	Thread t1=new Thread(p);
	Thread t2=new Thread(c);
	t1.start(); t2.start();
}
static class Producer implements Runnable{
	private Consumer consumer;
	
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public void run() {
		produce();
	}
	//void otherMethod(){ }
	synchronized void produce(){
		for (int i = 0; i < 10; i++) {
			System.out.println("********** i m producing ****** " +i);
			synchronized (consumer) {
				consumer.notify();//ACQUIRE THE LOCK & unblock
			}
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
static class Consumer implements Runnable{
	Producer producer;

	public void setProducer(Producer p) {
		this.producer = p;
	}
	public void run() {
		consume();
	}
	synchronized void consume(){
		for (int i = 0; i < 10; i++) {
			try {
				wait();//release the lock & block state
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("------ i m consuming -------"+i);
			synchronized (producer) {
				producer.notify();
			}
		}
	}
	
}
}