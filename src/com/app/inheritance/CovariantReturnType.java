package com.app.inheritance;

interface Interviewer{
	public default Object getStatus(){
		System.out.println("Interviewer Accepted :YES");
		return "Interviewer Accepted :YES";
	}
}
class Manager implements Interviewer{
	public  String getStatus(){
		System.out.println("Manager Accepted :YES");
		return "Manager Accepted :YES";
	}
}
public class CovariantReturnType {
	/*
	 * 1). When Overriding any method ,we must follow  name,parameters,returnType must be same.
	 * 2). But from JDK 1.5 onwards overriding method return type may be CovariantReturnType (i.e Parent class sub type).
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Manager m=new Manager();
		String s=m.getStatus();
		System.out.println(s);		
	}
}
