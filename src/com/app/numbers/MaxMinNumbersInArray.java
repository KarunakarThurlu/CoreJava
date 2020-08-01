package com.app.numbers;

import java.util.Arrays;

public class MaxMinNumbersInArray {
	public static void main(String[] args) {
		int a[]= {10,40,60};
		
		Arrays.stream(a).min().ifPresent(s->System.out.println(" min number using  lambda  : "+s));
		Arrays.stream(a).max().ifPresent(s->System.out.println(" max number using  lambda  : "+s));
		
		
		System.out.print("Before Sorting ");
		Arrays.stream(a).forEach(k->System.out.print(k+" "));
		System.out.println();
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(a[i]<a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.print("After Sorting ");
		Arrays.stream(a).forEach(k->System.out.print(k+" "));
		System.out.println();
		System.out.println("Minum   Number is :"+a[0]);
		System.out.println("Maximam Number is :"+a[a.length-1]);
		System.out.println("Second Maximam Number is :"+a[a.length-2]);
	}
}
