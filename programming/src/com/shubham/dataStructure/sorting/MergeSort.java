package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class MergeSort {
public static void mergeSort(int temp[],int lowerIndex,int upperIndex,int arr[])
{
	//we are using recursion
	if(lowerIndex>=upperIndex)
		return;
	//this will recursively divide the whole array till two elements are left in it
	int midIndex=(lowerIndex+upperIndex)/2;
	mergeSort(temp,lowerIndex,midIndex,arr);
	mergeSort(temp,midIndex+1,upperIndex,arr);
	
	//merge sort logic
	int lowerStart=lowerIndex;
	int upperStart=midIndex+1;
    int lowerStop=midIndex;
	int upperStop=upperIndex;
	int count=lowerIndex;
	while(lowerStart<=lowerStop&&upperStart<=upperStop)
	{
		if(arr[lowerStart]<arr[upperStart])
		{
			temp[count++]=arr[lowerStart++];
		}
		else
	    	temp[count++]=arr[upperStart++];
	}
	
	//if any element gets left out
	while(lowerStart<=lowerStop)
	{
		temp[count++]=arr[lowerStart++];
	}
	while(upperStart<=upperStop)
	{
		temp[count++]=arr[upperStart++];
	}
	//reassigning the values associated with array arr
	for(int i=lowerIndex;i<=upperIndex;i++)
	{
		arr[i]=temp[i];
	}
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of array elements:");
	int numberOfElements=s.nextInt();
	int arr[]=new int[numberOfElements];
	System.out.println("Enter the value of array index:");
	for(int i=0;i<numberOfElements;i++)
	{
		arr[i]=s.nextInt();
	}
	int []temp=new int[numberOfElements];
	mergeSort(temp, 0, numberOfElements-1, arr);
	//loop for printing the sorted array
	for(int i=0;i<numberOfElements;i++)
	{
		System.out.print(arr[i]+" ");
	}
		
}
}
