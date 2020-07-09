package com.app.java8Features;

public class MethodReference {

	public static void foo() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
		}
	}
	public static void main(String[] args) {
		Runnable r=MethodReference::foo;
		
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
		
	}
}
