package com.app.datastructuresandalgorithams;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Arrays;

public class RecursionExample {

	private static final Logger logger = System.getLogger(RecursionExample.class.getName());

	public static void main(String... recursionExample) {
		int[] a = {70,20,90,40,190,60,10,80,30,100,130,150,50};
		quickSort(a,0,a.length-1);
		logger.log(Level.INFO, "Sorting Array Elements using QuickSort : {0}",Arrays.toString(a));
		logger.log(Level.INFO, "Element 50 is  present at index : {0} ",binarySearch(a,0,a.length-1,50));
		logger.log(Level.INFO, "Factorial of 5 is {0} ",factorialOfNumer(5));
		logger.log(Level.INFO, "Sum of first 5  numbers is {0} ",printSumOfFirstNnumbers(5));
		logger.log(Level.INFO, "Reverse Karunakar  : {0} ",getReverseString("Karunakar"));
		logger.log(Level.INFO, "KAYAK is palindrome : {0}",isPalindrome("KAYAK"));
		printFirstNFibonaciNumbers(5);
		permutationOfString("ABC","");
	}

	/**
	 * Print first n natural using recursion
	 * @param n
	 */
	public static void printFristNnumbers(Integer n) {
		if(n>=6) 
			return;
		logger.log(Level.INFO,n);
		printFristNnumbers(n+1);
	}
    
	/**
	 * Get reversed string
	 * @param inputstring
	 * @return
	 */
	public static String getReverseString(String inputstring) {
		if(inputstring.equals(""))
			return "";
		return getReverseString(inputstring.substring(1))+inputstring.charAt(0);
	}
	
	/**
	 * Finding given string is Palindrome 
	 * @param str
	 * @return
	 */
	public static Boolean isPalindrome(String str) {
		if(str.length()==1 || str.equals(""))
			return true;
		else
			if(str.charAt(0)==str.charAt(str.length()-1)) 
				return isPalindrome(str.substring(1,str.length()-1));
		return false;
	}
	
	/**
	 * Print Sum of first n numbers sum
	 * @param n
	 */
	public static Integer printSumOfFirstNnumbers(Integer n) {
		if(n==0)
			return 0;
		else
			return n+printSumOfFirstNnumbers(n-1);
	}
	/**
	 * Finding Factorial of given number
	 * @param n
	 * @return
	 */
	public static Integer factorialOfNumer(Integer n) {
		if(n==1)
			return 1;
		return n*factorialOfNumer(n-1);
	}

	/**
	 * Print First n Fibonaci numbers
	 * @param n 
	 */
	public static Integer printFirstNFibonaciNumbers(Integer n) {
		if(n==0)
			return 0;
		if(n==1 || n==2)
			return 1;
		else
			return printFirstNFibonaciNumbers(n-1)+printFirstNFibonaciNumbers(n-2);
	}

	/**
	 * Find element index using Binary Search
	 * @param array
	 * @param left
	 * @param right
	 * @param key
	 * @return
	 */
	private static int binarySearch(int[] array, int left, int right,int key) {
		int mid = (left+right)/2;
		if(left>right)
			return -1;
		if(array[mid]==key)
			return mid;
		else if(array[mid]>key)
			right=mid-1;
		else
			left=mid+1;
		return binarySearch(array,left,right,key);
	}

	/**
	 * Finding permutation of given string
	 * @param src
	 * @param permutation
	 */
	public static void permutationOfString(String src,String permutation) {
		if(src.isEmpty())
			logger.log(Level.INFO, permutation);
		else
			for(int i=0;i<src.length();i++){
				Character currentChar = src.charAt(i);
				String newString = src.substring(0,i)+src.substring(i+1);
				permutationOfString(newString,permutation+currentChar);
			}
	}
	
	/**
	 * Sort given array using QuickSort
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] array,int left,int right) {
		int i=left;
		int j=right;
		int pivot=array[(left+right)/2];
		while(i<=j) {
			while(array[i]<pivot)
				i++;
			while(array[j]>pivot)
				j--;
			if(i<=j) {
				int temp = array[i];
				array[i] = array[j];
				array[j]=temp;
				i++;
				j--;
			}
		}
		if(left<j)
			quickSort(array,left,j);
		if(i<right)
			quickSort(array,i,right);
	}

}
