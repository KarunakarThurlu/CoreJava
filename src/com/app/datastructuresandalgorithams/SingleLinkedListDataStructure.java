package com.app.datastructuresandalgorithams;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;



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
		while(list1!=null && list2!=null) {
			if(list1.data<=list2.data) {
				temp.next=list1;
				list1=list1.next;
				temp=temp.next;
			}else {
				temp.next=list2;
				list2=list2.next;
				temp=temp.next;
			}
		}
		temp.next=list1!=null?list1:list2;
		return head.next;
	}
	
	/**
	 * Get N'th Node from end of linked list
	 * @param head
	 * @param n
	 * @return
	 */
	static int  i=0;
	public static Integer getNthNodeFromEnd(Node<Integer> head,int n) {
		if(head==null)
			return 0;
		getNthNodeFromEnd(head.next,n);
		i++;
		if(i==n) 
			return head.data;
		return 0;
	}
	
	/**
	 * Finding merge point of two linked list
	 * @param head1
	 * @param head2
	 */
	public static Integer mergePointOfTwoLinkedLists(Node<Integer> head1,Node<Integer> head2) {
		Node<Integer> t1=head2;
		Node<Integer> t2=head1;
        while(t1!=t2){
            if(t2==null){
                t2=head2;
            }else{
                t2=t2.next;
            }
            if(t1==null){
                t1=head1;
            }else{
                t1=t1.next;
            }
        }
        return t2.data;
	}
	/**
	 * Deleting N'th Node from end of Linked List
	 * @param head
	 * @param n
	 * @return
	 */
	public static Node<Integer> deleteNthNodeFromEnd(Node<Integer> head,Integer n) {
		int count = 0;
		Node<Integer>  l=head;
        while(l!=null){
            l=l.next;
            count++;
        }
        if(n==count) {
        	return head.next;
        }
        Node<Integer>  temp=head;

        int index=count-n;
        for(int i=1;i<index;i++) {
        	temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
	}
	
	/**
	 * Remove Loop in Linked List if Exists
	 * @param head
	 * @return
	 */
	public static Boolean removeLoopInLinkedList(Node<Integer> head) {
		Set<Node<Integer>> set= new HashSet<>();
		Node<Integer> temp=null;
		while(head!=null) {
			if(set.contains(head)) {
				temp.next=null;
				return true;
			}else {
				set.add(head);
				temp=head;
				head=head.next;
			}
		}
		return false;
	}
	
	/**
	 * Find given  Linked List is Polindrome or not
	 * @param head
	 * @return true is if YES || false id NO
	 */
	public static Boolean isPolindromeList(Node<Integer> head) {
		if(head==null || head.next==null) {
			return true;
		}
		Stack<Integer> s=new Stack<>();
		Node<Integer> t=head;
		while(t!=null) {
			s.push(t.data);
			t=t.next;
		}
		while(head!=null) {
			Integer i = s.pop();
			if(i!=head.data)
				return false;
			head=head.next;
		}
		return true;
	}
	
	public static  Node<Integer> rotateLinkedList(Node<Integer> head,int k){
		if(head==null || head.next==null )
			return head;
		int size=1;
		Node<Integer> l=head;
		while(l.next!=null) {
			l=l.next;
			size++;
		}
		k=k%size;
		if(k%size==0) {
			return head;
		}
		for(int i=0;i<k;i++) {
			head=rotate(head);
		}
		return head;
	}
	public static Node<Integer> rotate(Node<Integer> head){
		Node<Integer> temp=head;
		Node<Integer> t=null;
		while(temp.next!=null) {
			t=temp;
			temp=temp.next;
		}
		if(t!=null) {
			t.next=null;
			temp.next=head;
		}
		return temp;
	}
	
	public static Node<Integer> reverseBetween(Node<Integer> head,int left,int right){
		Node<Integer> prevN=head;
		Node<Integer> currN=null;
		Node<Integer> nextN=null;
		
		for(int i=1;i<left-2;i++) {
			prevN=prevN.next;
		}
		currN=prevN.next;
		prevN.next=null;
		Node<Integer> currN2=currN;
		for(int i=1;i<=(right-left);i++) {
			currN2=currN2.next;
		}
		nextN=currN2.next;
		
		currN2.next=null;
		Node<Integer> rev=reverseLinkedList(currN);
        
		prevN.next=rev;
		Node<Integer> prevN2=prevN;
		while(prevN.next!=null) {
        	prevN=prevN.next;
		}
		prevN.next=nextN;
		return prevN2;
	}
	
	public static void main(String... customLinkedListExample) {
		/*
		addEndOfHead(10);
		addEndOfHead(20);
		addEndOfHead(30);
		addEndOfHead(40);
		addEndOfHead(50);
		logger.log(Level.INFO,head);
		Node<Integer> h= reverseLinkedList(head) ;
		logger.log(Level.INFO,h);
		Node<Integer> h1= addAll(List.of(10,22,30,32,45,50));
		Node<Integer> h2= addAll(List.of(20,40,60,90,100));
		Node<Integer> h3= mergingOfTwoSortedLinkedLists(h1,h2);
		logger.log(Level.INFO,"Merging of sorted lists : {0}",h3);

		Node<Integer> listWithDuplicates= addAll(List.of(10,20,20,30,50,60,70,80,80,100,120,120,120,130));
		logger.log(Level.INFO,listWithDuplicates);
		Node<Integer> listWithOutDuplicates=removeDuplicateNodes(listWithDuplicates);
		logger.log(Level.INFO,listWithOutDuplicates);
		Node<Integer> delNthFromEnd= addAll(List.of(100,200,300));
		logger.log(Level.INFO,delNthFromEnd);
		logger.log(Level.INFO,deleteNthNodeFromEnd(delNthFromEnd, 2));*/
		Node<Integer> palindromelist= addAll(List.of(10,20,50,50,20,10));
		logger.log(Level.INFO, isPolindromeList(palindromelist));
		
		Node<Integer> revbtn= addAll(List.of(100,200,300,400,500,600,700,800));
		logger.log(Level.INFO, revbtn);
		logger.log(Level.INFO, reverseBetween(revbtn, 2, 3));
	}

}



