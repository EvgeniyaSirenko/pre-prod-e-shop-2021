package com.epam.preprod.sirenko;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public Timestamp convertStringToTimestamp(String string) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(string);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
