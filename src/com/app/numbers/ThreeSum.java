package com.app.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum{
	List<List<Integer>> findThreeSum(int[] nums){
		checkingConstraints(nums);
		List<List<Integer>> result=new ArrayList<>();
		if(nums.length<3)
			return result;
		Arrays.sort(nums);
		Integer target=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>target)
				break;
			if(i>0 && nums[i]==nums[i-1])
				continue;
			Integer j=i+1;
			Integer k=nums.length-1;
			while(j<k) {
				Integer sum=nums[i]+nums[j]+nums[k];
				if(sum==target) {
					List<Integer> l=new ArrayList<>();
					l.add(nums[i]);l.add(nums[j]);l.add(nums[k]);
					result.add(l);
					while(nums[j]==nums[j+1])
						j++;
					while(nums[k]==nums[k-1])
						k--;
					j++;
					k--;
				}else if(sum<target) {
					j++;
				}else {
					k--;
				}
			}
		}
		return result;
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
