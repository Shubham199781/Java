package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class PrintDuplicates {
//logic for printing duplicates
public static void print(int []arr)
{
	Arrays.sort(arr);
	int size=arr.length-1;
	int lower=arr[0];
	int upper=arr[size];
	int temp[]=new int[upper-lower];
	for(int i=0;i<temp.length;i++)
	{
		temp[arr[i]-lower]++;
	}
	
	//logic for printing repeated elements
	for(int j=0;j<temp.length;j++)
	{
		if(temp[j]>1)
		{
			System.out.println((lower+j)+" ");
			temp[j]=0;
		}
	}
}
//runner method
public static void main(String[] args) {
int []arr= {1,2,2,3,4,5,6,7,8,8,8};	
print(arr);
}
}
