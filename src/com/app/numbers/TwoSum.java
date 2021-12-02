package com.app.numbers;

import java.util.Arrays;

public class TwoSum {

	//Here Time Complexity is O(n^2)
	public static int[] twoSum(int nums[],int target) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++)
			for(int j=i+1;j<nums.length;j++)
				if(nums[j]+nums[i]==target)
					return new int[] {i,j};
		return  new int[] {};
	}

	//Here Time Complexity O(log(n))
	public static int[] getTwoSum(int nums[],int target) {
		Arrays.sort(nums);
		int start=0;
		int end=nums.length-1;
		while(start<end) {
			int sum=nums[start] + nums[end];
			if(target==sum)
				return new int[] {start,end};
			else if(sum<target)
				start++;
			else 
				end--;
		}
		return new int[] {};
	}


	public static void main(String[] args) {
		int a[]=twoSum(new int[] {1,1,5,9,7,5},10);
		Arrays.stream(a).forEach(s->System.out.print(s+" "));

		System.out.println();

		int b[]=getTwoSum(new int[] {1,1,5,9,7,5},10);
		Arrays.stream(b).forEach(s->System.out.print(s+" "));
	}
}
