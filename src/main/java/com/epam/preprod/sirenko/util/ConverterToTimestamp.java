package com.epam.preprod.sirenko.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is for converting
 */
public class ConverterToTimestamp {
	
	private ConverterToTimestamp() {
	}
	
	public static Timestamp convertStringToTimestamp(String string) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = dateFormat.parse(string);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException();
	}
}