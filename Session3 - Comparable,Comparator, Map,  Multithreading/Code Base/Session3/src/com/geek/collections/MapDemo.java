package com.geek.collections;

import java.util.HashMap;

public class MapDemo {
public static void main(String[] args) {
	//Map accept key-value pair
	//keys are unique
	
	HashMap<String,String> map1= new HashMap<>();
	map1.put("BLR", "Bangalore");
	map1.put("MYS", "Mysore");
	map1.put("ND","New Delhi");
	System.out.println(map1);
	map1.put("BLR", "Bengaluru"); //it overwrites
	System.out.println(map1);
	 String city=map1.get("ND");
	 System.out.println(city);
	 System.out.println("ND".hashCode());

}
}
