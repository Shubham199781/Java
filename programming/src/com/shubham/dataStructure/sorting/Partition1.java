package com.shubham.dataStructure.sorting;

import java.util.Scanner;

public class Partition1 {
public static int[] partition(int arr[])
{
int size=arr.length;
int left=0;
int right=size-1;
int index=0;
while(index<right)
{
	if(arr[index]==0)
	{
		swap(index,left,arr);
		left++;
		index++;
	}
	else
		if(arr[index]==2)
		{
			swap(index,right,arr);
			right--;
		}
		else
			index++;
}
return arr;
}
public static void swap(int first,int second,int []arr)
{
	int temp=arr[first];
	arr[first]=arr[second];
	arr[second]=temp;
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements in an array");
	int n=s.nextInt();
	System.out.println("Enter the index values of an array:");
	int arr[]=new int[n];
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=s.nextInt();
	}
	//calling the partition function
	arr=partition(arr);
	//loop for printing array
	for(int i=0;i<n;i++)
	{
		System.out.print(arr[i]+" ");
	}
	s.close();
}
}