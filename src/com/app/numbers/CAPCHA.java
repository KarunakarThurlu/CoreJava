package com.app.numbers;

import java.util.UUID;

public class CAPCHA {

	public static  String getCapcha()
	{

		return UUID.randomUUID().toString().replaceAll("-","").toUpperCase().substring(0,6);
	}
	public static void main(String[] args) {
		System.out.println(getCapcha());
	}
}
