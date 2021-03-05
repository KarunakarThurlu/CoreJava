package com.app.collections.list;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		s.push("A");
		s.push("B");
		s.push("B");
		s.forEach(e->System.out.println(e));
		System.out.println(s);
	}

}
