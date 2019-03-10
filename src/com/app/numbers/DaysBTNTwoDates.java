package com.app.numbers;

import java.time.LocalDate;
import java.time.Period;

public class DaysBTNTwoDates {
	public static void main(String[] args) {
		LocalDate d1=LocalDate.of(1995,9,02);
		LocalDate d2=LocalDate.now();
		Period p=Period.between(d1, d2);
		System.out.println(p.getYears()+" Years "+p.getMonths()+" Months "+p.getDays()+" Days");
	    
	}
}
