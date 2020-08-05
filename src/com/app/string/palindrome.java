package com.app.string;

public class palindrome {
	public static void main(String[] args) {
		String s1="MADAMAA";
		String s2="";
		boolean isPalindrome=true;
		for(int i=s1.length()-1;i>=0;i--)
		{
			s2=s2+s1.charAt(i);
		}
		if(s1.equals(s2))
			System.out.println("YES");
		else
			System.out.println("NO");

		//========@2way============


		for(int j=0;j<s1.length()/2;j++) {
			if(s1.charAt(j)!=s1.charAt(s1.length()-j-1)) {
				isPalindrome=false;
				break;
			}
		}
		System.out.println(isPalindrome);
	}


}
