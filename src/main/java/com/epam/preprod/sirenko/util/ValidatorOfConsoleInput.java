package com.epam.preprod.sirenko.util;

/**
 * This class is for validation
 */
public class ValidatorOfConsoleInput {
	private static final String DATE = "\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}";
	
	private ValidatorOfConsoleInput() {
	}
	
	public static Boolean dateValidator(String input) {
		return input != null && input.matches(DATE);
	}
}