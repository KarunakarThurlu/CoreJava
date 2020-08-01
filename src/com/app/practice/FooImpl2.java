package com.app.practice;

public class FooImpl2 implements IInterface{

	@Override
	public void foo() {
		System.out.println(" sysout in Fooinpl2");
		
	}
   public static void main(String[] args) {
	   FooImpl2 f=new FooImpl2();
	   f.foo();
   }
}
