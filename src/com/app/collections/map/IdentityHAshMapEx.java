package com.app.collections.map;

import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHAshMapEx {

	public static void main(String[] args) {
		Map<String, String> ihp=new IdentityHashMap<>();
		ihp.put("kaeun", "K");
		ihp.put("Varun","V");
		System.out.println(ihp);
		System.out.println("end");
	}
}
