package com.app.arrays;

import java.util.Arrays;

public class MergingOfTwoSortedArrays 
{
	public static void main(String[] args) 
	{
		int a1[]= {12,45,78,90};
		int a2[]= {1,10,13,80,100,120};
		int a3[]=new int[a1.length+a2.length];
		new MergingOfTwoSortedArrays().merge(a1,a2,a3);
		Arrays.stream(a3).forEach(s->System.out.print(s+" "));
	}
	private void merge(int[] a1, int[] a2, int[] a3) 
	{
		int i=0,j=0,k=0;
		while(i<a1.length && j<a2.length) 
		{
			if(a1[i]<a2[j]) 
				a3[k++]=a1[i++];
			else 
				a3[k++]=a2[j++];
		}
		for(;i<a1.length;i++)
			a3[k++]=a1[i];
		for(;j<a2.length;j++)
			a3[k++]=a2[j];

	}
}
