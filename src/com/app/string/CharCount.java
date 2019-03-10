package com.app.string;

public class CharCount {
	public static void main(String[] args) {
		String s="karunakar yadav thuelu";
		for(char c='a';c<='z';c++)
		{
			int count=0;
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)==c)
					count++;
			}
			if(count>0)
				System.out.print(c+"="+count+" ");
		}
	}
}
