package com.app.sortingalgorithms;

import java.util.Arrays;

public class QuickSort  {
	
	/*
	 * QuickSort: TimeComplexity                Best Case                  Average Case               Worest Case
	 *         
	 *                                          O(nlogn)                   O(nlogn)                   O(n^2)
	 * 
	 * 
	 * Note:-
	 *       It is recomended to take 'pivot element' as middle element or random element, why B'z if elements are already  sorted (or) not sorted ,then time complexity is always O(nlogn) that is best case.
	 *       
	 */
	int arr[];
	int length;
	public static void main(String[] args) {
		int arr[]= {23,34,56,1,10,100,-10,89};
		Arrays.stream(arr).forEach(s->System.out.print(s+ " "));
		QuickSort q=new QuickSort();
		q.sort(arr);
		System.out.println();
		Arrays.stream(arr).forEach(s->System.out.print(s+ " "));

	}

	private void sort(int[] array) {
		this.arr=array;
		quickSort(0,arr.length-1);
	}

	private void quickSort(int left, int right) {
		int i=left;int j=right;
		int pivot=arr[(right+left)/2];
		while(i<=j) {
			while(arr[i]<pivot)
				i=i+1;
			while(arr[j]>pivot)
				j=j-1;
			if(i<=j) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i=i+1;
				j=j-1;
			}
		}
		if(left<j)
			quickSort(left, j);
		if(i<right)
			quickSort(i, right);

	}
}