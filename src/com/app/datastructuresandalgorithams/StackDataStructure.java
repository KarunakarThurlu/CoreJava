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
	}
}
