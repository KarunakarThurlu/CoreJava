package com.app.collections.list;

 class Node{
	Integer data;
	Node next;
	public Node(Integer data) {
		super();
		this.data = data;
		this.next = null;
	}	
}
public class CustomLinkedList {
	Node head=null;

	
	public void insertData(Integer data) {
		Node currentNode=new Node(data);
		currentNode.next=head;
		head=currentNode;
	}
	
	public void printData() {
		Node current=head;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
	public static void main(String[] args) {
		CustomLinkedList l=new CustomLinkedList();
		l.insertData(10);
		l.insertData(12);
		l.insertData(13);
		l.printData();
		
	}
}

