package com.app.practice;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
    	String s="{}[]{{}}[]";
    	Boolean f=checkExpression(s);
    	System.out.println(f==true?"Balanced":"Unbalanced");
    }
    public  static Boolean checkExpression(String s) {
    	Stack<Character> stack=new Stack<>();
        Boolean isBalanced=true;
        if(s.length()%2!=0)
        	isBalanced=false;
        else {
        	for(int i=0;i<s.length();i++) {
            	if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[')
            		stack.push(s.charAt(i));
            	else {
            		if(stack.isEmpty()) {
            			isBalanced=false;
            			return isBalanced;
            		}
            		Character lastchar=stack.peek();
            		if((lastchar=='{' && s.charAt(i) =='}') || (lastchar=='(' && s.charAt(i) ==')' || (lastchar=='[' && s.charAt(i) ==']')))
            			 stack.pop();
            		else
            			return isBalanced=false;	
            	}
            }
        } 
        return isBalanced;
    }
	private void quickSort(int[] arr, int left, int right) {
		int i=left,j=right;
		int pivot=arr[(left+right)/2];
		while(i<=j) {
			while(arr[i]<pivot)
				i=i+1;
			while(arr[j]>pivot)
				j=j-1;
			if(i<=j) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i=i+1;
				j=j-1;
			}
		}
		if(left<j)
			quickSort(arr, left, j);
		if(i<right)
			quickSort(arr, i, right);
	}
}
