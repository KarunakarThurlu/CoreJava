package com.app.datastructuresandalgorithams;

import java.util.Arrays;

public class StackDataStructure {
    private static  int[] arr = new int[10];
    private static  int top=0;
    private static  int capacity=arr.length;
    
    
    public static int size() {
    	return top;
    }
    
    public static int capacity() {
    	return capacity;
    }
    
    public static void push(int data) {
    	if(top==capacity) {
    		capacity=capacity+10;
    		arr=Arrays.copyOf(arr, capacity);
    		arr[top++]=data;
    	}else {
    		arr[top++]=data;
    	}
    }
    
    public static void printStack() {
    	for(int i=0;i<top;i++) {
    		System.out.println(arr[i]);
    	}
    }
    
    public static int pop() {
    	int topel=arr[top-1];
    	arr[top]=0;
    	top=top-1;
    	return topel;
    }
    
    public static int peek() {
    	if(top>0)
    		return arr[top-1];
    	else
    		return 0;
    }
	public static void main(String[] args) {

		System.out.println("stack size : "+ size() +" , stack capacity : "+capacity());
		push(11);
		push(20);
		push(3);
		push(47);
		printStack();
		System.out.println("popedelement : "+ pop());
		System.out.println("stack size : "+ size()+" , stack capacity : "+capacity());
		printStack();
		
		System.out.println("-------------------------------------------------");
		StackUsingLinkedList sl=new StackUsingLinkedList();
		sl.push(10);
		sl.push(20);
		System.out.println(sl.head);
		System.out.println(sl.pop());
		System.out.println(sl.head);
	}
}
class StackUsingLinkedList{
	Node<Integer> head=null;
	Integer size;
	
	public void push(Integer data) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null) {
			head=dataNode;
		}else {
			Node<Integer> t=head;
			while(t.next!=null)
				t=t.next;
			t.next=dataNode;
			size++;
		}
	}
	
	public Integer pop() {
		if(head==null) {
			return null;
		}else {
			Node<Integer> t=head;
			while(null!=t.next) {
				t=t.next;
			}
			Integer data=t.data;
			t=t.next;
			head=t;
			return data;
		}
	}
}
