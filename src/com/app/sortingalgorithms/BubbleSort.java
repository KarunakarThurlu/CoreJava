package com.app.sortingalgorithms;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;

public class BubbleSort
{ 
	 private static final Logger logger = System.getLogger(BubbleSort.class.getName());
	
	/*
	 * BubbleSort: TimeComplexity                Best Case                  Average Case               Worest Case
	 *         
	 *                                            O(n)                      O(n^2)                      O(n^2)
	 * 
	 */
	public static void main(String[] args) 
	{
		int[] a= {1,2,3,4,5,6,7,10,15,19};
		logger.log(Level.INFO,"Before sorting ");
		logger.log(Level.INFO,Arrays.toString(a));
		
		new BubbleSort().sort(a);

		logger.log(Level.INFO,Arrays.toString(a));
		
	}

	private void sort(int[] a)
	{
		int count =0 ;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-1;j++){
				if(a[j]>a[j+1]) {
				  int temp =a[j];
				  a[j]=a[j+1];
				  a[j+1]=temp;
				  count=count+1;
				}
			}
			if(count==0){
				break;
			}
		}
		logger.log(Level.INFO, "Swap Count is :{0}",count);
	}
}
