package com.app.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int a[]= {2,3,4,57,54,2,57,56,3};
		//itearting array eleemts 
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
		System.out.println();
		//removing duplicates in an array
		Arrays.stream(a).distinct().forEach(System.out::println);
	}
}
