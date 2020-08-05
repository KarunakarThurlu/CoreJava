package com.app.numbers;

import java.util.Arrays;

public class TwoSum {
	 public static int[] twoSum(int nums[],int target) {
		 int result;
		 for(int i=0;i<nums.length;i++) {
			 result=target-nums[i];
			 for(int j=0;j<nums.length;j++) {
				 if(i==j)
					 continue;
				 else {
					 if(nums[j]==result)
						 return new int[] {i,j};
				 }
			 }
		 }
		 
		return nums;
	 }
	
	public static void main(String[] args) {
		int a[]=twoSum(new int[] {1,1,5,9,7,5},10);
		Arrays.stream(a).forEach(k->System.out.println(k));;
		
	}

}
