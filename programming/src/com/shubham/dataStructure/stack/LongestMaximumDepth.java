package com.shubham.dataStructure.stack;
import com.shubham.dataStructure.stack.*;
public class LongestMaximumDepth {
//logic for finding maximum	
public static int maximumDepth(String st)
{
	char ch[]=st.toCharArray();
	Stack<Integer> stk=new Stack<>();
	int length=0;
	for(int i=0;i<ch.length;i++)
	{
		stk.push(-1);
		if(ch[i]=='(')
		{
			stk.push(i);
		}
		else
			if(ch[i]==')')
			{
				stk.pop();
				if(stk.isEmpty()==false)
				{
					length=Math.max(length, i-stk.top());
				}
				else
					stk.push(i);
			}
	}
	return length;
}
//runner method
public static void main(String[] args) {
	String st="(((()))(()()()()(((())))))";
	int a=maximumDepth(st);
	System.out.println("The longest depth obtained as:"+" "+a);
}
}
