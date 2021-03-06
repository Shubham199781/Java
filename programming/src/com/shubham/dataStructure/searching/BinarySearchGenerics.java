package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class BinarySearchGenerics<T extends Comparable<T>> {
//logic for finding desired value by binary search method
public  boolean binarySearch(T arr[],T value)
{
	int size=arr.length;
	int lower=0;
	int upper=size-1;
	while(lower<=upper)
	{
		int mid=(lower+upper)/2;
		if(arr[mid].compareTo(value)==0)
			return true;
		else
			if(arr[mid].compareTo(value)>0)
			{
				upper=mid-1;
			}
			else
				lower=mid+1;
	}
	return false;
}
//runner method
public static void main(String[] args) {
	String arr[]= {"a","e","G","Z"};
	Arrays.sort(arr);
	BinarySearchGenerics<String> b=new BinarySearchGenerics<>();
	System.out.println(b.binarySearch(arr, "G"));
	System.out.println(b.binarySearch(arr, "gullyboy"));
}
}
