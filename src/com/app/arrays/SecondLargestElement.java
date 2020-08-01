package com.app.arrays;

import java.util.Arrays;

public class SecondLargestElement {

	public static void main(String[] args) {
		int a[]= {99,2,4,8,10,1,18,19,98};
		System.out.println(findSecondLorgest(a));
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
	}
	private static int findSecondLorgest(int[] input) {
		int first =input[0];
		int second=input[1];
		for(int i=2;i<input.length;i++) {
			if(input[i]>first) {
				second=first;
				first=input[i];
			}else if(input[i]<first && input[i]>second) {
				second=input[i];
			}
		}
		return second;
	}
}
