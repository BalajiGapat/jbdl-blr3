package com.geek;
public class InheritanceEx1 {
	public static void main(String[] args) {
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
//to read i can call getter methods .....
	}
}
