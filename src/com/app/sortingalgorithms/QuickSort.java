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
	public static void main(String[] args) {
		int arr[]= {23,45,1,-2,-10,3,67,890,67,100,12,11,13};  
		Arrays.stream(arr).forEach(s->System.out.print(s+ " "));
		QuickSort q=new QuickSort();
		q.quickSort(arr,0,arr.length-1);
		System.out.println();
		Arrays.stream(arr).forEach(s->System.out.print(s+ " "));

	}
	private void quickSort(int arr[],int left, int right) {
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
			quickSort(arr,left, j);
		if(i<right)
			quickSort(arr,i, right);
	}
}