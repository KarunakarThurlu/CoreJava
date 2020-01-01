package com.app.numbers;

import java.util.stream.Stream;

public class Fibonnaci {
	public static void main(String[] args) {
		int a=0,b=1,c=0;
		for(int i=0;i<20;i++)
		{
			System.out.print(c+" ");
			a=b;
			b=c;
			c=a+b;
		}
		System.out.println();
		//2nd way
		Stream.iterate(new long[] {1, 1},f->new long[] {f[1],f[0]+f[1]})
			  .limit(50)
			  .forEach(s->System.out.print(s[0]+" "));
	}
}
