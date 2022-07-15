package com.app.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static void spiralMatrx(int[][] a) {
		List<Integer> list=new ArrayList<>();
		int colBegin=0;
		int rowBegin=0;
		int colEnd=a[0].length-1;
		int rowEnd=a.length-1;
		while(colBegin<=colEnd && rowBegin<=rowEnd) {
			for(int i=colBegin;i<=colEnd;i++) {
				list.add(a[rowBegin][i]);
			}
			rowBegin++;
			
			for(int j=rowBegin;j<=rowEnd;j++) {
				list.add(a[j][colEnd]);
			}
			colEnd--;
			
			if(rowBegin<=rowEnd) {
				for(int i=colEnd;i>=colBegin;i--) {
					list.add(a[rowEnd][i]);
				}
			}
			rowEnd--;
			if(colBegin<=colEnd) {
				for(int j=rowEnd;j>=rowBegin;j--) {
					list.add(a[j][colBegin]);
				}
			}
			colBegin++;
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		spiralMatrx(new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		});
	}
}
