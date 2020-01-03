package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class BucketSort {
public static void bucketSort(int arr[],int lower,int upper)
{
	int size=upper-lower;
	int tempArray[]=new int[size];
	int arr1[]=new int[size];
	for(int i=0;i<arr.length;i++)
	{
		tempArray[arr[i]-lower]++;
	}
	int count=0;
	for(int i=0;i<size;i++)
	{
		for(;tempArray[i]>0;(tempArray[i])--)
		{
			arr1[count++]=lower+i;
			
		}
	}
	//logic for printing the values
	for(int i=0;i<size;i++)
	{
		if(arr1[i]!=0)
		System.out.println(arr1[i]);
	}
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter number of elements in the array:");
	int n=s.nextInt();
	int arr[]=new int[n];
	System.out.println("Enter the values of index in array:");
	for(int i=0;i<n;i++)
	{
		arr[i]=s.nextInt();
	}
	bucketSort(arr,20,30);
	s.close();
}
}