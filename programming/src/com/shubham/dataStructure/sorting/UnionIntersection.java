package com.shubham.dataStructure.sorting;
import java.util.Scanner;
public class UnionIntersection {
public static void unionIntersection(int firstArr[],int secondArr[])
{
	int size1=firstArr.length;
	int size2=secondArr.length;
	int left=0;
	int right=size1-1;
	int left1=0;
	int right1=size2-1;
	int union[]=new int[size1+size2];
	int intersection[]=new int[Math.min(size1, size2)];
	int index=0;
	int uindex=0;
	
	//logic for union and intersection
	while(left<=right&&left1<=right1)
	{
		if(firstArr[left]<secondArr[left1])
		{
			union[uindex++]=firstArr[left];
			left++;
		}
		else
			if(secondArr[left1]<firstArr[left])
			{
				union[uindex++]=secondArr[left1++];
			}
			else
			{
				union[uindex++]=firstArr[left++];
				intersection[index++]=secondArr[left1++];
			}
	}
	while(left<=right)
	{
		union[uindex++]=firstArr[left++];
	}
	while(left1<=right1)
	{
		union[uindex++]=secondArr[left1++];
	}
	
	//logic for printing intersection array
	for(int i=0;i<intersection.length;i++)
	{
		System.out.print(intersection[i]+" ");
	}
	
	int uArr[]= {};
	int j=0;
	for(int i=0;i<union.length;i++)
	{
		if(union[i]>0)
		{
			uArr[j++]=union[i];
		}
	}
	//logic for printing union array
	for(int i=0;i<uArr.length;i++)
	{
		System.out.print(uArr[i]+" ");
	}
}
//creating a runner function
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("Enter the number of elements:");
	int n=s.nextInt();
	System.out.println("Enter the index values of array:");
	int firstArr[]=new int[n];
	for(int i=0;i<n;i++)
	{
		firstArr[i]=s.nextInt();
	}
	System.out.println("Enter the number of elements:");
	int n1=s.nextInt();
	System.out.println("Enter the index values of array:");
	int secondArr[]=new int[n1];
	for(int i=0;i<n;i++)
	{
		firstArr[i]=s.nextInt();
	}
	unionIntersection(firstArr, secondArr);
	s.close();
}
}
