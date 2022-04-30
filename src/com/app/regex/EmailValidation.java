package com.app.regex;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailValidation {

	private static final Logger logger = Logger.getLogger(EmailValidation.class.getName());

	public static void main(String[] args) {
		String email = "karun@gmail.";
		
		logger.log(Level.INFO,"{0} is valid email : {1}",new Object[] {email,validateEmail(email)});
	}
	
	public static Boolean validateEmail(String email) {
		
		String regEx = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		
		return regEx.matches(email);
	
	}
}
