package com.app.date;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationEx {
	public static void main(String[] args) {
		LocalDateTime now=LocalDateTime.now();
		LocalDateTime next15min=now.plusHours(5);
		
		Duration duration =Duration.between(next15min,now);
		System.out.println(duration.toHours());
	}
}
