package com.app.date;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationEx {
	public static void main(String[] args) {
		LocalDateTime now=LocalDateTime.now();
		LocalDateTime next15min=now.plusMinutes(15);
		
		Duration duration =Duration.between(now, next15min);
		System.out.println(duration.toMinutes());
	}
}
