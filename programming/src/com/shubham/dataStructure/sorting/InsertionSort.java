package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class InsertionSort {
public static int[] sort(int arr[])
{
	//outer loop is for number of times 
	for(int i=0;i<arr.length-1;i++)
	{
		//inner loop is for sorting the array elements
		for(int j=i+1;j>0;j--)
		{
			if(arr[j-1]>arr[j])
			{
				int temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
			}
		}
	}
	
	return arr;
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements:");
	//taking input from console
	int numberOfInput =s.nextInt();
	int arr[]=new int[numberOfInput];
	System.out.println("Enter the value of index in an array:");
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=s.nextInt();
	}
	arr=sort(arr);
	//loop for printing the sorted array
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
	s.close();
}
}
