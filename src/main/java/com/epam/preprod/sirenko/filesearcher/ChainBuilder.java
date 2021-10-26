package com.epam.preprod.sirenko.filesearcher;

import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.IOException;

public class ChainBuilder {
	int yesOrNo;
	private static final String FIRST_QUESTION = "Search by file name? Print 0 for no, 1 for yes";
	private static final String PRINT_NAME = "Print file name";
	private static final String SECOND_QUESTION = "Search by file extension? Print 0 for no, 1 for yes";
	private static final String PRINT_EXTENSION = "Print file extension";
	
	
	public String builder() throws IOException {
		//	inputRequest(FIRST_QUESTION, PRINT_NAME);
		
		PrintToConsole.printString(FIRST_QUESTION);
		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
		if (yesOrNo == 1) {
			PrintToConsole.printString(PRINT_NAME);
			return ConsoleReader.readFromConsole();
		}
		if (yesOrNo == 0) {
			PrintToConsole.printString(SECOND_QUESTION);
			yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
			if (yesOrNo == 1) {
				PrintToConsole.printString(PRINT_EXTENSION);
				return ConsoleReader.readFromConsole();
			}
			if (yesOrNo == 0) {
				PrintToConsole.printString("Search by file size range? Print 0 for no, 1 for yes");
				yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
				if (yesOrNo == 1) {
					PrintToConsole.printString("Print file size");
					return ConsoleReader.readFromConsole();
				}
				if (yesOrNo == 0) {
					PrintToConsole.printString("Search by file edit date range? Print 0 for no, 1 for yes");
					yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
					if (yesOrNo == 1) {
						PrintToConsole.printString("Print file edit date");
						return ConsoleReader.readFromConsole();
					}
					if (yesOrNo == 0) {
						throw new IllegalArgumentException("Try again");
					}
				}
			}
		}
		throw new IllegalArgumentException();
	}
}
//	private String inputRequest(String firstQuestion, String secondQuestion) throws IOException {
//		PrintToConsole.printString(firstQuestion);
//		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
//		if (yesOrNo == 1) {
//			PrintToConsole.printString(secondQuestion);
//			return ConsoleReader.readFromConsole();
//		}
//		if (yesOrNo == 0) {
//			inputRequest(SECOND_QUESTION, PRINT_EXTENSION);
//		}
//		throw new IllegalArgumentException();
//	}
//}