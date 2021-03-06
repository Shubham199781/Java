package com.shubham.dataStructure.stack;

public class Stack<T extends Comparable<T>> {
private int top=-1;
private T[] data;
private int capacity=1000;
public Stack(int size)
{
	data=(T[])new Comparable[size]; 
	capacity=size;
}
public Stack()
{
	data=(T[])new Comparable[capacity];
}
//method to push elements in Stack
public void push(T value)
{
	if(size()==capacity)
	{
		System.out.println("Stack Overflow Exception:");
		return;
	}
	top+=1;
	data[top]=value;
}
//returns the actual size of Stack
public int size()
{
	return top+1;
}
//method to return the last value of Stack
public T pop()
{
	if(isEmpty())
	{
		System.out.println("Stack Empty Exception:");
		return null;
	}
	T value=data[top];
	top-=1;
	return value;
}
//method for checking stack is empty or not
public boolean isEmpty()
{
	return top==-1;
}
//method to return only the top value
public T top()
{
	if(isEmpty())
	{
		System.out.println("Stack Empty Exception:");
		return null;
	}
	return data[top];
}
//method to display the values in Stack
public void display()
{
	if(isEmpty())
	{
		System.out.println("Stack Empty Exception:");
		return;
	}
	int i=0;
	while(i<size())
	{
		System.out.print(data[i]+" ");
		i+=1;
	}
}
//main method
public static void main(String[] args) {
	Stack<String> stk=new Stack<String>();
	stk.push("a");
	stk.display();
}
}
