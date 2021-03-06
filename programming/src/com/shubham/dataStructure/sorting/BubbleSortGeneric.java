package com.shubham.dataStructure.sorting;


public class BubbleSortGeneric<E extends Comparable<E>> {
public  void bubbleSort(E arr[])
{
	int size=arr.length;
	//outer loop for number of times
	for(int i=0;i<size-1;i++)
	{
		for(int j=0;j<size-1-i;j++)
		{
			if((arr[j]).compareTo(arr[j+1])>0)
			{
				E temp= arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
}
public void print(E arr[])
{
	//loop for printing
	for(int i=0;i<arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
//runner function for testing
public static void main(String[] args) {
	String arr[]= {"e","d","c","b"};
	BubbleSortGeneric<String> b=new BubbleSortGeneric<String>();
	b.bubbleSort(arr);
	b.print(arr);
}
}
