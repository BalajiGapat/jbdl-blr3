package com.geek.collections;

import java.util.ArrayList;

public class ArrayListGenericDemo {
public static void main(String[] args) {
	//Dynamic Array
	ArrayList<String> list1= new ArrayList<>();
	list1.add("Bangalore");
	list1.add("Chennai");
	//list1.add(100);
	String s=list1.get(0);//no need of casting

  ArrayList<Integer> list2= new ArrayList<>();
  list2.add(100);
  list2.add(500);
  list2.set(0, 800);//updating the index
  System.out.println(list2);

}
}
