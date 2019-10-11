package com.app.exceptions;

public class CustomException {
	
	public static void showStatus(int n)
	{
		try {
			
		if(n<18)
			throw new RuntimeException();
		else
			System.out.println("you are eligible for vote");
		}
		catch (Exception e) {
			System.out.println("you are not  eligible for vote");
		}
	}
	public static void main(String[] args) {
		showStatus(10);
	}
}
