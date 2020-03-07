package com.app.arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class ArrayOperationsUsingJava8 {

	public static void main(String[] args) {


		int arr[]= {1,3,2,4,6,5,8,9,12,45,56,67,899};
		Arrays.stream(arr).sorted().forEach(s->System.out.print(s+" "));System.out.println();
		Arrays.stream(arr).max().stream().forEach(s->System.out.println(s));
		Arrays.stream(arr).filter(s->s>10).forEach(s->System.out.print(s+" "));System.out.println();
		Arrays.stream(arr).findFirst().stream().forEach(s->System.out.println(s));
		IntSummaryStatistics statics=Arrays.stream(arr).summaryStatistics();
		System.out.println("==="+statics+"===");


		int a[]= {2,3,4,5,6,7};
		int b[]= {2,3,4,5,6,7};
		int result[]=IntStream.range(0, a.length).map(i->a[i]*b[i]).toArray();
		Arrays.stream(result).forEach(s->System.out.print(s+" "));



	}
}
