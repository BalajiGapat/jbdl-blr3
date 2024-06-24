package com.geek.oops.part2;
public class InterfaceDemo {
public static void main(String[] args) {
	driving( new Creta());
	System.out.println("-----");
	driving( new Brezza());
}
static void driving (Drive d) {
	//no need to bother abt which car he drives
	d.gear();
}
}
interface Drive{
	void gear();//public abstract void gear();
}
class Creta implements Drive{
	public void gear() {
		System.out.println("Creta car gear initiated");
	}
}
class Brezza implements Drive{
	public void gear() {
		System.out.println("Brezza car gear initiated");

	}
	
}