package com.app.numbers;

public class MaxDigit {
	public static void main(String[] args) {
		int n=85967;
		int max=1;
		int temp=n,r=0;
		while(temp>0)
		{
			 r=temp%10;
			 if(max<r)
				max=r;
			temp=temp/10;
		}
		System.out.println(max);
	}
}
