package com.app.numbers;

import java.util.stream.IntStream;

public class Factorial {
	public static void main(String[] args) {
		int fact=1,i,n=5;
		for(i=1;i<=n;i++)
		{
			fact=fact*i;
		}
		System.out.println(fact);
		
		Integer f= IntStream.rangeClosed(2, n).reduce(1,(a,b)->a*b);
	    System.out.println(f);
	}
}
