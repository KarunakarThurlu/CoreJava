package com.app.date;

import java.lang.System.Logger.Level;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FormattingLocalDate {

	private static final System.Logger loggger = System.getLogger(FormattingLocalDate.class.getName());

	public static void main(String[] args) {

		LocalDateTime localDate = LocalDateTime.now();

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");			//18-03-2022
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yy");			    //18-03-22
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");			//18-Mar-2022
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd MMM yyyy");			//18 Mar 2022
		DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("DD-MMM-yyyy");			//77-Mar-2022
		DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("dd/MMM/yyyy");			//18/Mar/2022
		DateTimeFormatter formatter7 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");	//18-03-2022 09:03:15
		DateTimeFormatter formatter8 = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");	//18-03-2022 09:34:04

		String formattedString1 = formatter1.format(localDate);
		String formattedString2 = formatter2.format(localDate);
		String formattedString3 = formatter3.format(localDate);
		String formattedString4 = formatter4.format(localDate);
		String formattedString5 = formatter5.format(localDate);
		String formattedString6 = formatter6.format(localDate);
		String formattedString7 = formatter7.format(localDate);
		String formattedString8 = formatter8.format(localDate);
		
		loggger.log(Level.INFO, formattedString1);
		loggger.log(Level.INFO, formattedString2);
		loggger.log(Level.INFO, formattedString3);
		loggger.log(Level.INFO, formattedString4);
		loggger.log(Level.INFO, formattedString5);
		loggger.log(Level.INFO, formattedString6);
		loggger.log(Level.INFO, formattedString7);
		loggger.log(Level.INFO, formattedString8);

	}

}
