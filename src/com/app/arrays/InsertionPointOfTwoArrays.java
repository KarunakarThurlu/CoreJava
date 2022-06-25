package com.app.arrays;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InsertionPointOfTwoArrays {
	private static final Logger logger=System.getLogger(InsertionPointOfTwoArrays.class.getName());
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		logger.log(Level.INFO,Arrays.toString(intersect(nums1,nums2)));
		logger.log(Level.INFO, Integer.MAX_VALUE);
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list=new ArrayList<>();
		Arrays.sort(nums2);
		int i=0;
		int j=0;
		while(i<nums1.length && j<nums2.length){
			if(nums1[i]==nums2[j]){
				list.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i]<nums2[j]) {
				i++;
			}else {
				j++;
			}
		}
		int[] a=new int[list.size()];
		for(int k=0;k<list.size();k++) {
			a[k]=list.get(k);
		}
		return a;
	}
}
