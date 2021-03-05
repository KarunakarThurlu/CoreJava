package com.app.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDate {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLL yyyy");
		String formattedString = localDate.format(formatter);
		System.out.println(formattedString);
	}
}
