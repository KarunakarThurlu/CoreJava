package com.app.numbers;

import java.util.UUID;

public class CAPCHA {
	public static  String getCapcha() {
		//0BF11EE2F58A
		return UUID.randomUUID().toString().replaceAll("-","").toUpperCase().substring(0,12);
	}
	public static void main(String[] args) {
		System.out.println(getCapcha());
	}
}
