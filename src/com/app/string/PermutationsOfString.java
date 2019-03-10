package com.app.string;

public class PermutationsOfString {
	public static void main(String[] args) {
		isPermute("ABCD");
	}
	static void isPermute(String s1)
	{
		if(s1.isEmpty())
		{
			System.out.println("String not empty");
		}
		isPermute("",s1);
	}
	static void isPermute(String prefix,String remaining)
	{
		if(remaining.isEmpty())
		{
			System.out.println(prefix);
		}
		else
		{
			for(int i=0;i<remaining.length();i++)
			{
				isPermute(prefix+remaining.charAt(i),remaining.substring(0,i)+remaining.substring(i+1,remaining.length()));
			}
		}
	}
}
