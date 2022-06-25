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

		
		Integer[] result=rotate(arrayOne,1);
		loggger.log(Level.INFO,"Solution One :"+ Arrays.toString(result));
		
	}
	public static Integer[] rotate(Integer[] a,int rotationCount) {
		for(int i=0;i<rotationCount;i++) {
			int x=a[a.length-1];
			for(int k=a.length-1;k>0;k--) {
				a[k]=a[k-1];
			}
			a[0]=x;
		}
		return a;
	}

}
