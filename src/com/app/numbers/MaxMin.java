package com.app.numbers;

import java.util.Scanner;

public class MaxMin {
	public static void main(String[] args) {
		System.out.println("enter a number");
		int max=Integer.MAX_VALUE,temp;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("enter "+n+" numbers");
		for(int i=0;i<=n;i++)
		{
			temp=sc.nextInt();
			if(temp>=max)
			{
				max=temp;
			}
			
		}
		System.out.println("*****"+max);
		System.out.println("*****"+max);System.out.println("*****"+max);
		System.out.println("*****"+max);
		sc.close();
	}
}
