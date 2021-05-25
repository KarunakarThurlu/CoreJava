package com.app.java8Features;

import java.util.function.BinaryOperator;

public class BinaryOperatorEx{

	public static void main(String[] args) {
		BinaryOperator<Integer> binaryOperator=(a,b)->{
			return a+b;
		};
		Integer l= binaryOperator.apply(10, 20);
		System.out.println(l);
	}
}
