package com.app.arrays;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class MaxSumArray {
	
    private static final Logger logger = System.getLogger(MaxSumArray.class.getName());

	public static void main(String[] args) {
		Integer[]  array = {-2, -3, 4, -1, -2, 1, 5, -3};
		logger.log(Level.INFO, findMaxSum(array));
	}
	
	public static  Integer findMaxSum(Integer[] array) {
		Integer max=Integer.MIN_VALUE;
		Integer sum=0;
		for(int i=0;i<array.length;i++) {
			sum=sum+array[i];
			if(max<sum)
				max=sum;
			if(sum<0){
				sum=0;
			}
		}
		return max;
	}
}
