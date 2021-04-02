package com.app.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateEx {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
		
		Calendar date = Calendar.getInstance();
		System.out.println(dt.format(date.getTime()));
		long t= date.getTimeInMillis();
		Date afterAddingTenMins=new Date(t - (2 * ONE_MINUTE_IN_MILLIS));
		
		
		System.out.println(dt.format(afterAddingTenMins));
	}
}
