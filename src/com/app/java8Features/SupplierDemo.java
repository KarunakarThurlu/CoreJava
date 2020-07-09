package com.app.java8Features;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<Integer> {
	@Override
	public Integer get() {
		int a=1234;
		int temp=a,sum=0;
		while(temp!=0) {
			int r=temp%10;
			sum=sum+r;
			temp=temp/10;
		}
		return sum;
	}
	public static void main(String[] args) {
		Supplier<Integer> supplier=new SupplierDemo();
		System.out.println("sum of all digits : "+supplier.get());
		
		//=====Using Lambda Expression======
		
		Supplier<Integer> supplier1=()->{
			int a=2345;
			int temp=a,sum=0;
			while(temp!=0) {
				int r=temp%10;
				sum=sum*10+r;
				temp=temp/10;
			}
			return sum;
		};
		System.out.println("reverse of number :"+supplier1.get());
		
		
	}
}
