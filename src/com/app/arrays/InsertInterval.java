package com.app.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
	public static int[][] insertInterval(int[][] a,int[] b){
		List<int[]> list=new ArrayList<>();
		int[] temp=b;
		for(int i=0;i<a.length;i++) {
			if(temp[0]>a[i][1]) {
				list.add(a[i]);
			}else if(a[i][0]>temp[1]) {
				list.add(temp);
				temp=a[i];
			}else {
				temp[0]=Math.min(temp[0], a[i][0]);
				temp[1]=Math.max(temp[1], a[i][1]);
			}
		}
		list.add(temp);
		return list.toArray(new int[list.size()][2]);
	}
	public static void main(String[] args) {
		int[][] res=insertInterval(new int[][] {
			{1,3},{6,9}
		},new int[]{2,5});
		for(int[] a:res) {
			System.out.println(Arrays.toString(a));
		}
	}
}
