package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.IOException;
import java.math.BigDecimal;

public class CreatedByInputProductImpl implements Strategy {
	private static final String INPUT_PRICE = "Enter price in format 123.04 and press Enter";
	private static final String INPUT_WEIGHT = "Enter weight in format 200 and press Enter";
	private static final String INPUT_STRING_NAME = "Enter name from 5 to 15 letters only and press Enter";
	private static final String INPUT_STRING_BRAND_NAME = "Enter brand name from 5 to 15 letters only and press Enter";
	private static final String INPUT_PET_GROUP = "Enter pet group name and press Enter";
	
	@Override
	public PetGroup getPetGroup() {
		PetGroup petGroup = null;
		for (PetGroup element : PetGroup.values()) {
			System.out.println(element);
		}
		PrintToConsole.printString(INPUT_PET_GROUP);
		try {
			String input = ConsoleReader.readFromConsole();
			if (!checkInputIsCorrectPetGroup(input)) {
				getPetGroup();
			}
			petGroup = PetGroup.valueOf(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return petGroup;
	}
	
	@Override
	public Season getSeason() {
		return null;
	}
	
	@Override
	public Size getSize() {
		return null;
	}
	
	@Override
	public String getStringName() {
		PrintToConsole.printString(INPUT_STRING_NAME);
		return getString();
	}
	
	@Override
	public String getStringBrandName() {
		PrintToConsole.printString(INPUT_STRING_BRAND_NAME);
		return getString();
	}
	
	@Override
	public int getInt() {
		int weight = 0;
		PrintToConsole.printString(INPUT_WEIGHT);
		try {
			String input = ConsoleReader.readFromConsole();
			if (!checkInputIsCorrectWeight(input)) {
				getInt();
			}
			weight = Integer.parseInt(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return weight;
	}
	
	@Override
	public BigDecimal getBigDecimal() {
		BigDecimal price = null;
		PrintToConsole.printString(INPUT_PRICE);
		try {
			String input = ConsoleReader.readFromConsole();
			if (!checkInputIsCorrectPrice(input)) {
				getBigDecimal();
			}
			price = new BigDecimal(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	private boolean checkInputIsCorrectPetGroup(String inputString) {
		for (PetGroup value : PetGroup.values()) {
			if (value.name().equals(inputString)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkInputIsCorrectPrice(String inputString) {
		return inputString.matches("([0-9]+).([0-9]{2})");
	}
	
	private boolean checkInputIsCorrectWeight(String inputString) {
		return inputString.matches("\\d+");
	}
	
	private boolean checkInputIsCorrectString(String inputString) {
		return inputString.matches("[a-zA-Z]{5,15}");
	}
	
	private String getString() {
		String name = null;
		try {
			String input = ConsoleReader.readFromConsole();
			if (!checkInputIsCorrectString(input)) {
				getStringName();
			}
			name = input;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}
}