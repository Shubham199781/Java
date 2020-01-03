package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class QuickSort {
public static void quickSort(int arr[],int lower,int upper)
{
	if(upper<=lower)
		return;
	int pivot=arr[lower];
	int start=lower;
	int stop=upper;
	while(lower<upper)
	{
		while(arr[lower]<=pivot&&lower<upper)
		{
			lower+=1;
		}
		while(arr[upper]>pivot&&upper>=lower)
		{
			upper-=1;
		}
		if(lower<upper)
		{
			int temp=arr[lower];
			arr[lower]=arr[upper];
			arr[upper]=temp;
		}
	}
	//swapping the pivot value
	int temp=pivot;
	pivot=arr[upper];
	arr[upper]=temp;
	//recursively call the function till 2 left elements
	quickSort(arr, start, upper-1);
	quickSort(arr, upper+1, stop);
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements of array");
	int numberOfElements=s.nextInt();
	System.out.println("Enter the value of index in array");
	int arr[]=new int[numberOfElements];
	for(int i=0;i<numberOfElements;i++)
	{
		arr[i]=s.nextInt();
	}
	quickSort(arr, 0, numberOfElements-1);
	
	//loop for printing the sorted array
	for(int i=0;i<numberOfElements;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
}
