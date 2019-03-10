package com.app.numbers;

public class LcmOfTwoNumbers {
	public static void main(String[] args) {
		int n1=2,n2=3;
		int lcm=(n1<n2)?n2:n1;
		while(true)
		{
			if(lcm%n1==0&&lcm%n2==0)
			{
				System.out.println("LCM of "+n1+" ,"+n2+" is "+lcm);
				break;
			}
			++lcm;
		}
	}
}
