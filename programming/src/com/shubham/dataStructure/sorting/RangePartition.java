package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class RangePartition {
//logic for range partition
public static int[] rangePartition(int arr[],int lower,int upper)
{
	int size=arr.length;
	int left=0;
	int right=size-1;
	int index=0;
	while(index<=right)
	{
		if(arr[index]<lower)
		{
			swap(index,left,arr);
			left++;
			index++;
		}
		else
			if(arr[index]>upper)
			{
				swap(index,upper,arr);
				upper--;
			}
			else
			   index++;
	}
	return arr;
}
//function for swapping
public static void swap(int first,int second,int[] arr)
{
	int temp=arr[first];
	arr[first]=arr[second];
	arr[second]=temp;
}
//Runner function
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements:");
	int n=s.nextInt();
	int arr[]=new int[n];
	System.out.println("Enter the index values of array:");
	for(int i=0;i<n;i++)
	{
		arr[i]=s.nextInt();
	}
	arr=rangePartition(arr, 9, 12);
	//loop for printing array
	for(int i=0;i<n;i++)
	{
		System.out.print(arr[i]+" ");
	}
	s.close();
}
}
