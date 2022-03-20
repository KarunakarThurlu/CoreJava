package com.app.arrays;

import java.util.Stack;

public class EvaluatingReversePolishNotation {

	public static void main(String[] args) {
		String[] array= { "/", "+","4", "13", "5"};
		
		Stack<String> stack = new Stack<>();
		String operators    = "*+-/";
		
		for(String e: array) {
			if(!operators.contains(e))
				stack.push(e);
			else {
				if(stack.size()>=2) {
					Integer e1 = Integer.parseInt(stack.pop());
					Integer e2 = Integer.parseInt(stack.pop());
					Integer i  = operators.indexOf(e);
					switch (i) {
					case 0:
						stack.push(String.valueOf(e1*e2));
						break;
					case 1:
						stack.push(String.valueOf(e1+e2));
						break;
					case 2:
						stack.push(String.valueOf(e2-e1));
						break;
					default:
						stack.push(String.valueOf(e2/e1));
						break;
					}
					
				}
			}
		}
		System.out.println(Integer.parseInt(stack.peek()));

	}
}
