package com.app.datastructuresandalgorithams;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoublyLinkedList {

	private static final Logger logger = System.getLogger(DoublyLinkedList.class.getName());

	private  Node<Integer> head=null;
	private  Node<Integer> tail=null;

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
			return  "[ "+data + " |*<--]-->*" + next + "";
		}
	}
	
	
	

	/**
	 * Show Elements in DoublyLinkedList
	 */
	public void display() {
		List<Integer> list = new ArrayList<>();
		if(head==null) {
			logger.log(Level.INFO,"No values found");
		}else {
			Node<Integer> temp=head;
			while(temp!=null) {
				list.add(temp.data);
				temp=temp.next;
			}
			logger.log(Level.INFO,list);
		}
	}
	
	/**
	 * Add Element at front of head Node
	 * @param data
	 */
	public  void addAtFirst(Integer data) {
		Node<Integer> dataNode = new Node<Integer>(data);
		if(head==null) {
			head=tail=dataNode;
			head.prev=null;
			tail.next=null;
		}else {
			dataNode.next=head;
			head.prev=dataNode;
			head=dataNode;
		}
	}
	
	/**
	 * Add Element at Nth index
	 * @param index
	 * @param data
	 */
	public void addAtNthIndex(Integer index,Integer data) {
		Node<Integer> dataNode = new Node<>(data);
		if(head==null || index == 0) {
			head = tail = dataNode ;
			head.prev = null;
			tail.next = null;
		}else {
			Integer count = 1;
			Node<Integer> temp = head;
			while(temp!=null) {
				if(Objects.equals(index, count)) {
					Node<Integer> prev = temp;
					temp = temp.next;
					prev.next = dataNode;
					dataNode.prev = prev;

					dataNode.next=temp;
					temp.prev =dataNode;
					break;
				}
				count=count+1;
				temp=temp.next;
			}
		}
	}
	
	/**
	 * Add Element at end of head Node
	 * @param data
	 */
	public void addAtEnd(Integer data) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null) {
			head=tail=dataNode;
			head.prev=null;
			tail.next=null;
		}else {
			tail.next=dataNode;
			dataNode.prev=tail;
			tail=dataNode;
		}
	}
	
	
	/**
	 * Remove element at Nth index
	 * @param index
	 */
	public void remove(Integer index) {
		if(index==0) {
			head = head.next;
			head.prev=null;
		}else {
			Integer count = 1;
			Node<Integer> temp = head;
			while(temp!=null) {
				if(Objects.equals(count, index)) {
					Node<Integer> prev=temp;
					temp=temp.next;
					prev.next=temp.next;
					temp.prev=prev;
					break;
				}
				count=count+1;
				temp=temp.next;
			}
		}
	}
	
	/**
	 * Reversing Double Linked List
	 */
	public  void reverse() {
		Node<Integer> temp=tail;
		Node<Integer> thead=null;
		Node<Integer> ttail=null;
		while(temp!=null) {
			Node<Integer> dataNode = new Node<>(temp.data);
			if(thead==null) {
				thead=ttail=dataNode;
			}else {
				ttail.next    = dataNode;
				dataNode.prev = ttail;
				ttail=dataNode;
			}
			temp=temp.prev;
		}
		
		List<Integer> list = new ArrayList<>();
		if(head==null) {
			logger.log(Level.INFO,"No values found");
		}else {
			Node<Integer> ttemp=thead;
			while(ttemp!=null) {
				list.add(ttemp.data);
				ttemp=ttemp.next;
			}
			logger.log(Level.INFO,"Reversed DoubleLinkedList :{0}",list);
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.addAtEnd(10);
		dll.addAtEnd(20);
		dll.addAtEnd(30);
		dll.addAtEnd(40);
		dll.addAtEnd(60);
		dll.addAtEnd(50);

		dll.display();
		dll.addAtNthIndex(3,35);
		dll.display();
		dll.remove(3);
		dll.display();
		dll.reverse();
		logger.log(Level.INFO,dll.head);
	}
}
