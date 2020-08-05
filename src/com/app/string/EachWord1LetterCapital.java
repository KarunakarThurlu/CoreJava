package com.app.string;

public class EachWord1LetterCapital {
	public static void main(String[] args) {

		String str=" have a nice       day";
		String arr[]=str.split("\\s");
		String str1="";
		for(String s:arr)
		{
			if(!s.isEmpty()) {
				String ch=s.charAt(0)+"";
				str1=ch.toUpperCase()+s.substring(1);
				System.out.print(str1+" ");
			}

		}
		
	}
}
