package com.epam.preprod.sirenko.util;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

/**
 * This class is for validation
 */
public class ValidatorOfConsoleInput {
	private static final String DATE = "\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}";
	
	private ValidatorOfConsoleInput() {
	}
	
	public static boolean dateValidator(String input) {
		return input != null && input.matches(DATE);
	}
	
	public static boolean checkInputStringIsNumberOneOrZero(String inputString) {
		return inputString.matches("[01]");
	}
	
	public static boolean checkInputIsCorrectPetGroup(String inputString) {
		for (PetGroup value : PetGroup.values()) {
			if (value.name().equals(inputString)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkInputIsCorrectSeason(String inputString) {
		for (Season value : Season.values()) {
			if (value.name().equals(inputString)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkInputIsCorrectSize(String inputString) {
		for (Size value : Size.values()) {
			if (value.name().equals(inputString)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkInputIsCorrectPrice(String inputString) {
		return inputString.matches("([0-9]+).([0-9]{2})");
	}
	
	public static boolean checkInputIsCorrectWeight(String inputString) {
		return inputString.matches("\\d+");
	}
	
	public static boolean checkInputIsCorrectString(String inputString) {
		return inputString.matches("[a-zA-Z]{5,15}");
	}
	
}
