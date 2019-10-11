package com.app.numbers;

public class FizzBuzzNumbers {
	public static void main(String[] args) {
		for(int i=1;i<50;i++)
		{
			/*
			 * if(i%3==0&&i%5==0) { System.out.println("FizzBuzz"); } if(i%3==0) {
			 * System.out.println("Fizz"); } if(i%5==0) { System.out.println("Buzz"); }
			 */
			System.out.println((i%3==0&&i%5==0)?"FizzBuzz "+i:(i%3==0)?"Buzz "+i:"fuzz "+i);
		}
	}
}
