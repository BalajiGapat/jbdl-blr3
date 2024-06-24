package com.geek.collections;
import java.util.ArrayList;
public class ArrayListDemoNonGeneric {
public static void main(String[] args) {
	ArrayList list1= new ArrayList();
	list1.add(10);
	list1.add("Bangalore");
	System.out.println(list1);
	
	int x= (int)list1.get(0); //required typecasting
	String s=(String)list1.get(0);
	System.out.println(x);
	System.out.println(s);
}
}
