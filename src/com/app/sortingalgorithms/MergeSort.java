package com.app.sortingalgorithms;

import java.util.Arrays;

public class MergeSort {
	/*
	 * MergeSort: TimeComplexity           BestCase              AverageCase            WorestCase
	 *                                     
	 *                                     O(nlogn)               O(nlogn)               O(nlogn)
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int a[] = { 10, 50, -11, 12, 45, 67, 20, 60, 30 };
		System.out.println("Before sorting ");
		Arrays.stream(a).forEach(s -> System.out.print(s + " "));
		System.out.println();

		new MergeSort().divideSubArrays(a, a.length);

		System.out.println("After sorting ");
		Arrays.stream(a).forEach(s -> System.out.print(s + " "));
	}

	private void divideSubArrays(int[] arr, int length) {
		if (length < 2)
			return;
		int mid = length / 2;
		int left_arr[] = new int[mid];
		int right_arr[] = new int[length - mid];
		int k = 0;
		for (int l = 0; l < length; l++) {
			if (l < mid) {
				left_arr[l] = arr[l];
			} else {
				right_arr[k] = arr[l];
				k++;
			}
		}
		divideSubArrays(left_arr, mid);
		divideSubArrays(right_arr, length - mid);
		merge(left_arr, right_arr, arr, mid, length - mid);
	}

	private void merge(int[] left_arr, int[] right_arr, int[] a, int left_size, int right_size) {
		int l = 0, r = 0, i = 0;
		while (l < left_size && r < right_size) {
			if (left_arr[l] < right_arr[r])
				a[i++] = left_arr[l++];
			else
				a[i++] = right_arr[r++];
		}
		while (l < left_size)
			a[i++] = left_arr[l++];
		while (r < right_size)
			a[i++] = right_arr[r++];

	}
}
