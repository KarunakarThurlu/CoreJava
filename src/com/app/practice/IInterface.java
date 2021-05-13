package com.app.practice;

public interface IInterface {
	default void defaultmethod() {
		System.out.println("Default Method implementattion");
	}
	static void staticmethod() {
		System.out.println("Static Method implementattion");
	}
	public void foo();
}
