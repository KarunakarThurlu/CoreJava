package com.app.numbers;

public class Fibonnaci {
	public static void main(String[] args) {
		int a=0,b=1,c=0;
		for(int i=0;i<20;i++)
		{
			System.out.print(c+" ");
			a=b;
			b=c;
			c=a+b;
		}
	}
}
