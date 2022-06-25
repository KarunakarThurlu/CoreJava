package com.app.string;

import java.lang.System.Logger;

public class LongestPalindromeSubString {

	private static final Logger  loggger = System.getLogger(LongestPalindromeSubString.class.getName());

	private static int maxLength=0;
	private static int startAt=0;

	public static void main(String[] args) {
		String s="babad";
		for(int i=0;i<s.length();++i) {
			expolre(s,i,i);
			expolre(s,i,i+1);
		}
		System.out.println(s.substring(startAt,maxLength+startAt));
	}
	public static void expolre(String s,int l,int r) {
		while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
			l--;
			r++;
		}
		if(maxLength<r-l-1) {
			maxLength=r-l-1;
			startAt=l+1;
		}	
	}
}
