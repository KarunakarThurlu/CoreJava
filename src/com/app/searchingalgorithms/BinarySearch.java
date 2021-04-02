package com.app.searchingalgorithms;
public class BinarySearch {
	static int binary(int key, int a[]) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == a[mid]) {
				return mid;
			} else if (key < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int a[] = { 23, 34, 45, 56, 67, 89, 90, 99, 100, 120 };
		System.out.println(binary(120, a));
	}
}
