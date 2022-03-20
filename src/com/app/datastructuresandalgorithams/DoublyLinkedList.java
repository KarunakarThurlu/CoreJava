package com.app.datastructuresandalgorithams;

public class DoublyLinkedList {
	private  Node<Integer> head=null;
	private Node<Integer> tail=null;
	
	static class Node<T>{
		T data;
		Node<T> prev;
		Node<T> next;
		public Node(T data){
			this.data=data;
			this.prev=null;
			this.next=null;
		}
		@Override
		public String toString() {
			return "[ prev = " + prev+" data = " + data  + "next = " + next + " ]";
		}
	}
	
	public void display() {
		if(head==null) {
			System.out.println("");
		}else {
			 Node<Integer> temp=head;
			 while(temp!=null) {
				 System.out.print(temp.data+" ");
				 temp=temp.next;
			 }
		}
	}

	public void add(Integer data) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null) {
			head=tail=dataNode;
			head.prev=null;
			tail.next=null;
		}else {
			tail.next=dataNode;
			dataNode.prev=tail;
			tail=dataNode;
			tail.next=null;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.add(10);
		dll.add(20);
		dll.add(30);
		dll.add(40);
		dll.add(50);
		dll.add(60);
	
		
		dll.display();
	}
}
