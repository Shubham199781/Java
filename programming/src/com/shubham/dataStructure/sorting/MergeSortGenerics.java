package com.shubham.dataStructure.sorting;

public class MergeSortGenerics<T extends Comparable<T>> {
	public void mergeSort(T arr[],T temp[],int lower,int upper)
	{
		//recursive method
		if(lower>=upper)
		{
			return;
		}
		//dividing the array
		int mid=(lower+upper)/2;
		mergeSort(arr,temp,lower,mid);
		mergeSort(arr,temp,mid+1,upper);
		//merge sort logic
		int lowerStart=lower;
		int lowerStop=mid;
		int upperStart=mid+1;
		int upperStop=upper;
		int count=lower;
		while(lowerStart<=lowerStop&&upperStart<=upperStop)
		{
			if(arr[lowerStart].compareTo(arr[upperStart])<0)
			{
				temp[count++]=arr[lowerStart++];
			}
			else
				if(arr[upperStart].compareTo(arr[lowerStart])<0)
				{
					temp[count++]=arr[upperStart++];
				}
				else
					temp[count++]=arr[lowerStart++];
			
		}
		while(lowerStart<=lowerStop)
		{
			temp[count++]=arr[lowerStart++];
		}
		while(upperStart<=upperStop)
		{
			temp[count++]=arr[upperStart++];
		}
	}
	//creating a sorting function
	public void sort(T arr[])
	{
		int size=arr.length;
		@SuppressWarnings("unchecked")
		T temp[]=(T[])new Object [size];

	    mergeSort(arr, temp, 0, size-1);
		//logic for printing
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	//runner method
	public static void main(String[] args) {
		MergeSortGenerics<String> m=new MergeSortGenerics<>();
		String arr[]= {"z","g","d","k"};
		m.sort(arr);
	}

}
