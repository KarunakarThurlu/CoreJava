package com.app.arrays;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
		//reverseArray(a);
		//sortArray(a);
		//twoSumii(a,82);
		//rotateArray(a,2);
		//threeSum(new int[]  {-1,0,1,2,-1,-4});
		//productArrayExceptItselfint(new int[] {2,3,1,4});
		//minChangeToSortArray(new int[]{4,2,1});
		//medianOfTwoSortedArrays(new int[] {1,2},new int[] {3,4});
		//bestToBuyStock(new int[]{7,1,5,3,6,4});
		containerWithWater(new int[] {1,8,6,2,5,4,8,3,7});
	}
	
	public static void containerWithWater(int[] a) {
		int i=0;
		int j=a.length-1;
		int maxArea=0;
		while(i<j) {
			int area=0;
			if(a[i]>a[j]) {
				area=(j-i)*a[j--];
			}else {
				area=(j-i)*a[i++];
			}
			if(maxArea<area) {
				maxArea=area;
			}
		}
		loggger.log(Level.INFO, "Max Area  :{0} ",maxArea);
	}
	public static void bestToBuyStock(int[] array) {
		int min=array[0];
		int max=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]<min)
				min=array[i];
			if(max<array[i]-min)
				max=array[i]-min;
		}
		loggger.log(Level.INFO, "Max stock price :{0}",max);
	}
	/**
	 * Find median of two sorted arrays
	 * @param a1
	 * @param a2
	 */
	public static void medianOfTwoSortedArrays(int[] a1,int[] a2) {
		int size=a1.length+a2.length;
		double[] d=new double[size];
		int i=0;
		int j=0;
		int k=0;
		while(i<a1.length && j<a2.length) {
			if(a1[i]<=a2[j]) {
				d[k++]=a1[i++];
			}else {
				d[k++]=a2[j++];
			}
		}
		while(i<a1.length ) {
			d[k++]=a1[i++];
		}
		while(j<a2.length) {
			d[k++]=a2[j++];
		}
		int mid=d.length/2;
		if(d.length%2!=0) {
			loggger.log(Level.INFO, "Median :{0}",d[mid]);
		}else {
			loggger.log(Level.INFO, "Median : {0}",(d[mid]+d[mid-1])/2);
		}
		
	}
	/**
	 * Minimum changes to sort array
	 * @param array
	 */
	public static void minChangeToSortArray(int[] array) {
		int count =0;
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1]) {
				count++;
				if(i==0 || array[i+1]>=array[i-1])
					array[i]=array[i+1];
				else
					array[i+1]=array[i];
			}
			if(count>1) {
				loggger.log(Level.INFO, "Can we make one to change to sorted array : False");
				break;
			}
			
		}
		loggger.log(Level.INFO, "Can we make one to change to sorted array : True");
	}
	/**
	 * Find max Sub array sum
	 * @param array
	 */
	public static void maxSubArraySum(int[] array) {
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum=sum+array[i];
			if(max<sum)
				max=sum;
			if(sum<0)
				sum=0;
		}
		loggger.log(Level.INFO, "Max sum is  : {0}", max);
	}

	/**
	 * Product Array Elements except itself
	 * @param array
	 */
	public static void productArrayExceptItselfint(int[] array) {
		int pre=1;
		int[] a=new int[array.length];
		for(int i=0;i<array.length;i++) {
			a[i]=pre;
			pre=pre*array[i];
		}
		int post=1;
		for(int i=array.length-1;i>=0;i--) {
			a[i]=a[i]*post;
			post=post*array[i];
		}
		loggger.log(Level.INFO, "Product elements {0} ",Arrays.toString(a));
	}
	/**
	 * 
	 * @param array
	 */
	public static void threeSum(int[] array) {
		List<List<Integer>> list=new ArrayList<>();
		if(array.length<3)
			loggger.log(Level.INFO, "Must be > 3 elements");
		int target=0;
		Arrays.sort(array);
		for(int i=0;i<array.length;i++) {
			if(i>0 && array[i]==array[i-1])
				continue;
			int j=i+1;
			int k=array.length-1;

			while(j<k) {
				int sum=array[i]+array[j]+array[k];
				if(sum==target) {
					list.add(Arrays.asList(array[i],array[j],array[k]));
					while(array[j]==array[j+1])
						j++;
					while(array[k]==array[k-1])
						k--;
					j++;
					k--;
				}else if(array[j]<array[k]){
					j++;
				}else {
					k--;
				}
			}
		}
		loggger.log(Level.INFO, "ThreeSum  : {0}",list); 
	}
	/**
	 * Find Two Sum
	 * @param array
	 * @param target
	 */
	public static void twoSumii(int[] array,int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<array.length;i++) {
			if(map.containsKey(target-array[i])) {
				loggger.log(Level.INFO, "Two Sum : {0} {1}", i,map.get(target-array[i]));
			}else {
				map.put(array[i], i);
			}
		}
	}
	/**
	 * Rotate Array
	 * @param array
	 * @param rotationCount
	 */
	public static void rotateArray(int[] array,int rotationCount) {
		loggger.log(Level.INFO, "Before Rotate : {0}", Arrays.toString(array));
		for(int i=0;i<rotationCount;i++) {
			int x=array[array.length-1];
			for(int j=array.length-1;j>0;j--) {
				array[j]=array[j-1];
			}
			array[0]=x;
		}
		loggger.log(Level.INFO, "After Rotate : {0}", Arrays.toString(array));
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
				loggger.log(Level.INFO, "Elements  : {0} {1}",a[i],rem);
			}
		}
	}

}
