package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class SelectionSort {
public static int[] sort(int []arr)
{
	//outer loop is for number of times
	for(int i=0;i<arr.length-1;i++)
	{
		//inner loop is for sorting
		int index=0;
		for(int j=1;j<arr.length-i;j++)
		{
			if(arr[index]<arr[j])
			{
				index=j;
			}
		}
		int temp=arr[index];
		arr[index]=arr[arr.length-1-i];
		arr[arr.length-1-i]=temp;
	}
	return arr;
}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter number of elements of an array:");
	int numberOfElements=s.nextInt();
	int []arr=new int[numberOfElements];
	System.out.println("Enter the value of indexes in an array:");
	//loop for assigning the values of indexes
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=s.nextInt();
	}
	arr=sort(arr);
	//loop for printing array elements in console
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
	s.close();
}
}
