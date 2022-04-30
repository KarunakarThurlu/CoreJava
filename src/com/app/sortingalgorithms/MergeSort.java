package com.app.sortingalgorithms;

import java.lang.System.Logger.Level;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	/*
	 * MergeSort: TimeComplexity           BestCase              AverageCase            WorestCase
	 *                                     
	 *                                     O(nlogn)               O(nlogn)               O(nlogn)
	 * 
	 * 
	 * 
	 */
	
	private static final System.Logger logger = System.getLogger(MergeSort.class.getName());
	
	public static void main(String[] args) {
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++) {
			array[i] =  new Random().nextInt(1000);
		}
		logger.log(Level.INFO,"Before Sorting Array : {0}", Arrays.toString(array));
		mergeSort(array);
		logger.log(Level.INFO,"After Sorting Array : {0}", Arrays.toString(array));
	}
	public static void mergeSort(int[] inputArray){
		if(inputArray.length <= 1){
			return;
		}
		int mid = inputArray.length/2;
		int[] leftArray = Arrays.copyOfRange(inputArray, 0, mid);
		int[] rightArray = Arrays.copyOfRange(inputArray, mid, inputArray.length);
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, inputArray);
	}

	public static void merge(int[] leftArray, int[] rightArray, int[] inputArray){
		int leftArrayIndex = 0;
		int rightArrayIndex = 0;
		int inputArrayIndex = 0;
		while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length){
			if(leftArray[leftArrayIndex] < rightArray[rightArrayIndex]){
				inputArray[inputArrayIndex++] = leftArray[leftArrayIndex++];
			}else{
				inputArray[inputArrayIndex++] = rightArray[rightArrayIndex++];
			}
		}
		while(leftArrayIndex < leftArray.length){
			inputArray[inputArrayIndex++] = leftArray[leftArrayIndex++];
		}
		while(rightArrayIndex < rightArray.length){
			inputArray[inputArrayIndex++] = rightArray[rightArrayIndex++];
		}
	}
}
