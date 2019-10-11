package com.app;

import java.util.Scanner;

public class Quiz {
	
	public static void main(String[] args) {
		
		System.out.println("Please Enter your Details :");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your Name :");
		String name=scanner.nextLine();
		System.out.println("Enter your e-mail :");
		String email=scanner.nextLine();
		System.out.println("Enter your Marks :");
		int totalmarks=scanner.nextInt();
		System.out.println("Student Details :");
		System.out.print("Name  :"+name);System.out.println();
		System.out.print("Email :"+email);System.out.println();
		System.out.print("Marks :"+totalmarks);System.out.println();
		if(totalmarks>=70) {
		checkMarks(totalmarks);
		}
		else {
			System.out.println("You are not eligible for test");
		}
		
	}
	private static void checkMarks(int firstroundmarks) {
	System.out.println("Please Enter your 1st Round marks :");
	Scanner scanner1=new Scanner(System.in);
	int firstroundmarks1=scanner1.nextInt();
	if(firstroundmarks1>=70) {
		 if(firstroundmarks1>=70) {
			 System.out.println("you are shotlisted for 2nd round");
			 System.out.println("***********************************");
			 System.out.println("enter your 2nd round Marks :");
			 Scanner scanner=new Scanner(System.in);
			 int secondrounMarks=scanner.nextInt();
			 if(secondrounMarks>=60) {
				 System.out.println("you are shotlisted for 3rd round");
				 System.out.println("***********************************");
				 System.out.println("enter your 3rd round Marks :");
				 //Scanner scanner=new Scanner(System.in);
				 int thirdroundMarks=scanner.nextInt();
				 if(thirdroundMarks>=60)
				 {
					 System.out.println("congratulations,you are selected");
					 
				 }else
				 {
					 System.out.println("sorry you are not qualified");
				 }
				 
			 }
			 else {
				 System.out.println("sorry you are not qualified in 2st round!");
			 }
		 }
	}
	 else {
		 System.out.println("sorry you are not qualified in 1st round!");
	 }
		
	}
	
}
