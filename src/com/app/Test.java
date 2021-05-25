package com.app;

public class Test {
	
	public static void main(String[] args) {
		Integer n=3463;
		int temp=n,max=0;
		while(temp>0) {
			int r=temp%10;
			    if(r>max)
			    	max=r;
			temp=temp/10;
		}
		System.out.println(max);
	}
}



