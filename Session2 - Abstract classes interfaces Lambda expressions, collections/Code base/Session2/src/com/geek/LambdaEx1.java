package com.geek;
public class LambdaEx1 {
public static void main(String[] args) {
	Calculator c=(float x, float y)-> {
		return x+y;
	};
	float f=c.eval(10, 9);
	System.out.println(f);
	Calculator c1=(x,y)->{return x+y;};
	Calculator c2=(x,y)-> x+y; //Since it has only one stmt no {} and return
 myCal(c2, 9, 8);
 myCal(c2, f, f);
 myCal( (x,y)->x*y  , 7, 8);
}
static void myCal(Calculator c,float a,float b) {
	float r=c.eval(a, b);
	System.out.println(r);
}
}
interface Calculator{
	float eval(float x,float y);
}
/*
class CalcImpl implements Calculator{
	public float eval(float x, float y) {
		return x+y;
	}
}
*/