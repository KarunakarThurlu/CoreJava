package com.app.numbers;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	private static Logger logger = System.getLogger(TwoSum.class.getName());
	
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSumSolutionOne(int[] nums,int target) {
		
		for(int i=0;i<nums.length;i++)
			for(int j=i+1;j<nums.length;j++)
				if(nums[j]+nums[i]==target)
					return new int[] {i,j};
		return  new int[] {};
	}

	/**
	 * 
	 * @param a
	 * @param target
	 * @return
	 */
	public static int[] twoSumSolutionTwo(int[] a,int target) {
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.stream(a).forEach(e->map.put(e,e));
		
		for(int i=0;i<a.length;i++) {
			int remaining = target-a[i];
			if(map.containsKey(remaining)) {
				return new int[] {a[i],remaining};
			}
		}
		return new int[0];
	}
	
	
	public static void main(String[] args) {
		int[] inputArray= {1,11,5,9,7,5};
		
		int[]  a = twoSumSolutionOne(inputArray,10);
		logger.log(Level.INFO,Arrays.toString(a));
		
		int[]  b =  twoSumSolutionTwo(inputArray,10);
		logger.log(Level.INFO,Arrays.toString(b));
		
	}
}
