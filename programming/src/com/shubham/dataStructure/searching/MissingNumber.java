package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class MissingNumber {
public static void findMissing(int [] arr)
{
	Arrays.sort(arr);
	int size=arr.length;
	int range=arr[size-1]-arr[0]+1;
	int newArr[]=new int[range];
	for(int i=0;i<size;i++)
	{
		newArr[arr[i]-arr[0]]++;
	}
	System.out.println("The missing element Obtained as:");
	for(int i=0;i<range;i++)
	{
		if(newArr[i]==0)
		{
			System.out.print((i+arr[0])+" ");
		}
	}
}
//runner function
public static void main(String[] args) {
	int []arr= {34,35,36,40,50,100};
	findMissing(arr);
}
}
