package com.app.sortingalgorithms;

import java.util.Arrays;

public class BubbleSort
{
	
	/*
	 * BubbleSort: TimeComplexity                Best Case                  Average Case               Worest Case
	 *         
	 *                                            O(n)                      O(n^2)                      O(n^2)
	 * 
	 */
	public static void main(String[] args) 
	{
		int a[]= {100,10,50,90,20,40,30,-22,11,23,34};
		System.out.println("Before sorting ");
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
		System.out.println();
		
		new BubbleSort().sort(a);

		System.out.println("After sorting ");
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
	}

	private void sort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(a[i]<a[j]) 
				{
				 int temp =a[i];
				 a[i]=a[j];
				 a[j]=temp;
				}
			}
		}
	}
}
