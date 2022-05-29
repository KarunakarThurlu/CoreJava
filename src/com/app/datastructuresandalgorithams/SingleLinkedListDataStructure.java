package com.app.datastructuresandalgorithams;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Objects;



public class SingleLinkedListDataStructure {

	private static Logger logger = System.getLogger(SingleLinkedListDataStructure.class.getName());

	static Node<Integer> head=null;

	/**
	 * Adding Data to start of HeadNode
	 * @param data
	 */
	public static void addStartOfHead(Integer data) {
		Node<Integer> currentNode=new Node<>(data);
		currentNode.next=head;
		head=currentNode;
	}

	/**
	 * Adding Data to end of HeadNode
	 * @param data
	 */
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

	/**
	 * Adding Data at specific position
	 * @param data
	 * @param index
	 */
	public static void addAtNthposition(Integer data,Integer index) {
		Node<Integer> dataNode = new Node<>(data);
		if(index==0 || head == null) {
			dataNode.next = head;
			head = dataNode;
		}else {
			Integer count = 1;
			Node<Integer> temp = head;
			while(null!=temp.next) {
				Node<Integer> previous =  temp;
				temp = temp.next;
				if(Objects.equals(index, count)) {
					previous.next = dataNode;
					dataNode.next = temp;
				}
				count++;
			}
			if(index>count)
				temp.next = dataNode;	
		}
	}

	/**
	 * Get Data from linked list
	 * @param index
	 * @return
	 */
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

	/**
	 * Delete Node in linked list
	 * @param data
	 */
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

	/**
	 * Removing Duplicate Nodes in single linked list
	 * @param head
	 */
	public static Node<Integer> removeDuplicateNodes(Node<Integer> head) {
		if(head!=null) {
			Node<Integer> temp=head;
			while(temp.next!=null) {
				if(temp.data==temp.next.data)
					temp.next=temp.next.next;
				else
					temp=temp.next;
			}
		}
		return head;
	}

	/**
	 * Reverse LinkedList
	 * @param head
	 * @return
	 */
	public static Node<Integer>  reverseLinkedList(Node<Integer> head) {
		Node<Integer> temp1=head;
		Node<Integer> temp2=null;
		Node<Integer> temp3=null;
		while(temp1!=null) {
			temp2=temp1;
			temp1=temp1.next;

			temp2.next  = temp3;
			temp3=temp2;
		}
		return temp3;
	}

	/**
	 * Reverse LinkedList using Recursion
	 * @param head
	 * @return
	 */
	public static Node<Integer>  reverseLinkedListRecursively(Node<Integer> head) {
		if(head==null || head.next == null)
			return head;
		Node<Integer> h = reverseLinkedListRecursively(head.next);
		head.next.next=head;
		head.next=null;
		return h;
	}

	/**
	 * Adding all elements at once
	 * @param list
	 * @return
	 */
	public static Node<Integer> addAll(List<Integer> list){
		Node<Integer> head=null;
		for(Integer e:list) {
			if(head==null)
				head = new Node<>(e);
			else {
				Node<Integer> temp = head;
				while(null!=temp.next) {
					temp=temp.next;
				}
				temp.next = new Node<>(e);
			}
		}
		return head;
	}

	/**
	 * Merging of two sorted linked lists
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static Node<Integer> mergingOfTwoSortedLinkedLists(Node<Integer> list1,Node<Integer> list2) {
		Node<Integer> temp= new Node<>(0);
		Node<Integer> head=temp;
		while(true) {
			if(list1==null) {
				temp.next=list2;
				break;
			}
			if(list2==null) {
				temp.next=list1;
				break;
			}
			if(list1.data<=list2.data) {
				temp.next=list1;
				list1=list1.next;
			}else {
				temp.next=list2;
				list2=list2.next;
			}
			temp=temp.next;
		}
		return head.next;
	}
	
	/**
	 * Finding merge point of two linked list
	 * @param head1
	 * @param head2
	 */
	public static Integer mergePointOfTwoLinkedLists(Node<Integer> head1,Node<Integer> head2) {
		Node<Integer> temp1=head1;
		Node<Integer> temp2=head2;
		int firstNodeCount  = 0;
		int secondNodeCount = 0;
		while(temp1!=null) {
			temp1=temp1.next;
			firstNodeCount++;
		}
		while(temp2!=null) {
			temp2=temp2.next;
			secondNodeCount++;
		}
		temp1=head1;
		temp2=head2;
		
		int diff=0;
		if(firstNodeCount>secondNodeCount) {
			diff = firstNodeCount-secondNodeCount;
		}else {
			diff = secondNodeCount-firstNodeCount;
		}
		
		if(firstNodeCount>secondNodeCount) {
			while(diff>0) {
				temp1=temp1.next;
				diff--;
			}
		}else {
			while(diff>0) {
				temp2=temp2.next;
				diff--;
			}
		}
		
		while(temp1!=null && temp2!=null) {
			if(temp1==temp2)
				return temp1.data;
			else {
				temp1=temp1.next;
			    temp2=temp2.next;
			}
		}
		return 0;	
	}

	public static void main(String... customLinkedListExample) {

		addEndOfHead(10);
		addEndOfHead(20);
		addEndOfHead(30);
		addEndOfHead(40);
		addEndOfHead(50);
		logger.log(Level.INFO,head);
		Node<Integer> h= reverseLinkedList(head) ;
		logger.log(Level.INFO,h);
		Node<Integer> h1= addAll(List.of(10,30,50,80,120));
		Node<Integer> h2= addAll(List.of(20,40,60,90,100));
		Node<Integer> h3= mergingOfTwoSortedLinkedLists(h1,h2);
		logger.log(Level.INFO,h3);

		Node<Integer> listWithDuplicates= addAll(List.of(10,20,20,30,50,60,70,80,80,100,120,120,120,130));
		logger.log(Level.INFO,listWithDuplicates);
		Node<Integer> listWithOutDuplicates=removeDuplicateNodes(listWithDuplicates);
		logger.log(Level.INFO,listWithOutDuplicates);
	}

}



