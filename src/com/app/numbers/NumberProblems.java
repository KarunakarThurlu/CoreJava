package com.app.numbers;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class NumberProblems {
	
	private static Logger logger = System.getLogger(NumberProblems.class.getName());
	
	public static void main(String[] args) {
		logger.log( Level.INFO,"32 is Power of 2     : {0}", powerOfTwo(32));
		logger.log( Level.INFO,"27 is Power of 3     : {0}", powerOfThree(27));
		logger.log( Level.INFO,"64 is Power of 4     : {0}", powerOfFour(64));
		logger.log( Level.INFO,"4 power 3 is         : {0}", XpowerN(4,3));
		logger.log( Level.INFO,"SquareRoot of  64    : {0}", squareRootOfN(64));
		logger.log( Level.INFO,"64 is perfect square : {0}", validPerfectSquare(64));
	}
	
	
	
	/**
	 * Finding given number perfect Square or Not
	 * @param number
	 * @return
	 */
	public static Boolean validPerfectSquare(Integer number) {
		if(number==1)
			 Boolean.TRUE.booleanValue();
		Integer left=0;
		Integer right=number/2;
		Integer pivot;
		while(left<=right) {
			pivot=left+(right-left)/2;
			if(pivot*pivot==number)
				return Boolean.TRUE.booleanValue();
			else if(pivot* pivot<number)
				left=pivot+1;
			else
				right=pivot-1;
		}
		return Boolean.FALSE.booleanValue();
	}
	/**
	 * Calculate Square root of given number
	 * @param number
	 */
	public static int squareRootOfN(Integer number) {
		if(number==0 || number ==1) 
			return number;
		long left=0;
		long right=number/2;
		long pivot;
		while(left<=right) {
			pivot=left+(right-left)/2;
			if(pivot*pivot==number)
				return (int)pivot;
			else if(pivot*pivot<number && (pivot+1)*(pivot+1)>number)
				return (int)pivot;
			else if(pivot*pivot<number)
				left=pivot+1;
			else
				right=pivot-1;
		}
		return -1;
	}
	/**
	 * Calculate  x power n
	 * @param x
	 * @param n
	 * @return
	 */
	public static Integer XpowerN(Integer x,Integer n) {
		if(n==0)
			return 1;
		if(n%2==0)
			return XpowerN(x,n/2)*XpowerN(x,n/2);
		return x*XpowerN(x,n/2)*XpowerN(x,n/2);
	}
	/**
	 * Check given number is power of 2 
	 * @param n
	 * @return
	 */
	public static Boolean powerOfTwo(Integer n) {
		if(n==1) 
			return true;
		else if(n%2!=0 || n==0)
			return false;
		return powerOfTwo(n/2);
	}
	
	/**
	 * Check given number is power of 3
	 * @param n
	 * @return
	 */
	public static Boolean powerOfThree(Integer n) {
		if(n==1) 
			return true;
		else if(n%3!=0 || n==0)
			return false;
		return powerOfThree(n/3);
	}
	
	/**
	 * Check given number is power of 4
	 * @param n
	 * @return
	 */
	public static Boolean powerOfFour(Integer n) {
		if(n==1) 
			return true;
		else if(n%4!=0 || n==0)
			return false;
		return powerOfFour(n/4);
	}
	
	
}
