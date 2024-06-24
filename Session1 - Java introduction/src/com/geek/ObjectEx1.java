package com.geek;
public class ObjectEx1 {
	//Entry point
	public static void main(String[] args) {
		int x=10; //goes to stack
 //Here Product obj v r going to make
	Product p1=	new Product();
	p1.setProductId(101);
	p1.setProductName("Lenova Laptop");
	p1.setPrice(50000);
	
	Product p2= new Product();
	p2.setProductId(102);
	p2.setProductName("Shoes");
	p2.setPrice(2000);
	
	displayProduct(p1);
	System.out.println("---------");
	displayProduct(p2);
	}
	static void displayProduct(Product p) {
		System.out.println("Id is "+p.getProductId());
		System.out.println("Name is "+p.getProductName());
		System.out.println("Price is "+p.getPrice());
	}
}
