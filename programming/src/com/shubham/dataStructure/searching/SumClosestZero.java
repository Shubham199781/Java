package com.shubham.dataStructure.searching;

import java.util.Arrays;

public class SumClosestZero {
public static void sum(int arr[])
{
	Arrays.sort(arr);
	int size=arr.length;
	int left=0;
	int right=size-1;
	int min=9999;
	int index1=0;
	int index2=0;
	
	while(left<right)
	{

		int sum=(arr[left]+arr[right]);
		if(Math.abs(sum)<min)
		{
			min=Math.abs(sum);
			index1=left;
			index2=right;
		}
		if(sum>0)
		{
			right--;
		}
		else
			if(sum<0)
			{
				left++;
			}
			else
				break;
	}
	System.out.println("The minimum value.....and both the indexes");
	System.out.println(min+" "+arr[index1]+" "+arr[index2]);
}
//runner method
public static void main(String[] args) {
	int arr[]= {-4,-2,-1,0,2,6,7,8};
	sum(arr);
}
}
