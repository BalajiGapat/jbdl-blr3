package com.geek;

public class ArrayDemo2 {
public static void main(String[] args) {
	Product p1= new Laptop();//Since Laptop IS A Product
	//Laptop l1= new Product();//wont work
	Laptop laptop= new Laptop();
	laptop.setProductId(101);
	laptop.setProductName("Lenova Laptop");
	laptop.setPrice(500000);
	laptop.setRamMemory("16 GB");
	laptop.setCpu("Intel");

	Book book=new Book();
	book.setProductId(102);
	book.setProductName("Harry Porter");
	book.setPrice(500);
	book.setGenre("Adventure");
	book.setAuthour("JK Rowlin");
	
	Product myCart[]= {laptop,book};
	for(Product p:myCart) {
		System.out.println(p.getProductId());
		System.out.println(p.getProductName());
		System.out.println(p.getPrice());
		
		//System.out.println(p.getGenre());
		System.out.println("***************");
	}
}
}
