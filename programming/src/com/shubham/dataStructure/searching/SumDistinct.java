package com.shubham.dataStructure.searching;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SumDistinct {
//method used HashMap for calculating sum	
public static int sumUsingHashMap(int arr[],int size)
{
	HashMap<Integer, Integer> hm=new HashMap<>();
	int sum=0;
	for(int i=0;i<size;i++)
	{
		if(hm.containsKey(arr[i])==true)
		{
			hm.put(arr[i], hm.get(arr[i])+1);
		}
		else
			hm.put(arr[i], 1);
	}
	for(int i=0;i<size;i++)
	{
		if(hm.containsKey(arr[i])&&hm.get(arr[i])==1)
		{
			hm.put(arr[i], 1);
		}
	}
	for(int i=0;i<size;i++)
	{
		if(hm.containsKey(arr[i])&&hm.get(arr[i])==1)
		{
			sum=sum+arr[i];
		}
	}
	return sum;
}
//method using Hash Set for calculating sum
public static int sumUsingHashSet(int arr[],int size)
{
	int sum=0;
	Arrays.sort(arr);
	int lowerRange=arr[0];
	int upperRange=arr[size-1];
	HashSet<Integer> hs=new HashSet<Integer>();
	//this logic will remove the repetition in array 
	for(int i=0;i<size;i++)
	{
		hs.add(arr[i]);
	}
	for(int i=lowerRange;i<upperRange+1;i++)
	{
		if(hs.contains(i)==true)
		{
			sum=sum+i;
		}
	}
	return sum;
}
//normal method for adding
public static int sum(int arr[],int size)
{
	Arrays.sort(arr);
	
	int sum=0;
	for(int i=0;i<size-1;i++)
	{
		if(arr[i]!=arr[i+1])
			sum=sum+arr[i];
	}
	sum=sum+arr[size-1];
	return sum;
}
//runner function
public static void main(String[] args) {
	int arr[]= {1,1,1,2,2,2,3,4,5};
	int size=arr.length;
	System.out.println(sumUsingHashMap(arr, size));
	System.out.println(sumUsingHashSet(arr, size));
	System.out.println(sum(arr, size));
}
}
