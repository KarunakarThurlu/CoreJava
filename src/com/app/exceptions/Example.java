package com.app.exceptions;

public class Example {
	/*
	 * In Java Exceptions Can be handled in Two Ways
	 * 
	 * 1). By using  try catch blocks
	 * 2). By using  throws keyword
	 * 
	 ***Note:- It is Highly Recomended to Handle Exceptions using try catch blocks.
	 *
	 ***Why B'z if you handle Exceptions using throws keyword it is always "Abnormal Termination".
	 *
	 */
	public static void main(String[] args) {
		System.out.println("foo1");
		System.out.println("foo2");
		System.out.println("foo3");
			try {
				foo(0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		System.out.println("foo4");
		System.out.println("foo5");
		System.out.println("foo6");
	}
	private static int foo(int i) {
		System.out.println(10/i);
		return 0;
	}
}
