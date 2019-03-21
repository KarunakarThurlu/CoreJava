package com.app.numbers;

import java.util.Random;

public class OTP {
	public static void main(String[] args) {
		for(int i=1;i<=10;i++) {
			String str=null;
			while(true)
			{
				int r= new Random().nextInt(999999);
				str=""+Math.abs(r);
				if(str.length()==6)
				{
					System.out.print(str+" ");
					break;
				}
			}
		}
		
	}
}
