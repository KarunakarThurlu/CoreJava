package com.app;

import java.util.Arrays;
import java.util.List;

public class Prime {
	public static void main(String[] args) {
		int j=-1;
		for(int i=0;i<3;i++) {
			j++;
			System.out.println(j);
		}
		System.out.println(j);
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
