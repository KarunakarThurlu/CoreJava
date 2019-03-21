package com.app.string;

public class CirxleCheck {
	public static char getNext(char c)
	{
		if(c=='A')
			return 'B';
		else if(c=='B')
			return 'C';
		else if(c=='C')
			return 'A';
		else
			return '!';
	}
	public static void main(String[] args) {
		String input="ABCAB";
		char arr[]=input.toCharArray();
		boolean flag=true;
		for(int i=0;i<arr.length-1;i++)
		{
			if(!(getNext(arr[i])==arr[i+1]))
			{
				flag=false;
				break;
			}
		}
		System.out.println(flag);
	}
}
