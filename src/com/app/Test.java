package com.app;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Test{

	static final Logger logger = System.getLogger(Test.class.getName());
	
	public static void main(String[] args) {
		logger.log(Level.INFO, "Hello World!");
	}		
}

