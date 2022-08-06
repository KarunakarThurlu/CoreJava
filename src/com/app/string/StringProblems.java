package com.app.string;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringProblems {
	
	private static final Logger  loggger = System.getLogger(StringProblems.class.getName());

	public static void main(String[] args) {
		loggger.log(Level.INFO,longestSubStringWithOutRepetingCharacters("pwwkew"));
		loggger.log(Level.INFO,longestPalindromeSubString("babad"));//generateParanhtasis
		loggger.log(Level.INFO,generateParanhtasis(3));
		reverseStringBylevel("Karunakarthurlu",3);
	}
	
	public static void reverseStringBylevel(String str,Integer n) {
		loggger.log(Level.INFO,"Before Reverse : {0}",str);
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i=i+n) {
			int l=i;
			int r=Math.min(i+n-1, ch.length-1);
			reverse(ch,l,r);
		}
		loggger.log(Level.INFO,"After Reverse : {0}",new String(ch));
	}
	
	private static void reverse(char[] ch, int l, int r) {
		while(l<r) {
			char c=ch[l];
			ch[l++]=ch[r];
			ch[r--]=c;
		}
		
	}

	/**
	 * Finding Longest substring without duplicate characters
	 * @param src
	 * @return
	 */
	public static int longestSubStringWithOutRepetingCharacters(String src) {
		int start=0;
		int end=0;
		int maxLength=0;
		Set<Character> set=new HashSet<>();
		while(end<src.length()) {
			if(set.add(src.charAt(end))) {
				end++;
				maxLength=Math.max(maxLength,set.size());
			}else {
				set.remove(src.charAt(start));
				start++;
			}
		}
		return maxLength;
	}
	
	static int palindromeMaxLen=0;
	static int palindromeStartAt=0;
	/**
	 * Finding longest Palindrom substring 
	 * @param src
	 * @return
	 */
	public static String longestPalindromeSubString(String src) {
		
		for(int i=0;i<src.length();++i) {
			exploreSubString(src,i,i);
			exploreSubString(src,i,i+1);
		}
		return src.substring(palindromeStartAt,palindromeMaxLen+palindromeStartAt);
	}
	private static void exploreSubString(String src, int left, int right) {
		
		while(left>=0 && right<src.length() && src.charAt(left)==src.charAt(right)) {
			left--;
			right++;
		}
		if(palindromeMaxLen<right-left-1) {
			palindromeMaxLen=right-left-1;
			palindromeStartAt=left+1;
		}
	}
	
	/**
	 * Finding first non-repeating character in given string
	 * @param src
	 * @return
	 */
	public static Character findFirstUniqueCharater(String src) {
		for(int i=0;i<src.length();i++) {
			if(src.indexOf(src.charAt(i))==src.lastIndexOf(src.charAt(i))) {
				return src.charAt(i);
			}
		}
		return ' ';
	}
	
	public static List<String> generateParanhtasis(int n){
		int open=n;
		int close=n;
		List<String> list=new ArrayList<>();
		String op="";
		generateParanhtasis(open,close,list,op);
		return list;
	}

	private static void generateParanhtasis(int open, int close, List<String> list, String op) {
		if(open == 0 && close == 0) {
			list.add(op);
			return;
		}
		if(open==close) {
			generateParanhtasis(open-1,close,list,op+"(");
		}else {
			if(open>0) {
				generateParanhtasis(open-1,close,list,op+"(");
			}
			if(close>0) {
				generateParanhtasis(open,close-1,list,op+")");
			}
		}
		
	}
	
}


