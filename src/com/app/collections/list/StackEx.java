package com.app.collections.list;

import java.util.Stack;

public class StackEx {
	/*
	 * 1). Stack is Linear Data Structure.
	 * 2). It follows LIFO(Last In First Out) Rule.
	 * 3). Default capacity of Stack is 10.
	 * 4).
	 * 
	 */
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		s.push("A");
		s.push("B");
		s.push("C");
		s.push("D");
		s.push("E");
		s.push("F");
		s.push("G");
		s.push("H");
		s.push("J");
		s.push("K");
		s.push("L");
		
		System.out.println(s);
		
		//Return the last element from The stack But not modifying the existing stack
		s.peek();
		System.out.println(s);
		
		//Remove and Return the last element from The stack.
		s.pop();
	    System.out.println(s);
		
		System.out.println(s.size());
	}

}
