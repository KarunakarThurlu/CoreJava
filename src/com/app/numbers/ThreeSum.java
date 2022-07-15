package com.app.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ThreeSum{
	List<List<Integer>> findThreeSum(int[] nums){
		checkingConstraints(nums);
		Set<List<Integer>> list=new HashSet<>();
		
		for(int i=0;i<nums.length;i++) {
			int j=i+1;
			int k=nums.length-1;
			while(j<k) {
				int sum=nums[i]+nums[j]+nums[k];
				if(sum==0)
					list.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
				if(sum<0)
					j++;
				if(sum>0)
					k--;
			}
		}
		
		System.out.println(list);
		return new ArrayList<>(list);
	}
	public void checkingConstraints(int nums[]) {
		if(!(0<=nums.length && nums.length<=3000)) {
			throw new RuntimeException("Input Array Length Exceeds!");
		}
		for(int i=0;i<nums.length;i++) {
			if(-105>nums[i]) {
				throw new RuntimeException("Least value will be : -105 but found : "+nums[i]);
			}
			if(nums[i]>105) {
				throw new RuntimeException("Max value will be : 105 but found : "+nums[i]);
			}
		}
	}
}
