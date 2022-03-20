package com.app.arrays;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayExample {

	private static final Logger  loggger = System.getLogger(ArrayExample.class.getName());

	public static void main(String[] args) {
		/*
		 * An Array is indexed collection of fixed number of homogeneous elements
		 * 1. We can store Homogeneous elements 
		 * 2. Fixed size 
		 * 3. Every array in java is an object
		 * 
		 * int[] a; Valid 
		 * int a[]; Valid 
		 * int []a; Valid
		 * 
		 * int a[];        Valid 
		 * int[3] a;       Invalid 
		 * int[] []a.b[];  Invalid 
		 * int[][] a[],b;  Valid
		 * 
		 * int a[]=new int[0]; a[0]=10; CE:ArrayIndexOutofboundException
		 * 
		 *
		 * int a[]=new int[-2];
		 * System.out.println(a);
		 * CE:java.lang.NegativeArraySizeException at Runtime
		 * 
		 * 
		 * To represent array size allowed values byte,shot,int,char remainir i.e float,double,long not allowed
		 */

		int a[] = { 3, 2, 4, 55, 78, 67, -9 };
		reverseArray(a);
		sortArray(a);
		twoSum(a,82);

	}

	/**
	 * Reverse given array elements
	 * @param a
	 */
	public static void reverseArray(int[] a) {
		loggger.log(Level.INFO, "Before reverse : {0}", Arrays.toString(a));
		for(int i=0;i<a.length/2;i++) {
			int temp = a[i];
			a[i]=a[a.length-(i+1)];
			a[a.length-(i+1)]=temp;
		}
		loggger.log(Level.INFO, "After reverse : {0}", Arrays.toString(a));
	}

	/**
	 * Sort given array elements
	 * @param a
	 */
	public static void sortArray(int[] a) {
		loggger.log(Level.INFO, "Before sort : {0}", Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		loggger.log(Level.INFO, "After sort  : {0}", Arrays.toString(a));
	}
	
	/**
	 * 
	 * @param a
	 * @param target
	 */
	public static void twoSum(int[] a,int target) {

		Map<Integer, Integer> map = new HashMap<>();
		Arrays.stream(a).forEach(e->map.put(e,e));
		for(int i=0;i<a.length;i++) {
			int rem = target-a[i];
			if(map.containsKey(rem)) {
				loggger.log(Level.INFO, "Indexs  : {0} {1}");
			}
		}
	}

}
