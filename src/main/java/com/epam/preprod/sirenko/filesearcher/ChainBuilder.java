package com.epam.preprod.sirenko.filesearcher;

import com.epam.preprod.sirenko.filesearcher.filters.*;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.util.ValidatorOfConsoleInput;

import java.io.IOException;
import java.sql.Timestamp;

public class ChainBuilder {
	private static final String INCORRECT_INPUT_NO_FILTERS_CHOSEN = "You haven't choose any filter. Try again.";
	private static final String INCORRECT_INPUT_ONE_OR_ZERO = "Please print only 0 or 1";
	private static final String INCORRECT_INPUT_SIZE_RANGE = "You've entered wrong format of size range";
	private static final String INCORRECT_INPUT_SIZE_RANGE_FIRST_BIGGER = "You've entered wrong size range - first is bigger then second";
	private static final String INCORRECT_INPUT_EDIT_DATE_RANGE = "You've entered wrong format of dates range";
	private static final String INCORRECT_INPUT_EDIT_DATE_RANGE_FIRST_LATER = "You've entered wrong dates - first is not earlier then second";
	private static final String FIRST_QUESTION = "Search by file name? Print 0 for no, 1 for yes";
	private static final String FIRST_QUESTION_PRINT_NAME = "Print file name";
	private static final String SECOND_QUESTION = "Search by file extension? Print 0 for no, 1 for yes";
	private static final String SECOND_QUESTION_PRINT_EXTENSION = "Print file extension";
	private static final String THIRD_QUESTION = "Search by file size range? Print 0 for no, 1 for yes";
	private static final String THIRD_QUESTION_PRINT_SIZE = "Print size range in kilobytes in format 85 230";
	private static final String FOURTH_QUESTION = "Search by file edit date range? Print 0 for no, 1 for yes";
	private static final String FOURTH_QUESTION_PRINT_DATE = "Print file edit dates in format 2021-09-10 13:45:00 2021-09-23 13:45:00";
	private Filter filter;
	private ConsoleReader consoleReader = new ConsoleReader();
	
	
	public Filter builder() throws IOException {
		return firstInputRequest();
	}
	
	private Filter firstInputRequest() throws IOException {
		PrintToConsole.printString(FIRST_QUESTION);
		String inputString = consoleReader.readFromConsole();
		if (!ValidatorOfConsoleInput.checkInputStringIsNumberOneOrZero(inputString)) {
			PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
			return firstInputRequest();
		}
		int input = Integer.parseInt(inputString);
		if (input == 1) {
			PrintToConsole.printString(FIRST_QUESTION_PRINT_NAME);
			String fileName = consoleReader.readFromConsole();
			filter = new FilterByFileName(fileName);
			return secondInputRequest(filter);
		}
		if (input == 0) {
			
			return secondInputRequest(filter);
		}
		PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
		return firstInputRequest();
	}
	
	private Filter secondInputRequest(Filter filter) throws IOException {
		PrintToConsole.printString(SECOND_QUESTION);
		String inputString = consoleReader.readFromConsole();
		if (!ValidatorOfConsoleInput.checkInputStringIsNumberOneOrZero(inputString)) {
			PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
			return secondInputRequest(filter);
		}
		int input = Integer.parseInt(inputString);
		if (input == 1) {
			PrintToConsole.printString(SECOND_QUESTION_PRINT_EXTENSION);
			String fileExtension = consoleReader.readFromConsole();
			if (filter == null) {
				filter = new FilterByExtension(fileExtension);
			} else {
				filter.setNextFilter(new FilterByExtension(fileExtension));
			}
			return thirdInputRequest(filter);
		}
		if (input == 0) {
			return thirdInputRequest(filter);
		}
		PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
		return secondInputRequest(filter);
	}
	
	private Filter thirdInputRequest(Filter filter) throws IOException {
		PrintToConsole.printString(THIRD_QUESTION);
		String inputString = consoleReader.readFromConsole();
		if (!ValidatorOfConsoleInput.checkInputStringIsNumberOneOrZero(inputString)) {
			PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
			return thirdInputRequest(filter);
		}
		int input = Integer.parseInt(inputString);
		if (input == 1) {
			PrintToConsole.printString(THIRD_QUESTION_PRINT_SIZE);
			String sizeRange = consoleReader.readFromConsole();
			if (!checkInputIsCorrectSizeRange(sizeRange)) {
				return thirdInputRequest(filter);
			}
			if (filter == null) {
				filter = new FilterBySize(sizeRange);
			} else {
				filter.setNextFilter(new FilterBySize(sizeRange));
			}
			return fourthInputRequest(filter);
		}
		if (input == 0) {
			return fourthInputRequest(filter);
		}
		PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
		return thirdInputRequest(filter);
	}
	
	private Filter fourthInputRequest(Filter filter) throws IOException {
		PrintToConsole.printString(FOURTH_QUESTION);
		String inputString = consoleReader.readFromConsole();
		if (!ValidatorOfConsoleInput.checkInputStringIsNumberOneOrZero(inputString)) {
			PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
			return fourthInputRequest(filter);
		}
		int input = Integer.parseInt(inputString);
		if (input == 1) {
			PrintToConsole.printString(FOURTH_QUESTION_PRINT_DATE);
			String editDateRange = consoleReader.readFromConsole();
			if (!checkInputIsCorrectDateRange(editDateRange)) {
				return fourthInputRequest(filter);
			}
			if (filter == null) {
				filter = new FilterByEditDate(editDateRange);
			} else {
				filter.setNextFilter(new FilterByEditDate(editDateRange));
			}
			return filter;
		}
		if (input == 0) {
			if (filter == null) {
				PrintToConsole.printString(INCORRECT_INPUT_NO_FILTERS_CHOSEN);
				return firstInputRequest();
			}
			return filter;
		}
		PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
		return fourthInputRequest(filter);
	}
	
	private boolean checkInputIsCorrectSizeRange(String inputString) {
		if (!inputString.matches("([0-9]+)\\s([0-9]+)")) {
			PrintToConsole.printString(INCORRECT_INPUT_SIZE_RANGE);
			return false;
		}
		String[] sizeRangeArray = inputString.split("\\s");
		long sizeRangeFromInKB = Long.parseLong(sizeRangeArray[0]);
		long sizeRangeToInKB = Long.parseLong(sizeRangeArray[1]);
		if (sizeRangeFromInKB > sizeRangeToInKB) {
			PrintToConsole.printString(INCORRECT_INPUT_SIZE_RANGE_FIRST_BIGGER);
			return false;
		}
		return true;
	}
	
	private boolean checkInputIsCorrectDateRange(String inputString) {
		if (!inputString
				.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{2}:\\d{2}:\\d{2} \\d{4}-\\d{1,2}-\\d{1,2} \\d{2}:\\d{2}:\\d{2}")) {
			PrintToConsole.printString(INCORRECT_INPUT_EDIT_DATE_RANGE);
			return false;
		}
		String[] dateRangeArray = inputString.split("(?<!\\G\\S+)\\s");
		Timestamp timeFrom = Timestamp.valueOf(dateRangeArray[0]);
		Timestamp timeTo = Timestamp.valueOf(dateRangeArray[1]);
		if (timeFrom.after(timeTo)) {
			PrintToConsole.printString(INCORRECT_INPUT_EDIT_DATE_RANGE_FIRST_LATER);
			return false;
		}
		return true;
	}
}