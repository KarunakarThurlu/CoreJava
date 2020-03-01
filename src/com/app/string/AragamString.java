package com.app.string;

import java.util.Arrays;

public class AragamString {
	public static void main(String[] args) {
		checkForAragamString("Mother In Law","Hitler Woman");
		checkForAragamString("keep","Peek");
	}
	public static void checkForAragamString(String str1,String str2) {
		//===Removing White Spaces in Given Strings
		
		String s1=str1.replaceAll("\\s","");
		String s2=str2.replaceAll("\\s","");

		//===Converting into Character Arrays
		
		char c1[]=s1.toLowerCase().toCharArray();
		char c2[]=s2.toLowerCase().toCharArray();

		//===Sorting Character Arrays
		
		Arrays.sort(c1);
		Arrays.sort(c2);

		boolean isAragam=true;

		if(c1.length!=c2.length) {
			isAragam=false;
		}else {
			for(int i=0;i<c1.length;i++) {
				if(c1[i]!=c2[i]) {
					isAragam=false;
				}
			}
		}
		System.out.println(str1+" "+str2+" are Aragam  "+isAragam );
	}
}
