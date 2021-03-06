package com.shubham.dataStructure.stack;
import com.shubham.dataStructure.stack.Stack;
public class SortedStack{
public static void sort(Stack<Integer> stk)	
{
	if(stk.isEmpty())
	{
		System.out.println("Empty stack:");
		return;
	}
	Stack<Integer> stk1=new Stack<Integer>();
	int temp;
	if(stk1.isEmpty())
	{
		stk1.push(stk.pop());
	}
	while(stk.isEmpty()==false)
	{
		temp=stk.pop();
		while(stk.isEmpty()==false&&stk1.top()<temp)
			stk.push(stk1.pop());
		stk1.push(temp);
	}
	while(stk1.isEmpty()==false)
	{
		stk.push(stk1.pop());
	}
}
//runner method
public static void main(String[] args) {
	Stack<Integer> stk=new Stack<>();
	stk.push(9);
	stk.push(8);
	sort(stk);
	stk.display();
}
}