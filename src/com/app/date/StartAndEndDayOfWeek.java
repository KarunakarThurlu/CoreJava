package com.app.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class StartAndEndDayOfWeek {
	public static void main(String[] args) {
		LocalDate now=LocalDate.now();
		LocalDate startDay=now.with(DayOfWeek.SUNDAY).minusDays(7);
		LocalDate endDay=now.with(DayOfWeek.SATURDAY);
		System.out.println(startDay+" "+endDay);
	
	}
}
