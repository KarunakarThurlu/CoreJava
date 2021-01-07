package com.app.exceptions;

public class ThrowsEx {
	/*
	 * 1). throws applicable for methods,constructors
	 * 2). We can use "throws" for throwable types Only, Otherwise we will get InCompatableException
	 * 3). It can be used for Dalegating Exception Object to "Caller Method".
	 * 4). 
	 */
	public static void main(String[] args) throws InterruptedException{
		foo1();
	}
	public static void foo1()throws InterruptedException {
		foo2();
	}
	private static void foo2()throws InterruptedException {
		System.out.println("foo2");
		Thread.sleep(1000);
	}
}
