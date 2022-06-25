package com.app.arrays;

public class MinChangesToSort {
	public static void main(String[] args) {
		int[] a= {4,2,3};
		System.out.println(doCheck(a));
	}
	
	public static  Boolean doCheck(int[] a) {
		int count=0;
		for(int i=0;i<a.length-1;i++) {
			if(a[i]<a[i+1]) {
				count++;
			}
			if(count>1)
				return false;
		}
		if(count==0)
			return true;
		else
			return false;
	}
}
