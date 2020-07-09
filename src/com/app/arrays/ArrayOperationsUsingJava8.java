package com.app.arrays;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class ArrayOperationsUsingJava8 {

	public static void main(String[] args) {


		int arr[]= {1,3,2,4,6,5,8,9,12,45,56,67,899};
		Arrays.stream(arr).sorted().forEach(s->System.out.print(s+" "));System.out.println();
		Arrays.stream(arr).max().ifPresent(s->System.out.println(s));
		Arrays.stream(arr).filter(s->s>10).forEach(s->System.out.print(s+" "));System.out.println();
		Arrays.stream(arr).findFirst().ifPresent((s->System.out.println(s)));
		IntSummaryStatistics statics=Arrays.stream(arr).summaryStatistics();
		System.out.println("==="+statics+"===");


		int a[]= {2,3,4,5,6,7};
		int b[]= {2,3,4,5,6,7};
		System.out.println(Arrays.equals(a, b));
		
		int result[]=IntStream.range(0, a.length).map(i->a[i]*b[i]).toArray();
		
		Arrays.stream(result).forEach(s->System.out.print(s+" "));
		
		int[] d= {7,4,3,4,6,1,7};
		int c[]=Arrays.stream(a).distinct().toArray();
		Arrays.stream(c).forEach(s->System.out.print(s+" "));
		System.out.println();



	}
}
