package com.app.string;

import java.util.stream.IntStream;

public class StringManupulations {
	
	public static void main(String[] args) {
		String s1="linda";
		String s2="linda";
		String s3=new String("linda");
		String s4=s3;
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s2));
		System.out.println(s4==s3);
		if(IntStream.range(2,11).noneMatch(n->11%n==0)) {
			System.out.println("prime");
		}else {
			System.out.println("notPrime");
		}
		
		
	}
}
