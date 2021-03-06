package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class OddNumberElements {
public static int oddNumber(int arr[])
{
	int size=arr.length;
	Arrays.sort(arr);
	int minValue=arr[0];
	int maxValue=arr[size-1];
	int range=maxValue-minValue+1;
	int newArr[]=new int[range];
	//initialized the newArray
	for(int i=0;i<size;i++)
	{
		newArr[arr[i]-minValue]++;
	}
	//checking which appears more than two times
	for(int i=0;i<newArr.length;i++)
	{
		if(newArr[i]>2)
		{
			return minValue+i;
		}
	}
	System.out.println("count is not more than two:");
	return 0;
}
//runner method
public static void main(String[] args) {
	int arr[]= {1,2,3,4,5,6,6,6};
	int a=oddNumber(arr);
	System.out.println(a);
}
}
