package com.app.searchingalgorithms;

public class LinearSearch 
{
	public static void main(String[] args) 
	{
		int a[]= {12,4,56,78,90,52,43,78};
		int index=linearSearch(a,52);
		System.out.println("52 is found at : "+index+"th index");
	}
	private static int linearSearch(int[] a, int key)
	{
		for(int i=0;i<a.length;i++) 
		{
			if(key==a[i])
				return i;
		}
		return -1;
	}
}
