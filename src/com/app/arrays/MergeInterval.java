package com.app.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
	public static int[][] mergeInterVal(int[][] a) {
		Arrays.sort(a,(b,c)->Integer.compare(b[0], c[0]));
		List<int[]> list=new ArrayList<>();
		int[] prev=a[0];
		list.add(prev);
		for(int[] curr :a) {
			int pe=prev[1];
			int cs=curr[0];
			int ce=curr[1];
			if(cs<=pe) {
				prev[1]=Math.max(pe, ce);
			}else {
				prev=curr;
				list.add(curr);	
			}
		}
		return list.toArray(new int[list.size()][]);
	}
	public static void main(String[] args) {
		int[][] res=mergeInterVal(new int[][] {
			{1,3},{2,6},{8,10},{15,18}
		});
		for(int[] a:res) {
			System.out.println(Arrays.toString(a));
		}
	}
}
