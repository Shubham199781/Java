package com.shubham.dataStructure.sorting;

public class InsertionSortGeneric<T extends Comparable<T>> {
public void insertionSort(T arr[])
{
	int size=arr.length;
	//outer loop is for number of times
	for(int i=0;i<size-1;i++)
	{
		for(int j=i+1;j>0;j--)
		{
			if(arr[j-1].compareTo(arr[j])>0)
			{
				T temp=arr[j-1];
				arr[j-1]=arr[j];
				arr[j]=temp;
			}
		}
	}
}
//logic for printing the sorted array
public void print(T arr[])
{
	int size=arr.length;
	//loop is to print the array
	for(int i=0;i<size;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
//runner method
public static void main(String[] args) {
	String arr[]= {"To","YO","ZOO","Common"};
	InsertionSortGeneric<String> i=new InsertionSortGeneric<String>();
	i.insertionSort(arr);
	i.print(arr);
}
}
