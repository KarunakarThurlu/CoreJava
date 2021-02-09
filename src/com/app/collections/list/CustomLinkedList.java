package com.app.collections.list;

class Node {
    public int key;
    public Node next;
	public Node() {
		super();
	}
}

class SingleLinkedList{
	private Node head;
	
	public void insertData(int data) {
		Node nextNode=new Node();
		nextNode.key=data;
		nextNode.next=head;
		head=nextNode;
	}
	
	public void printLinkedListData() {
		Node current=head;
		while(current!=null) {
			System.out.println(current.key+" ");
			current=current.next;
		}
	}
}

public class CustomLinkedList {
	public static void main(String[] args) {
		SingleLinkedList sl=new SingleLinkedList();
		sl.insertData(10);
		sl.insertData(12);
		sl.insertData(13);
		sl.printLinkedListData();
	}
}
