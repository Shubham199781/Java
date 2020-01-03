package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class MissingValues {
public static void missingValues(int []arr)
{
	int size=arr.length;
	Arrays.sort(arr);
	System.out.println("The maximum value of array:"+" "+arr[size-1]);
	System.out.println("The minimum value of array:"+" "+arr[0]);
	int range =arr[size-1]-arr[0];
	int newArr[]=new int[range];
	//new array index value initialized
	for(int i=0;i<size-1;i++)
	{
		newArr[arr[i]-arr[0]]++;
	}
	System.out.println("The missing values in array:");
	for(int i=0;i<newArr.length;i++)
	{
		if(newArr[i]==0)
		{
			System.out.print(" "+(i+arr[0]));
		}
	}
}
//runner method
public static void main(String[] args) {
	int []arr= {21,22,50};
	missingValues(arr);
}
}
