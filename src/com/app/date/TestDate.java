package com.app.date;

import java.time.LocalDate;

public class TestDate {
	public static void main(String[] args) {
		try {
			LocalDate d=LocalDate.of(2021,02,28);
			System.out.println(d.getDayOfWeek());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
