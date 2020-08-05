package com.app.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,3,2,1,23,345,56,67,9};
		//itearting array eleemts 
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
		System.out.println();
		//removing duplicates in an array
		Arrays.stream(a).distinct().forEach(s->System.out.print(s+" "));
		System.out.println();
	}
}
