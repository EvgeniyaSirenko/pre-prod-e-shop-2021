package com.epam.preprod.sirenko.util;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterToTimestamp {
	
	private ConverterToTimestamp() {
	}
	
	public static Timestamp convertStringToTimestamp(String string) {
		try {
			string = ValidatorOfConsoleInput.dateValidator(string);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(string);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			PrintToConsole.printString("Print date in correct format 2021-09-23 13:45:00 and press Enter");
			try {
				String correctDate = ConsoleReader.readFromConsole();
				correctDate = ValidatorOfConsoleInput.dateValidator(correctDate);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = dateFormat.parse(correctDate);
				return new Timestamp(date.getTime());
			} catch (IOException | ParseException ioException) {
				PrintToConsole.printString("Wrong date format, try again from the very beginning");
			}
			//can't return null (get NPE), so I throw illegal argument exception
			throw new IllegalArgumentException();
		}
	}
}
