package com.shubham.dataStructure.searching;

import java.util.Arrays;
import java.util.HashSet;
public class FindPairUsingHashSet {
public static void findPair(int []arr,int value)
{
	HashSet<Integer> hs=new HashSet<>();
	int size=arr.length;
	
	//initializing the Hash Set
	for(int i=0;i<size;i++)
	{
		if(hs.contains(value-arr[i]))
		  System.out.println(arr[i]+"  "+(value-arr[i]));
		else
			hs.add(arr[i]);
	}
	
}
//runner method
public static void main(String[] args) {
	int arr[]= {-2,-1,0,3,2,7,8,1};
	int value=0;
	findPair(arr, value);
}
}
