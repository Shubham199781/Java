package com.shubham.dataStructure.stack;

public class MaximumDepthParenthesis {
//logic for finding maximum depth
public static int maximumDepth(String st)
{
	char ch[]=st.toCharArray();
	int size=ch.length;
	int maxdepth=0;
	int depth=0;
	for(int i=0;i<size;i++)
	{
		if(ch[i]=='(')
		{
			 depth+=1;
		}
		else
			if(ch[i]==')')
				depth-=1;
		if(maxdepth<depth)
			maxdepth=depth;
	}
	return maxdepth;
}
//runner method
public static void main(String[] args) {
	String st="((())(((()))(((((())))))";
	int answer=maximumDepth(st);
	System.out.println("The maximum depth obtained as:"+" "+answer);
}
}
