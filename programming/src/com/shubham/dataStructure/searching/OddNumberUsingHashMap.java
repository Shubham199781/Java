package com.shubham.dataStructure.searching;
import java.util.HashMap;
public class OddNumberUsingHashMap {
public static void oddCount(int []arr)
{
	int size=arr.length;
	HashMap<Integer, Integer> hm=new HashMap<>();
	//initialized my HashMap
	for(int i=0;i<size;i++)
	{
		if(hm.containsKey(arr[i])==true)
		{
			hm.put(arr[i], hm.get(arr[i])+1);
		}
		else
			hm.put(arr[i], 1);
	}
	//logic for values appearing more than three times
	for(int i=0;i<size;i++)
	{
		if(hm.containsKey(arr[i])&&hm.get(arr[i])==3)
		{
			System.out.print(arr[i]+" ");
			hm.remove(arr[i]);
		}
	}
}
//runner method
public static void main(String[] args) {
	int []arr= {1,1,1,2,2,3,3,3,4,5,6,8,8,8};
	oddCount(arr);
}
}
