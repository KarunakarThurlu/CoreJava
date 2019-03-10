package com.app.arrays;

public class TransPoseofMatrix {
	public static void main(String[] args) {
		int a[][]= {{1,3,7},{8,2,9},{5,2,6}};
		System.out.println("original matrix is :");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Transpose of Matrix is :");
		int b[][]=new int[3][3];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				b[j][i]=a[i][j];
			}
		}
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
