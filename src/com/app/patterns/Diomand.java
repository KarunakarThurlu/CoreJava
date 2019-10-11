package com.app.patterns;

public class Diomand {
	public static void main(String[] args) {
		for(int i=1;i<=7;i++)
		{
			for(int j=1;j<=(7-i);j++)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=6;i>=1;i--)
		{
			for(int j=1;j<=(7-i);j++)
			{
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
