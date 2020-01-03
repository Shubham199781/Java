package com.shubham.dataStructure.sorting;

public class SelectionSortGeneric<T extends Comparable<T>> {
//method for sorting the array	
public void selectionSort(T arr[])
{
	int size=arr.length;
	//outer loop for number of times
	for(int i=0;i<size-1;i++)
	{
		int index=0;
		for(int j=0;j<size-i;j++)
		{
			if(arr[j].compareTo(arr[index])>0)
			{
				index=j;
			}
		}
		T temp=arr[index];
		arr[index]=arr[size-1-i];
		arr[size-1-i]=temp;
	}
}
//method to print the sorted array
public void print(T arr[])
{
	int size=arr.length;
	for(int i=0;i<size;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
//runner method 
public static void main(String[] args) {
	String arr[]= {"Zoo","Animals","live","IN"};
	SelectionSortGeneric<String> s=new SelectionSortGeneric<>();
	s.selectionSort(arr);
	s.print(arr);
}
}
