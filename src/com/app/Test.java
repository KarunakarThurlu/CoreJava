package com.app;

public class Test {

	
	public static int fib(int n) {
		if(n==0)
			return 0;
		if(n==1 || n==2)
			return 1;
		else 
			return fib(n-2)+fib(n-1);
	}


	public static void main(String[] args) {
		//0 1 1 2 3 5 8 13 21 34 55 89
		for (int i = 0; i < 20; i++) {
			int c=fib(i);
			System.out.print(c+" ");
		}
	}
}
