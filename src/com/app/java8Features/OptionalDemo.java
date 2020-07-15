package com.app.java8Features;

import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		String str=null;
		Optional<String> op=Optional.ofNullable(str);
		if(op.isPresent())
			System.out.println(str.toUpperCase());
		
		int a[]=new int[7];
		System.out.println(a);
		float d=1823433534;
		System.out.println(d);
	}
}
