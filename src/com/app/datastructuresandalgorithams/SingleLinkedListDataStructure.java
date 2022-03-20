package com.app.datastructuresandalgorithams;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class SingleLinkedListDataStructure {

	private static Logger logger = System.getLogger(SingleLinkedListDataStructure.class.getName());

	static Node<Integer> head=null;

	//Adding Data to start of HeadNode
	public static void addStartOfHead(Integer data) {
		Node<Integer> currentNode=new Node<>(data);
		currentNode.next=head;
		head=currentNode;
	}

	//Adding Data to end of HeadNode
	public static void addEndOfHead(Integer data) {
		Node<Integer> currentNode=new Node<>(data);
		if(head==null) {
			head=currentNode;
			return;
		}
		Node<Integer> current=head;
		while(null!=current.next) {
			current=current.next;
		}
		current.next=currentNode;
	}
	//Adding Data at specific position
	public static void addAtNthposition(Integer data,Integer position) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null || position==1) {
			dataNode.next=head;
			head=dataNode;
		}else {
			Node<Integer> temp=head;
			Integer count=1;
			while(count<position-1) {
				temp=temp.next;
				count++;
				if(temp.next==null)
					return;
			}
			Node<Integer> neaxtToTemp=temp.next;
			dataNode.next=neaxtToTemp;
			temp.next=dataNode;
		}
	}

	//Get Data from linkedlist
	public static Integer get(Integer index) {
		Integer count=1;
		if(head==null) {
			return null;
		}else {
			Node<Integer> temp=head;
			if(count==index) {
				return temp.data;
			}else {
				while(temp.next!=null) {
					count=count+1;
					temp=temp.next;
					if(count==index)
						return temp.data;
				}
			}
		}
		return null;
	}

	//Delete Node
	public static void deleteNode(Integer data) {
		Node<Integer> currentNode=head;

		if(currentNode!=null && currentNode.data==data) {
			head=currentNode.next;
		}else {
			while(null!=currentNode && null!=currentNode.next) {
				Node<Integer> previousNode=currentNode;
				currentNode=currentNode.next;
				if(currentNode.data.equals(data)) {
					Node<Integer> nextNode=currentNode.next;
					previousNode.next=nextNode;
					break;
				}
			}
		}

	}

	//Reverse LinkedList
	public static void reverseLinkedList() {
		Node<Integer> current  = head;
		Node<Integer> previous = null;
		Node<Integer> next     = null;
		while(current!=null) {
			previous = current;
			current  = current.next;

			previous.next = next;
			next=previous;
			head=next;
		}
	}
	public static void main(String... customLinkedListExample) {

		addEndOfHead(190);
		addEndOfHead(293);
		addEndOfHead(596);
		addEndOfHead(206);
		logger.log(Level.INFO,head);
		reverseLinkedList() ;
		logger.log(Level.INFO,get(4));
		logger.log(Level.INFO,head);

	}

}



