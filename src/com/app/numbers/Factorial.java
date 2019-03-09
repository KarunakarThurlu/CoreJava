package com.app.numbers;

public class Factorial {
	public static void main(String[] args) {
		int fact=1,i,n=5;
		for(i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		System.out.println(fact);
	}
}
