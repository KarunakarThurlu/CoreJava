package com.app.typecasting;

public class ExplicitTypeCasting {
	public static void main(String[] args) {
		/*
		 * 1. Programmer is responsible
		 * 2. Bigger data type to smaller data type
		 * 3. Loss information is there
		 * 4. Narrowing or down casting
		 * 
		 */
		int i=20;

		//1byte<---4bytes
		byte b=(byte)i;

		long l=2345454;
		
		//4bytes<---8Bytes
		int f=(int)l;
		
		System.out.println(b+"  "+f);

	}
}
