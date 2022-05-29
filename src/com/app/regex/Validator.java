package com.app.regex;

import java.util.regex.Pattern;

public class Validator {
	
	public static void main(String[] args) {
		String str = "AAoo989";
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9!.\\-, \"]+$");
	
		System.out.println(validateEmail("test@gmail.com"));
		System.out.println(pattern.matcher(str).matches());
	}
	
	public static Boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
		return pattern.matcher(email).matches();
	}
}
