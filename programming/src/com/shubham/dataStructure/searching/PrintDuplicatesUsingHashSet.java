package com.shubham.dataStructure.searching;
import java.util.HashSet;
public class PrintDuplicatesUsingHashSet {
public static void printDuplicates(int []arr)
{
	//it doesnot allows duplicates to be stored in it
	HashSet<Integer> hs=new HashSet<Integer>();
	for(int i=0;i<arr.length;i++)
	{
		if(hs.contains(arr[i]))
		{
			System.out.println(" "+arr[i]);
		}
		else
			hs.add(arr[i]);
	}
}
public static void main(String[] args) {
	int []arr= {1,2,3,5,5,5,6,6,6,7};
	printDuplicates(arr);
}
}