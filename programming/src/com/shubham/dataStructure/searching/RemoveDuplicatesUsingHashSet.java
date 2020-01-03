package com.shubham.dataStructure.searching;
import java.util.HashSet;
import java.util.Iterator;
public class RemoveDuplicatesUsingHashSet {
public static void removeDuplicates(int []arr)
{
	//logic is HashSet doesnot allow duplicates
	HashSet<Integer> hs=new HashSet<Integer>();
	for(int i=0;i<arr.length;i++)
	{
		hs.add(arr[i]);
	}
	Iterator<Integer> i=hs.iterator();
	while(i.hasNext())
	{
		System.out.println(i.next());
	}
}
public static void main(String[] args) {
	int arr[]= {1,1,1,1,2,2,2,2,3,3,3,3,4};
	removeDuplicates(arr);
}
}