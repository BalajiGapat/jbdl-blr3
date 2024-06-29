package com.geek.collections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SortCollectionDemo {
public static void main(String[] args) {
	Product p1=new Product(101, "T Shirt", 800, 4.5f);
	Product p2=new Product(102, "Jeans", 2000, 4.4f);
	Product p3=new Product(103, "Mobile", 10000, 3.1f);
	Product p4=new Product(104, "Shoes", 3000, 4.7f);
	Product p5=new Product(105, "Mouse", 1000, 4.2f);
	
	ArrayList<Product> list= 
			new ArrayList<>();
	list.add(p1);
	list.add(p2);
	list.add(p3);
	list.add(p4);
	list.add(p5);
	for(Product p:list) {
		System.out.println(p); //println() internally calls p.toString()
	}
	Collections.sort(list);//natural order
	
	System.out.println("---After sorting---");
	for(Product p:list) {
		System.out.println(p); //println() internally calls p.toString()
	}
	System.out.println("----------");
	//Collections.sort(list, comparator);
	/*Comparator<Product>comp=(pr1,pr2)->{
		/*if(pr1.getRatings()>pr2.getRatings())
			return -1;
		else return 1;//
		return pr1.getRatings()>pr2.getRatings()?-1:1;
	};*/
	//Comparator<Product>comp=(pr1,pr2)->pr1.getRatings()>pr2.getRatings()?-1:1;
	//Collections.sort(list, comp);
	Collections.sort(list, (pr1,pr2)->pr1.getRatings()>pr2.getRatings()?-1:1);
	System.out.println("----sort by ratings----");
	System.out.println(list);
}
}
