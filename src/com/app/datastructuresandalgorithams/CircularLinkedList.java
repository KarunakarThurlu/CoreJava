package com.app.datastructuresandalgorithams;

import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList {
	
	private static final System.Logger logger = System.getLogger(CircularLinkedList.class.getName());
	
	private static Node<Integer> head=null;
	private static Node<Integer> tail=null;
	
	/**
	 * Adding Node at front of head Node
	 * @param data
	 */
	public static void addAtFront(Integer data) {
		Node<Integer> dataNode = new Node<>(data);
		if(head==null) {
			head = dataNode;
			tail = dataNode;
			dataNode.next=head;
		}else {
			Node<Integer> temp = head;
			dataNode.next  = temp;
			head = dataNode;
			tail.next = head;
		}
	}
	
	/**
	 * Adding Node at End of head Node
	 * @param data
	 */
	public static void addAtEnd(Integer data) {
		Node<Integer> dataNode = new Node<>(data);
		if(head==null) {
			head = dataNode;
			tail = dataNode;
			dataNode.next=head;
		}else {
			tail.next = dataNode ;
			tail = dataNode;
			tail.next = head;
		}
	}
	
	/**
	 * Adding Node at specific index
	 * @param index
	 * @param data
	 */
	public static void addAtNthIndex(Integer index,Integer data) {
		Node<Integer> dataNode = new Node<>(data);
		if(head==null || index==0) {
			dataNode.next=head;
			tail.next=dataNode;
			head=dataNode;
		}else {
			 Integer indexCount = 1;
			 Node<Integer> temp = head;
			 do {
				 if(indexCount==index) {
					 Node<Integer> previous =  temp;
					 temp=temp.next;
					 previous.next =dataNode;
					 dataNode.next=temp;
					 break;
				 }
				 indexCount++;
				 temp = temp.next;
			 }while(temp!=head);
			 if(index>indexCount) {
				 tail.next=dataNode;
			     tail=dataNode;
			     tail.next=head;
			 }  
		}
	}
	
	/**
	 * Removing Element at specific index
	 * @param index
	 */
	public static void removeElementAtNthIndex(Integer index) {
		if(index<0)
			logger.log(Level.INFO, "====================: Please enter valid index===================");
		else {
			Node<Integer> temp = head;
			if(index==0) {
				temp = temp.next;
				tail.next=temp;
				head=temp;
			}else {
				Integer indexCount = 1;
				do{
					if(indexCount==index) {
						Node<Integer> previous =temp;
						temp=temp.next;
						previous.next=temp.next;
					}
					indexCount++;
					temp = temp.next;
				}while(temp!=head);
			}
		}
	}
	
	/**
	 * Display the elements of circular linked list
	 * @return
	 */
	public static  List<Integer> showElements(){
		ArrayList<Integer> al= new ArrayList<>();
		Node<Integer> temp =head;
		if(head!=null) {
			do {
				al.add(temp.data);
				temp=temp.next;
			}while(temp!=head);
		}
		return al;
	}
	public static void main(String[] args) {
		addAtFront(10);
		addAtFront(20);
		addAtFront(50);
		addAtFront(30);
		addAtFront(40);
		addAtFront(80);
		logger.log(Level.INFO, showElements());
		addAtNthIndex(10,45);
		logger.log(Level.INFO, showElements());
		removeElementAtNthIndex(-10);
		logger.log(Level.INFO, showElements());
		
	}
}
