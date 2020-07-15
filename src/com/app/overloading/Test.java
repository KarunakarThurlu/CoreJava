package com.app.overloading;

public class Test {
	public  static void show(StringBuilder s)
	{
		System.out.println("string method");
	}
	public static void  show(StringBuffer sb)
	{
		System.out.println("sbuffer ");
	}
     public static void show(Object i) 
     {
    	 System.out.println("Object method"); 
     }
	public static void main(String[] args) {
		show("abc");
	}
}
