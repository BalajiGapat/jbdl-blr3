package com.geek;

public class ArrayDemo1 {
public static void main(String[] args) {
	//Array -->collection of similar type of data
	 //index starts from 0
	int nums[]=  new int[5];
	nums[0]=10;
	nums[1]=20;
	
	for(int x:nums) { //for each loop
		System.out.println(x);
	}
	
	int arr[]= {1,2,3,4,5};
	String cities[]= {"Bangalore","Mysore","Delhi","Mumbai"};
	for(String c:cities) {
		System.out.println(c);
	}
}
}
