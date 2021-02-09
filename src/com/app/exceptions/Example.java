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
		System.out.println("Java");
		System.out.println("J2SE");
		System.out.println("J2EE");
			try {
				foo(0);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		System.out.println("J2ME");
		System.out.println("JSF");
		System.out.println("JavaFx");
	}
	private static int foo(int i) {
		System.out.println(10/i);
		return 0;
	}
}
