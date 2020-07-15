package com.app;

import java.lang.reflect.Field;

class A{
	private int i;
}
public class PrivateSource {
	public static void main(String[] args) throws Exception{
		Class clz=Class.forName("com.app.A");
		Object obj=clz.newInstance();

		Field field=clz.getDeclaredField("i");
		field.setAccessible(true);
		field.set(obj,2345);
		System.out.println(field.get(obj));
	}
}
