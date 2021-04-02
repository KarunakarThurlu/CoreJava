package com.app.arrays;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class ArrayExample {

	public static void main(String[] args) {
		/*
		 * "An Array is indexed collection of fixed number of homogeneous elements" 1.
		 * We can store Homogeneous elements 2. Fixed size 3. Every array in java is an
		 * object
		 * 
		 * int[] a; Valid int a[]; Valid int []a; Valid
		 * 
		 * int a[]; Valid int[3] a; Invalid int[] []a.b[];Invalid int[][] a[],b;Valid
		 * 
		 * 
		 * int a[]=new int[0]; a[0]=10; CE:ArrayIndexOutofboundException
		 * 
		 *
		 * int a[]=new int[-2]; System.out.println(a);
		 * CE:java.lang.NegativeArraySizeException at Runtime
		 * 
		 * 
		 * To reprasent array size allowed values byte,shot,int,char remainir i.e
		 * float,double,long not allowed
		 */

		int a[] = { 3, 2, 4, 55, 78, 67, -9 };

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}
}
