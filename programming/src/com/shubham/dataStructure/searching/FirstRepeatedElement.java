package com.shubham.dataStructure.searching;

public class FirstRepeatedElement {
public static int repeatedElement(int[] arr)
{
	int size=arr.length;
	int lower=0;
	int value=0;
	for(int i=0;i<size-1;i++)
	{
		if(arr[lower]==arr[lower+1])
		{
			value=arr[lower];
			break;
		}
		lower++;
	}
	return value;
}
public static void main(String[] args) {
	int [] arr= {34,56,6,6,6,5};
	int a=repeatedElement(arr);
	System.out.println(a);
}
}
