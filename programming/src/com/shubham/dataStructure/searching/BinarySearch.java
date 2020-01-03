package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class BinarySearch {
//logic for finding the value using binary search	
public static boolean binarySearch(int []arr,int value)
{
	int size=arr.length;
	int lower=0;
	int upper=size-1;
	while(lower<=upper)
	{
		int mid=(lower+upper)/2;
		if(mid>value)
		{
			upper=mid-1;
		}
		else
			if(mid<value)
			{
				lower=mid+1;
			}
			else
				return true;
	}
	return false;
}
//runner method
public static void main(String[] args) {
	int arr[]= {9,8,7,6,5,4,3,2,1};
	Arrays.sort(arr);
	System.out.println(binarySearch(arr,7));
	System.out.println(binarySearch(arr, 78));
}
}
