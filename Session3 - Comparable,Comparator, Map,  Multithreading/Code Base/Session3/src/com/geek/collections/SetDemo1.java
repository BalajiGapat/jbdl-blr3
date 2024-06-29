package com.geek.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo1 {
public static void main(String[] args) {
	/*
	 * HashSet - no duplicates , cannot guranty the order of elements
	 */
	HashSet<String> set1=new HashSet<>();
	set1.add("Bangalore");
	boolean b1=set1.add("Mysore"); //returns true
	set1.add("Chennai");
	set1.add("Mumbai");
	set1.add("Pune");
	boolean b2=set1.add("Mysore"); //returns false
	System.out.println(set1);
	System.out.println(b1+"  "+b2);
	//TreeSet - no duplicates, elements are sorted in default
	TreeSet<String> set2 = new TreeSet<>();
	set2.add("Bangalore");
	set2.add("Mysore"); //returns true
	set2.add("Chennai");
	set2.add("Mumbai");
	set2.add("Pune");
	set2.add("Mysore"); //returns false
	System.out.println(set2);
	
	//LinkedHashSet - no duplicates, elements arranged in insertion order
	LinkedHashSet<String> set3 = new LinkedHashSet<>();
	set3.add("Bangalore");
	set3.add("Mysore"); //returns true
	set3.add("Chennai");
	set3.add("Mumbai");
	set3.add("Pune");
	set3.add("Mysore"); //returns false
	System.out.println(set3);
}
}
