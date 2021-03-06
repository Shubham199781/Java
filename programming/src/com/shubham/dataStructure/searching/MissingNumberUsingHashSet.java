package com.shubham.dataStructure.searching;
import java.util.Arrays;
import java.util.HashSet;
public class MissingNumberUsingHashSet {
public static int missingNumber(int []arr)
{
	int size=arr.length;
	HashSet<Integer> hs=new HashSet<>();
	Arrays.sort(arr);
	int minValue=arr[0];
	int maxValue=arr[size-1];
	for(int i=0;i<size;i++)
	{
		hs.add(arr[i]);
	}
	//logic for missing number
    for(int i=minValue;i<=maxValue;i++)
    {
    	if(hs.contains(i)==false)
    		return i;
    }
    System.out.println("Nothing is missing:");
    return 0;
}
//runner method
public static void main(String[] args) {
	int arr[]= {21,22,24,25};
	System.out.println(missingNumber(arr));
}
}
