package com.app.string;

import java.util.HashMap;

public class RemovingDuplicateChar {
	public static void main(String[] args) {
		String s="karuanakar";
		String s2="";
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch!=' ')
			{
				s2=s2+ch;
				s=s.replace(ch,' ');
				
			}
		}
		System.out.println(s2);
		String ss="karunakar";
		HashMap<Character, Integer> res=new HashMap<>();
		for(int i=0;i<ss.length();i++) {
			char c=ss.charAt(i);
			ss=ss.replace(c,' ');
		}
		System.out.println(ss);
	}
}
