package com.geek.collections;

import java.util.ArrayList;

public class ArrayListDemo3 {
public static void main(String[] args) {
	Product p1=new Product(101, "T Shirt", 800, 4.5f);
	Product p2=new Product(102, "Jeans", 2000, 4.4f);
	Product p3=new Product(103, "Mobile", 10000, 3.1f);
	Product p4=new Product(104, "Shoes", 3000, 4.7f);
	Product p5=new Product(105, "Mouse", 1000, 4.2f);
	
	ArrayList<Product> list= new ArrayList<>();
	list.add(p1);
	list.add(p2);
	list.add(p3);
	list.add(p4);
	list.add(p5);
	for(Product p:list) {
		System.out.println(p); //println() internally calls p.toString()
	}
}
}
