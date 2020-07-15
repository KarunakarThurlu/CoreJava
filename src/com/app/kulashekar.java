package com.app;

import java.util.stream.IntStream;

public class kulashekar {
	public static void main(String[] args) {
		
		IntStream.range(1,50).forEach(s->{
               if(s%2==0)
				System.out.print(s+" ");
		});
		System.out.println();
	}
}
