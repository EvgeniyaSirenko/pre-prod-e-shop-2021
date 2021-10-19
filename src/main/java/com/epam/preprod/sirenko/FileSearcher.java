package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.fileSearcher.Searcher;
import com.epam.preprod.sirenko.fileSearcher.SearcherByFileName;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.IOException;

public class FileSearcher {
	
	public static void main(String[] args) throws IOException {
		Searcher searcher;
		Integer choice;
		PrintToConsole.printString("Search by file name? Print 0 for no, 1 for yes");
		choice = Integer.valueOf(ConsoleReader.readFromConsole());
		if (choice == 1) {
			searcher = new SearcherByFileName(choice); //choice not needed
		}
		if (choice == 0) {
			PrintToConsole.printString("Search by file extension? Print 0 for no, 1 for yes");
			choice = Integer.valueOf(ConsoleReader.readFromConsole());
		}
	}
}
