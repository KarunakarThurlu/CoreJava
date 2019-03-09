package com.app.numbers;

public class MissingNumberInArray {
	public static int sumn(int n)
	{    
		int sum=0;
		 sum=n*(n+1)/2;
		return sum;
	}
	public static int sumd(int a[])
	{
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		
		int n=7;
		int a[]= {1,2,4,5,6,7};
		int sn=sumn(n);
		int sd=sumd(a);
		System.out.println("Missing number is :"+ (sn-sd));
	}
}
