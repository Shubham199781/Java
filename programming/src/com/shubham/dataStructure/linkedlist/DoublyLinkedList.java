package com.shubham.dataStructure.linkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {
private Node Head=null;
private int size=0;
private Node Tail=null; 
private class Node{
	private Node next;
	private Node prev;
	private T value;
	public Node(T v)
	{
		value=v;
		next=null;
		prev=null;
	}
}
//logic for adding at head
public void addHead(T value)
{
	Node n=new Node(value);
	//first element
	if(Head==null)
	{
		Tail=Head=n;
	}
	else
	{
		n.next=Head;
		Head.prev=n;
		Head=n;
		Head.prev=null;
	}
	size++;
}
//logic for sorted insertion
public void sortedInsertion(T value)
{
	Node n=new Node(value);
	//single element
	if(Head==null)
	{
		Head=Tail=n;
		size++;
	}
	//inserting at head
	if((Head.value).compareTo(value)>0)
	{
		n.next=Head;
		Head.prev=Head;
		Head=n;
	}
	//inserting at tail
	Node curr=Head;
	while(curr.next!=null&&(curr.next.value).compareTo(value)<0)
	{
		curr=curr.next;
	}
	if(curr.next==null)
	{
		n.prev=Tail;
		Tail.next=n;
		Tail=n;
	}
	else
	{
		//generic case
		n.next=curr.next;
		curr.next.prev=n;
		curr.next=n;
		n.prev=curr;
	}
	size++;
}
//logic for removing head
public void removeHead()
{
	if(Head==null)
	{
		System.out.println("Linked list is Empty:");
		return;
	}
	Head=Head.next;
	Head.prev=null;
	size--;
}
//logic for reversing a doubly linked list
public void reverse()
{
	Node tempNode=null;
	Node curr=Head;
	while(curr!=null)
	{
		tempNode=curr.next;
		curr.next=curr.prev;
		curr.prev=tempNode;
		if(curr.prev==null)
		{
			Tail=Head;
			Head=curr;
			return;
		}
		curr=curr.next;
	}
}
}
