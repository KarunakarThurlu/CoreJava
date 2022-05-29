package com.app.arrays;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;

public class RemoveDuplicates {
	
	private static final Logger  logger = System.getLogger(RemoveDuplicates.class.getName());
	
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,3,2,1,23,345,56,67,9};
		
		logger.log(Level.INFO, Arrays.toString(a));
		
		int[] b=Arrays.stream(a).distinct().toArray();
		
		logger.log(Level.INFO, Arrays.toString(b));
	}
}
