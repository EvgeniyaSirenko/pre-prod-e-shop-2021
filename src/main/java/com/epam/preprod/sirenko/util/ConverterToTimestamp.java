package com.epam.preprod.sirenko.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is for converting, should be used after ValidatorOfConsoleInput returns true (for NPE check)
 */
public class ConverterToTimestamp {
	
	private ConverterToTimestamp() {
	}
	
	public static Timestamp convertStringToTimestamp(String string) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(date.getTime());
	}
}