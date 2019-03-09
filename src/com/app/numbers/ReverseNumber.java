package com.app.numbers;

public class ReverseNumber {
	public static void main(String[] args) {
		int n=1234;
		int temp=n,sum=0;
		while(temp>0)
		{
			int r=temp%10;
			sum=sum*10+r; //sum=sum+r ===> SumOfDigitsOfNumber
			temp=temp/10;
		}
		System.out.println(sum);
	}
}
