package com.app.string;

public class SentenseReverse {
	public static void main(String[] args) {
		String s1=" karunakr thurlu yadav";
		String s2="";
		for(int i=s1.length()-1;i>=0;i--)
		{
			s2=s1.charAt(i)+s2;
			if(s1.charAt(i)==' ')
			{
				System.out.print(s2);
				s2="";
			}
		}
	}
}
