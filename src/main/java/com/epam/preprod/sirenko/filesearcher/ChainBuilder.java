package com.epam.preprod.sirenko.filesearcher;

import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.IOException;

public class ChainBuilder {
	int yesOrNo;
	private static final String FIRST_QUESTION = "Search by file name? Print 0 for no, 1 for yes";
	private static final String FIRST_QUESTION_PRINT_NAME = "Print file name";
	private static final String SECOND_QUESTION = "Search by file extension? Print 0 for no, 1 for yes";
	private static final String SECOND_QUESTION_PRINT_EXTENSION = "Print file extension";
	private static final String THIRD_QUESTION = "Search by file size range? Print 0 for no, 1 for yes";
	private static final String THIRD_QUESTION_PRINT_SIZE = "Print size range in format 1 5";
	private static final String FOURTH_QUESTION = "Search by file edit date range? Print 0 for no, 1 for yes";
	private static final String FOURTH_QUESTION_PRINT_DATE = "Print file edit dates in format 2021-09-10 13:45:00 2021-09-23 13:45:00";
	
	public String builder() throws IOException {
		return firstInputRequest();
	}

	private String firstInputRequest() throws IOException {
		PrintToConsole.printString(FIRST_QUESTION);
		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
		if (yesOrNo == 1) {
			PrintToConsole.printString(FIRST_QUESTION_PRINT_NAME);
			return ConsoleReader.readFromConsole();
		}
		if (yesOrNo == 0) {
			return secondInputRequest();
		}
		throw new IllegalArgumentException();
	}
	
	private String secondInputRequest() throws IOException {
		PrintToConsole.printString(SECOND_QUESTION);
		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
		if (yesOrNo == 1) {
			PrintToConsole.printString(ChainBuilder.SECOND_QUESTION_PRINT_EXTENSION);
			return ConsoleReader.readFromConsole();
		}
		if (yesOrNo == 0) {
			return thirdInputRequest();
		}
		throw new IllegalArgumentException();
	}
	
	private String thirdInputRequest() throws IOException {
		PrintToConsole.printString(THIRD_QUESTION);
		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
		if (yesOrNo == 1) {
			PrintToConsole.printString(THIRD_QUESTION_PRINT_SIZE);
			return ConsoleReader.readFromConsole();
		}
		if (yesOrNo == 0) {
			return fourthInputRequest();
		}
		throw new IllegalArgumentException();
	}
	
	private String fourthInputRequest() throws IOException {
		PrintToConsole.printString(FOURTH_QUESTION);
		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
		if (yesOrNo == 1) {
			PrintToConsole.printString(FOURTH_QUESTION_PRINT_DATE);
			return ConsoleReader.readFromConsole();
		}
		if (yesOrNo == 0) {
			throw new IllegalArgumentException("No filters left, try again");
		}
		throw new IllegalArgumentException();
	}
}
