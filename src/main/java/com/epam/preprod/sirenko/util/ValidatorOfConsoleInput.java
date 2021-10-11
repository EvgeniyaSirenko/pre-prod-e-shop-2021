package com.epam.preprod.sirenko.util;

import com.epam.preprod.sirenko.ConsoleReader;
import com.epam.preprod.sirenko.PrintToConsole;

import java.io.IOException;

public class ValidatorOfConsoleInput {
	
	private ValidatorOfConsoleInput() {
	}
	
	public static String dateValidator(String input) {
		if (input == null || !input.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}")) {
			PrintToConsole.printString("Print date in correct format 2021-09-23 13:45:00 and press Enter");
			try {
				ConsoleReader.readFromConsole();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
}
