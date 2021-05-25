package com.app.java8Features;

import java.util.function.UnaryOperator;

public class UnaryOperatorEx {
	
	public static void main(String... unaryoperator) {
		
		UnaryOperator<Integer> u = (foo)->{
			return foo*foo;
		};
		
		Integer res = u.apply(4);

		System.out.println(res);
	}
}
