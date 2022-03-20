package com.app.date;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TestDate {
	public static void main(String[] args) {
		Logger log = System.getLogger(TestDate.class.getName());
		DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:MM:ss");
		LocalDateTime date =LocalDateTime.now();
		
		log.log(Level.INFO,"Solution One :"+ df.format(date));
		
		LocalDate d=LocalDate.parse("2022-03-04");
		LocalDate p=LocalDate.parse("2022-03-05");
		Duration dur= Duration.between(d.atStartOfDay(), p.atStartOfDay());
		Long days = dur.toDays();
		

	}

}
