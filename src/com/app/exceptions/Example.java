package com.app.exceptions;

public class Example {
	public static void do1()
	{
		System.out.println("one");
		throw new RuntimeException();
	}
	public static void main(String[] args) {
		try
		{
			System.out.println("two");
			do1();
		}
		catch (Exception e) {
			System.out.println("three");
		}
		finally
		{
			System.out.println("four");
		}
		System.out.println("outside");
	}
}
