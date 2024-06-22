package com.geek.oops.part2;
public class PolymorpshimDemo2 {
public static void main(String[] args) {
	SMS s=new SMS();
	WhatsApp w= new WhatsApp();
	notification(s);
	notification(w);
}
static void notification(Message m) {
	m.info();
}
}
class Message{
	void info() {
		System.out.println("A message received");
	}
}
class SMS extends Message{
}
class WhatsApp extends Message{
	@Override
	void info() {
		System.out.println("A WhatsApp msg received");
	}
}