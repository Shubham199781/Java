package com.shubham.dataStructure.searching;
import java.util.HashSet;
public class FindPairInTwoList {
public static void findPair(int []list1,int []list2,int value)
{
	HashSet<Integer> hs=new HashSet<>();
	int size1=list1.length;
	int size2=list2.length;
	for(int i=0;i<size1;i++)
		hs.add(list1[i]);
	for(int i=0;i<size2;i++)
	{
		if(hs.contains(value-list2[i]))
			System.out.println(list2[i]+" "+(value-list2[i]));
		
	}
}
//runner method
public static void main(String[] args) {
	int list1[]= {0,1,2,3,4,5,6};
	int list2[]= {7,8,9,10,11,12};
	int value=12;
	findPair(list1, list2, value);
}
}
