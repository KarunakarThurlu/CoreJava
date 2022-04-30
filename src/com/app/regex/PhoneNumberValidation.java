package com.app.regex;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneNumberValidation {
	
	private static final Logger logger = Logger.getLogger(PhoneNumberValidation.class.getName());
	
	public static void main(String[] args) {
		String phno = "9701123426";
		logger.log(Level.INFO,"{0} is valid phoneNumber : {1}",new Object[] {phno,validatePhoneNumber(phno)});
	}
	
	public static Boolean validatePhoneNumber(String phoneNumber) {
		String regEx = "(^\\+)?[0-9()-]*";
		return  phoneNumber.matches(regEx);	
	}
}

