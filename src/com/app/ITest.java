package com.app;

public interface ITest {
	default  String  getNameInUpperCase(String s) {
		return "foo"; 
	 }
	static void staticMethod() {
		System.out.println("Static");
	}
	Integer isPrime(int n);
}
