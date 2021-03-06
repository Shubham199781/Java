package com.shubham.dataStructure.searching;

public class RemoveDuplicates<T extends Comparable<T>> {
public  void removeDuplicates(T []arr)
{
	int size=arr.length-1;
  //using Brute Force search method
	for(int i=0;i<size;i++)
	{
		for(int j=i+1;j<size;j++)
		{
			if(arr[i].compareTo(arr[j])==0)
			{
				T temp=arr[j];
				arr[j]=arr[size-1];
				arr[size-1]=temp;
				size--;
				j--;
			}
		}
	}
	//logic for printing the array
	System.out.println(size);
	for(int i=0;i<size;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
//runner method
public static void main(String[] args) {
	String arr[]= {"p","a","z","a","z","K","k","L"};
	RemoveDuplicates<String> r=new RemoveDuplicates<>();
	r.removeDuplicates(arr);
}
}
