package com.app.datastructuresandalgorithams;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack    =  new Stack<>();
	Stack<Integer> minstack =  new Stack<>();
	public static void main(String[] args) {
		
	}
	public void push(Integer data) {
		stack.push(data);
		if(minstack.isEmpty() || data<minstack.peek())
			minstack.push(data);
	}
	public Integer pop() {
		if(stack.pop().equals(minstack.peek()))
			return minstack.pop();
		return null;
	}
	public Integer peek() {
		return minstack.isEmpty()?0:minstack.peek();
	}
}
