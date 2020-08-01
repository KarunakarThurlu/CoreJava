package com.app;

import java.lang.reflect.Field;

public class PrivateSource {
	
	public static void main(String[] args) throws Exception{
		Class clz=Class.forName("com.app.model.Employee");
		Object obj=clz.newInstance();
		Field field=clz.getDeclaredField("ename");
		field.setAccessible(true);
		field.set(obj, "karun");
		System.out.println(field.get(obj));
	}
}
