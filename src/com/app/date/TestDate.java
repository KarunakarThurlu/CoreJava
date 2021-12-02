package com.app.date;

import java.time.LocalDate;

public class TestDate {
	public static void main(String[] args) {
		try {
			LocalDate d=LocalDate.of(2021,11,15);
			System.out.println(d.plusDays(84));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
}
