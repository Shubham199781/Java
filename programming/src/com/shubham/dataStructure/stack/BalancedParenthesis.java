package com.shubham.dataStructure.stack;

public class BalancedParenthesis {
//logic for checking balanced parenthesis
public static boolean isBalanced(String st)
{
	char []ch=st.toCharArray();
	Stack<Character> stk=new Stack<Character>();
	int size=ch.length;
	for(int i=0;i<size;i++)
	{
		switch(ch[i])
		{
		case '{':
		case '[':
		case '(':stk.push(ch[i]);
		         break;
		case '}':if(stk.pop()!='{')
			     return false;
		         else
		           break;
		case ']':if(stk.pop()!='[')
			      return false;
		          else
		        	  break;
		case ')':if(stk.pop()!='(')
			     return false;
		         else
			        break;
		}
	}
	return stk.isEmpty();
}
//runner method
public static void main(String[] args) {
	String st="((((()))";
	boolean b=isBalanced(st);
	System.out.println("The parenthesis is balanced:"+" "+b);
}
}
