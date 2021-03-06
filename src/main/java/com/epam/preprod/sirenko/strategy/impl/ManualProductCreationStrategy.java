package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import com.epam.preprod.sirenko.strategy.Strategy;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.util.ValidatorOfConsoleInput;

import java.io.IOException;
import java.math.BigDecimal;

public class ManualProductCreationStrategy implements Strategy {
	private static final String INPUT_PRICE = "Enter price in format 123.04 and press Enter";
	private static final String INPUT_WEIGHT = "Enter weight in format 200 and press Enter";
	private static final String INPUT_STRING_NAME = "Enter name from 5 to 15 letters only and press Enter";
	private static final String INPUT_STRING_BRAND_NAME = "Enter brand name from 5 to 15 letters only and press Enter";
	private static final String INPUT_PET_GROUP = "Enter pet group name and press Enter";
	private static final String INPUT_SEASON = "Enter season and press Enter";
	private static final String INPUT_SIZE = "Enter size and press Enter";
	private ConsoleReader consoleReader = new ConsoleReader();
	
	@Override
	public PetGroup getPetGroup() {
		PetGroup petGroup = null;
		printPetGroupElements();
		PrintToConsole.printString(INPUT_PET_GROUP);
		try {
			String input = consoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputIsCorrectPetGroup(input)) {
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
		Season season = null;
		printSeasonElements();
		PrintToConsole.printString(INPUT_SEASON);
		try {
			String input = consoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputIsCorrectSeason(input)) {
				getSeason();
			}
			season = Season.valueOf(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return season;
	}
	
	@Override
	public Size getSize() {
		Size size = null;
		printSizeElements();
		PrintToConsole.printString(INPUT_SIZE);
		try {
			String input = consoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputIsCorrectSize(input)) {
				getSize();
			}
			size = Size.valueOf(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return size;
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
			String input = consoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputIsCorrectWeight(input)) {
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
			String input = consoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputIsCorrectPrice(input)) {
				getBigDecimal();
			}
			price = new BigDecimal(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return price;
	}
	
	protected void printPetGroupElements() {
		for (PetGroup element : PetGroup.values()) {
			System.out.println(element);
		}
	}
	
	protected void printSeasonElements() {
		for (Season element : Season.values()) {
			System.out.println(element);
		}
	}
	
	protected void printSizeElements() {
		for (Size element : Size.values()) {
			System.out.println(element);
		}
	}
	
	private String getString() {
		String name = null;
		try {
			String input = consoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputIsCorrectString(input)) {
				getStringName();
			}
			name = input;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}
}