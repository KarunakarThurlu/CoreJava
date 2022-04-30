package com.app.numbers;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class ReversePolishNotation {

	private static final Logger logger = System.getLogger(ReversePolishNotation.class.getName());

	public static void main(String[] args) {

		String input     = "21+3*";
		evaluate(input);
	}

	public static void evaluate(String src) {
		String operators = "*-+/";
		Deque<String> stack = new LinkedBlockingDeque<>();
		char[] ch = src.toCharArray();
		for(char c:ch) {
			if(operators.contains(String.valueOf(c))) {
				Integer a = Integer.valueOf(stack.pop());
				Integer b = Integer.valueOf(stack.pop());
				switch (String.valueOf(c)) {
				case "*": 
					stack.push(String.valueOf(a*b));
					break;
				case "-": 
					stack.push(String.valueOf(a-b));
					break;
				case "/": 
					stack.push(String.valueOf(a/b));
					break;
				case "+": 
					stack.push(String.valueOf(a+b));
					break;
				default:
					break;
				}
			}else {
				stack.push(String.valueOf(c));
			}
		}
		logger.log(Level.INFO,"Evaluation Result : {0}",stack.peek());
	}
}
