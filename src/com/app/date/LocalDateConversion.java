package com.app.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateConversion {
	
	public static void main(String[] args) {
		//1). Converting LocalDateTime to LocalDate
		
		LocalDateTime time=LocalDateTime.now();
		System.out.print(time +"====>");
		LocalDate date=time.toLocalDate();
		System.out.println(date);
		
		//2). Converting LocalDate to LocalDateTime
		
		LocalDate localDate=LocalDate.now();
		
		System.out.println("1st Way");
		System.out.print(localDate+"====>");
		LocalDateTime localDateTime1=localDate.atStartOfDay();
		System.out.print(localDateTime1);
		System.out.println();
		System.out.println("2nd Way");
		LocalDateTime localDateTime2=localDate.atTime(LocalTime.now());
		System.out.print(localDate+"====>");
		System.out.println(localDateTime2);
		
		int n=147;
		int h=n/60;
		int m=n%60;
		System.out.println(n/60+" : "+n%60);
		
		
		
	}
	/*
	 * output:-
	 * 	2021-01-29T16:52:02.802292====>2021-01-29
	 *  2021-01-29====>2021-01-29T00:00
	 *	2021-01-29====>2021-01-29T16:52:02.808693
	 */

}
