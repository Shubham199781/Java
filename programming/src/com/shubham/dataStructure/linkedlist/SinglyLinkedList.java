package com.shubham.dataStructure.linkedlist;

public class SinglyLinkedList<T extends Comparable<T>> {
private Node head=null;
private int size=0;
//static for memory management
private class Node{
	private Node next;
	private T value;
	public Node(T v)
	{
		value=v;
		next=null;
	}
	public Node(T v,Node n)
	{
		value=v;
		next=n;
	}
}
//logic for adding at head
public void addHead(T value)
{
	head=new Node(value,head);
	size++;
}
//logic for adding at tail
public void addTail(T value)
{
	Node n=new Node(value);
	if(head==null)
	{
		head=n;
		size++;
		return;
	}
	Node curr=head;
	while(curr.next!=null)
	{
		curr=curr.next;
	}
	curr.next=n;
	size++;
}
//logic for printing
public void print()
{
	if(head==null)
	{
		System.out.println("Empty Linked List:");
		return;
	}
	Node curr=head;
	while(curr!=null)
	{
		System.out.print(curr.value+" ");
		curr=curr.next;
	}
}
//logic for inserting at sorted manner
public void addSorted(T value)
{
	Node n=new Node(value);
	if(head==null)
	{
		head=n;
		size++;
		return;
	}
	//logic for adding at head
	if(( head.value).compareTo(value)>0)
	{
		n.next=head;
	    head=n;
	    size++;
	}
	else
		if((value).compareTo(head.value)>0)
		{
			Node curr=head;
			while(curr.next!=null)
			{
				curr=curr.next;
			}
			curr.next=n;
			size++;
		}
		else
		{
			n.next=head;
			head=n;
		}
}
//delete repetitions
public void deleteRepetitions()
{
	Node curr=head;
	Node next=null;
	while(curr!=null)
	{
		next=curr.next;
		if(curr.value==curr.next.value)
		{
			curr.next=next.next;
		}
		else
		{
			curr=next;
		}
		
	}
}
//delete a particular value
public void delete(T value)
{
	if(head==null)
	{
		System.out.println("Linked list Empty:");
		return;
	}
	//delete from head
	if(head.value==value)
	{
		head=head.next;
		size--;
	}
	//generic deletion
	if(head.next!=null)
	{
		Node curr=head;
		while(curr.next!=null)
		{
			if(curr.next.value==value)
			{
				curr.next=curr.next.next;
				size--;
			}
			else
				curr=curr.next;
		}
	}
}
//deletion of single linked list
public void deleteLinkedList()
{
	head=null;
	size=0;
}
//logic for reversing a linked list
public void reverse()
{
	Node prev=null;
	Node next=null;
	Node curr=head;
	while(curr!=null)
	{
		next=curr.next;
		curr.next=prev;
		prev=curr;
		curr=next;
	}
	head=prev;
}
//compare the values of two linked list
public boolean compare(SinglyLinkedList<T> l1,SinglyLinkedList<T> l2)
{
	Node head1=l1.head;
	Node head2=l2.head;
	if(head1.value!=head2.value)
		return false;
	else
		return true;
}
//find length of linked list
public int findLength()
{
	return size;
}
//loop detection
public boolean isLoop()
{
	Node slowPtr=head;
	Node fastPtr=head;
	while(fastPtr.next!=null&&fastPtr.next.next!=null)
	{
		slowPtr=slowPtr.next;
		fastPtr=fastPtr.next.next;
		if(slowPtr==fastPtr)
		{
			return true;
		}
	}
	System.out.println("Loop Not Found:");
	return false;
}
//loop detect type
public void isLoopType()
{
	Node fastPtr=head;
	Node slowPtr=head;
	//circular loop
	while(fastPtr.next!=null&&fastPtr.next.next!=null)
	{
		fastPtr=fastPtr.next.next;
		slowPtr=slowPtr.next;
		if(fastPtr.next==head||fastPtr.next.next==head)
		{
			System.out.println("Circular loop detected:");
			return;
		}
		else
			if(slowPtr==fastPtr)
			{
				System.out.println("Loop detected:");
				return;
			}
	}
	System.out.println("Loop not found:");
}
}

