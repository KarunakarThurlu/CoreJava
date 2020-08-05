package com.app.string;

import java.util.Stack;

public class ParenthesisBresesBraketsCheckAlgorithm {

	public static void main(String[] args) {

		String input="{}()[])";

		String res=checkParenthases(input);
		System.out.println(res);
	}

	private static String checkParenthases(String inputstr) {
		Stack<Character> stack=new Stack<>();

		//Removing white spaces
		String input=inputstr.replaceAll("\\s","");

		String res="balanced";
		if(input.length()%2!=0)
			return "unbalabced";
		else {
			for(int i=0;i<input.length();i++)
			{
				if(input.charAt(i)=='{'||input.charAt(i)=='('||input.charAt(i)=='[')
					stack.push(input.charAt(i));
				else {
					if(stack.isEmpty())
						return "unbalanced";
					char lastch=stack.peek();
					if((lastch=='{' && input.charAt(i)=='}') || (lastch=='[' && input.charAt(i)==']')|| (lastch=='(' && input.charAt(i)==')')) 
						stack.pop();
					else 
						return "unbalanced";

				}
			}

		}
		return res;
	}
}
