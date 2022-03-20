package com.app.date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DurationEx {
	public static void main(String[] args) {
		LocalDateTime now=LocalDateTime.now();
		LocalDateTime next15min=now.plusMinutes(15);
		Duration duration =Duration.between(next15min,now);
		System.out.println(duration.toHours());
		
		LocalDate d=LocalDate.parse("2022-03-04");
		LocalDate p=LocalDate.parse("2022-03-05");
		String s = d.getMonth()+"";
		System.out.println(s.substring(0, 3));
		Duration dur= Duration.between(d.atStartOfDay(), p.atStartOfDay());
		Long days = dur.toDays();
		System.out.println(days);
	}
}
