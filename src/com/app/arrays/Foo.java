package com.app.arrays;

public class Foo {
	public static void foo(int y,int ... is) {
		System.out.println("1 int");
	}
	public static void foo(int k) {
		System.out.println("1 int");
	}
	public static void foo(int b,int a) {
		System.out.println("2 ints");
	}
	public static void main(String[] args) {
		foo(10,23,0);
	}
}
