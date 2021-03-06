package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class BubbleSort {
public static void sort(int [] arr)
{
	System.out.println("The Sorted Array Obtained as:");
	//first loop shows the number of times it is going to get executed
	for(int i=0;i<arr.length-1;i++)
	{
		for(int j=0;j<arr.length-i-1;j++)
		{
			if(arr[j]>arr[j+1])
			{
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
	
	//this loop is for printing the sorted array elements
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
public static void main(String[] args) {
	System.out.println("Enter number of array elements you want to sort:");
	//taking input from console
	Scanner s=new Scanner(System.in);
	int numberOfElements=s.nextInt();
	int arr[]=new int [numberOfElements];
	System.out.println("Enter the value of each index of array:");
	for(int i=0;i<numberOfElements;i++)
	{
		arr[i]=s.nextInt();
	}
	sort(arr);
	s.close();
}
}
