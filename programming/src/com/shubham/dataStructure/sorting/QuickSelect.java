package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class QuickSelect {
public static void quickSelect(int arr[],int lower,int upper,int k)
{
    //ending recursion when array is having only two elements
	if(upper<=lower)
		return;
	int start=lower;
	int stop=upper;
	int pivot=arr[lower];
	while(lower<upper)
	{
		while(arr[lower]<=pivot&&lower<upper)
		{
			lower++;
		}
		while(arr[upper]>pivot&&upper>=lower)
		{
			upper--;
		}
		if(lower<upper)
		{
			int temp=arr[lower];
			arr[lower]=arr[upper];
			arr[upper]=temp;
		}
	}
	int temp=pivot;
	pivot=arr[upper];
	arr[upper]=temp;
	
	//check the condition
	if(k<upper)
	 quickSelect(arr, start, upper-1, k);
	
	if(k>upper)
		quickSelect(arr, upper+1, stop, k);
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements:");
	int n=s.nextInt();
	System.out.println("Enter the index values of array:");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	{
		arr[i]=s.nextInt();
	}
	System.out.println("Enter the kth element you want:");
	int e=s.nextInt();
	quickSelect(arr, 0,n , e);
	System.out.println(arr[e-1]);
}
}
