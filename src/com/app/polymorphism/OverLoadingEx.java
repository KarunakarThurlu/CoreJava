package com.app.polymorphism;

public class OverLoadingEx {
	
	/*
	 * Method name is same and parameters are different.
	 * ReturnType may same or may not same
	 * 
	 * 
	 * 
	 */
	
	public static void main(String ...overloading) {
		System.out.println("String args main methods");
	}
	
	public static void main(Double ...overloading) {
		System.out.println("Double args main methods");
	}
	
    public static Float main(Float ...overloading) {
		System.out.println("Float args main methods");
		return Float.MIN_VALUE;
	}
}
