package com.app.arrays;

import java.lang.System.Logger.Level;
import java.util.Arrays;

public class RotatingArrayElements {

	private static final System.Logger loggger = System.getLogger(RotatingArrayElements.class.getName());

	/* 
	 Problem Statement : Rotate an array of n elements to the right by k steps. 
	 Example           : For example, with n= 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
	*/
	public static void main(String[] args) {
		Integer[] arrayOne = {1,2,3,4,5,6,7};
		Integer[] arrayTwo = {1,2,3,4,5,6,7};

		Integer[] resultOne = rotatingArraySolutionOne(arrayOne, 3);
		Integer[] resultTwo = rotatingArraySolutionTwo(arrayTwo, 3);

		loggger.log(Level.INFO,"Solution One :"+ Arrays.toString(resultOne));
		loggger.log(Level.INFO,"Solution Two :"+ Arrays.toString(resultTwo));
	}


	/*======================Space Complexity==============Time Complexity=========
	                             O(1)                          O(n)               */
	public static Integer[] rotatingArraySolutionOne(Integer[] array,Integer rotationCount) {
		Integer temp=array.length-rotationCount;
		doSwaping(array,0,temp-1);
		doSwaping(array,temp , array.length-1);
		doSwaping(array, 0, array.length-1);
		return array;
	}

	private static void doSwaping(Integer[] array, int left, int right) {
		while(left<right) {
			int temp = array[right];
			array[right]=array[left];
			array[left]=temp;
			left++;
			right--;
		}
	}


	/*======================Space Complexity==============Time Complexity=========
    							 O(n)                          O(n)               */
	public static Integer[] rotatingArraySolutionTwo(Integer[] array,Integer rotationCount) {
		
		if(rotationCount>array.length)
			rotationCount = rotationCount%array.length;
		
		Integer[] result = new Integer[array.length];

		for (int i = 0; i < rotationCount; i++) {
			result[i]=array[array.length-rotationCount+i];
		}

		for (int i = rotationCount,k=0; i < array.length; i++,k++) {
			result[i]=array[k];
		}

		return result;
	}
}
