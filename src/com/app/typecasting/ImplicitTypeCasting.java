package com.app.typecasting;

public class ImplicitTypeCasting {
	public static void main(String[] args) {
		/*
		 * 1. Compiler is responsible for implicit type casting
		 * 2. No Loss of information
		 * 3. Smaller data type to Bigger data type 
		 * 4. Widening or Up casting
		 * 
		 */
		//4bytes<---2Bytes
		int i='a';
		
		//4bytes<---4Bytes
		double d=10.2f;
		
		//4bytes<---8Bytes
		float f=1234545643;
		System.out.println(i+" "+d+" "+f);
	}
}
