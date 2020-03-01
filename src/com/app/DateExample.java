package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateExample {
	public static void main(String[] args) throws ParseException {
		//Before JDK1.7
		Date today=new Date();
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-mm-dd");
		String todaydate=sdf.format(today);
		Date currentDate=new SimpleDateFormat("yyyy-mm-dd").parse(todaydate);
		
		//From  JDK1.8 on words
		LocalDate date=LocalDate.now();
		LocalTime time=LocalTime.now();
		LocalDateTime dateTime=LocalDateTime.now();
		System.out.println(dateTime);
		System.out.println(dateTime.getDayOfMonth());
		String dd=dateTime.getYear()+"-"+dateTime.getMonthValue()+"-"+dateTime.getDayOfMonth()+" "+dateTime.getHour()+":"+dateTime.getMinute()+":"+dateTime.getSecond();
		System.out.println(dd);
		System.out.println("today date  :"+date);
		LocalDate lastResetTime=LocalDate.of(2019,9,15);
		System.out.println("lastRreset  :"+lastResetTime);
		LocalDate passwordExpires=lastResetTime.plusMonths(1);
		System.out.println("expire      :"+passwordExpires);
		LocalDate passwordExpiresAfter=passwordExpires.minusDays(6);
		System.out.println("expire aftr :"+passwordExpiresAfter);
		Period count=Period.between(date, passwordExpires);
		if(date.isBefore(passwordExpires)&& date.isAfter(passwordExpiresAfter)) {
			System.out.println("your password expires with in "+count.getDays()+" days");
		}
		
		Year year=Year.of(date.getYear());
		if(year.isLeap()) {
			System.out.println(date.getYear()+" is Leap year");
		}
		else {
			System.out.println(date.getYear()+" is not leap year");
		}
		
		ZoneId zone=ZoneId.systemDefault();
		System.out.println(zone);
		ZoneId la=ZoneId.of("America/Los_Angeles");
		ZonedDateTime zt=ZonedDateTime.now(la);
		System.out.println(zt);
		
		
	}
}
