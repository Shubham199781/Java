package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class Partition {
public static int[] partition(int []arr)
{
	int size=arr.length;
	int left=0;
	int right=size-1;
	
	//the given array only consists of 0 and 1
	while(left<right)
	{
		if(arr[left]==1)
		{
			int temp=arr[right];
			arr[right]=arr[left];
			arr[left]=temp;
			right--;
		}
		else
			left++;
	}
	return arr;
}
//runner method
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements in an array:");
	int n=s.nextInt();
	int arr[]=new int[n];
	System.out.println("Enter the index value of an array:");
	for(int i=0;i<n;i++)
	{
		arr[i]=s.nextInt();
	}
	arr=partition(arr);
	System.out.println("The result obtained as:");
	for(int i=0;i<n;i++)
	{
		System.out.print(arr[i]+" ");
	}
	s.close();
}
}
