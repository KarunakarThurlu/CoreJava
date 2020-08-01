package com.app.sortingalgorithms;

import java.util.Arrays;

public class SelectionSort 
{
	/*
	 * SelectionSort: TimeComplexity                Best Case                  Average Case               Worest Case
	 *         
	 *                                               O(n^2)                      O(n^2)                      O(n^2)
	 * 
	 * Explanation:-
	 * =============
	 *               # SelectionSort takes n^2 time complexity in all cases.
	 *               # for example list (or) array contains  10  elements it will take 10*10=100 comparisons
	 *                                                   for 100 elements it will take 100*100=10000 comparisons
	 *       
	 */
	public static void main(String[] args) 
	{
		int a[]= {100,10,50,90,20,40,30,-22,11,23,34};
		System.out.println("Before sorting ");
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
		System.out.println();
		
		new SelectionSort().sort(a);

		System.out.println("After sorting ");
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
	}

	private void sort(int[] arr) 
	{
		int min;
		for(int i=0;i<arr.length;i++)
		{
			min=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[min])
				{   
					min=j;
				}
			}		
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
		}
	}
}
