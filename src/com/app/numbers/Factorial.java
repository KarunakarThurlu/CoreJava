package com.app.numbers;

import java.lang.System.Logger.Level;
import java.util.stream.IntStream;

public class Factorial {
	
	private static final System.Logger logger = System.getLogger(Factorial.class.getName());
	
	public static void main(String[] args) {
		int fact=1,i,n=5;
		for(i=1;i<=n;i++){
			fact=fact*i;
		}
		logger.log(Level.INFO, fact);
		
		logger.log(Level.INFO,getFatorialOfNumer(n));
		
		logger.log(Level.INFO,factorialRecursive(6));
	}
	
	/**
	 * Find Factorial of given number using recursion
	 * @param n
	 * @return
	 */
	public static int factorialRecursive(int n) {
		if(n==0)
			return 1;
		else
			return n*factorialRecursive(n-1);
	}
	
	/**
	 * Find Factorial of given number using Streams
	 * @param n
	 * @return
	 */
	public static int getFatorialOfNumer(int n) {
		return IntStream.rangeClosed(2, n).reduce(1,(a,b)->a*b);
	}
}
