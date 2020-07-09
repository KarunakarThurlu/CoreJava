package com.app;

import java.util.Arrays;
import java.util.List;

public class Prime {
	public static void main(String[] args) {
		List<Integer> l=Arrays.asList(12,45,null);
		l.add(null);
		sum(null);
	}
	static void  sum(List<Integer> l) {
		int sum=0;
		if ( !l.isEmpty() && l!=null) {
			for (Integer ll : l) {
				if (ll != null) {
					sum = sum + ll;
				}
			} 
		}	System.out.println(sum);
	}
}
