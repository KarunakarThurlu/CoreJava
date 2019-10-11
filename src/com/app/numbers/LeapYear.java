package com.app.numbers;

public class LeapYear {
	public static void main(String[] args) {

		int n=2020;
		if(n%100==0)
		{
			if(n%400==0)
				System.out.println(n+" is Leap Year");
			else
				System.out.println(n+" is not Leap Year");
		}
		else
		{
			if(n%4==0)
				System.out.println(n+" is LeapYear");
			else
				System.out.println(n+" is not Leapyear");
		}

	}
}
