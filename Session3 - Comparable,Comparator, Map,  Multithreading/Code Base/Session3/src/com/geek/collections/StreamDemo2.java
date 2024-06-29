package com.geek.collections;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo2 {
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
	
	List<Product> filteredList=
	list.stream().
	filter(p->p.getPrice()<10000).
	sorted((pr1,pr2)->pr1.getRatings()>pr2.getRatings()?-1:1).toList();
	
	System.out.println(filteredList);
	Consumer<Product>c=(p)->System.out.println(p.getProdName());
     filteredList.forEach(c);
     System.out.println("--------");
     filteredList.forEach(p->System.out.println(p.getProdName()));
}
}
