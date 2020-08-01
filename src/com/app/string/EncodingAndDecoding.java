package com.app.string;

import java.util.Base64;
import java.util.Scanner;

public class EncodingAndDecoding {

	public static void main(String[] args) {
		System.out.println("enter any one : (Encoding or Decoding)");
		Scanner sc=new Scanner(System.in);
		String choise=sc.nextLine();
		if(choise.equalsIgnoreCase("Encoding")) {
			System.out.println("Enter you password :");
			String planepwd =sc.nextLine();
			System.out.println("plane password is "+planepwd);
			String encodePwd = Base64.getEncoder().encodeToString(planepwd.getBytes());
			System.out.println("encoded password is "+encodePwd);
		}else if(choise.equalsIgnoreCase("Decoding")) {
			System.out.println("Enter your Encoded password :");
			String encodedpwd=sc.nextLine();
			String decode=new String(Base64.getDecoder().decode(encodedpwd));
			System.out.println("Decoded pwd is "+decode);
		}else {
			System.out.println("Please enter Correct Choise!");
		}
	}	
}
