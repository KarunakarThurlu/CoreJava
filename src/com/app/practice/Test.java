package com.app.practice;

public class Test {

    public static void main(String[] args) {
    	try {
			add(2,3);
			add(4,5.6f);
		}finally {
			System.out.println("finally");
		}
    }
    
    public static void add(int a,int b) throws ArithmeticException {
    	System.out.println("int int");
    }
    
    public static void add(int a, float f) {
    	System.out.println("int float");
    }
}
