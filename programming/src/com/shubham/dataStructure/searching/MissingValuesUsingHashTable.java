package com.shubham.dataStructure.searching;
import java.util.HashSet;
public class MissingValuesUsingHashTable {
public static void missingValues(int []arr)
{
	int size=arr.length;
	HashSet<Integer> hs=new HashSet<>();
	int min=99999;
	int max=-99999;
	//min and max values are storing the numeral values
	for(int i=0;i<size;i++)
	{
		hs.add(arr[i]);
		if(min>arr[i])
			min=arr[i];
		if(max<arr[i])
			max=arr[i];
	}
	System.out.println("The minimum value obtained as:"+" "+min);
	System.out.println("The maximum value obtained as:"+" "+max);
	//logic for missing numbers
	for(int i=min;i<max+1;i++)
	{
		if(hs.contains(i)==false)
			System.out.print(i+" ");
	}
	
}
//runner function
public static void main(String[] args) {
	int []arr= {21,22,50};
	missingValues(arr);
}
}
