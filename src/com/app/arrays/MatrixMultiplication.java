package com.app.arrays;

public class MatrixMultiplication {
	public static void main(String[] args) {
		int a[][]= {{1,1,1},{2,2,2},{2,2,2}};
		int b[][]= {{1,1,1},{2,2,2},{2,2,2}};
		int c[][]=new int[3][3];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				for(int k=0;k<a.length;k++)
				{
					c[i][j]+=a[i][k]*b[k][j];
				}
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}
