package com.epam.preprod.sirenko.util;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * This class returns Timestamp of console input
 */
public class ConsoleInputTimestampManager {
	
	private ConsoleInputTimestampManager() {
	}
	
	public static Timestamp manageTimestamp(String string) {
		while (!ValidatorOfConsoleInput.dateValidator(string)) {
			PrintToConsole.printString("Print date in correct format 2021-09-23 13:45:00 and press Enter");
			try {
				string = ConsoleReader.readFromConsole();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ConverterToTimestamp.convertStringToTimestamp(string);
	}
}