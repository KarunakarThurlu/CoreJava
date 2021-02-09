package com.app.collections.list;

public class StackEx {

	public static void main(String[] args) {
		String s11 = "fo";
		String s22 = "fo";
		System.out.println(s11.equals(s22));
		System.out.println(s11 == s22);

		StringBuffer s1 = new StringBuffer("foo");
		StringBuffer s2 = new StringBuffer("foo");
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
	}

}
