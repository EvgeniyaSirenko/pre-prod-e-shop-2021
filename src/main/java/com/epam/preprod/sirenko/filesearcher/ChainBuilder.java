package com.epam.preprod.sirenko.filesearcher;

import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.IOException;

public class ChainBuilder {
	
	public void builder() throws IOException {
		Searcher searcher;
		Integer yesOrNo;
		
		PrintToConsole.printString("Search by file name? Print 0 for no, 1 for yes");
		yesOrNo = Integer.valueOf(ConsoleReader.readFromConsole());
		if (yesOrNo == 1) {
			PrintToConsole.printString("Print file name");
			String input = ConsoleReader.readFromConsole();
			searcher = new SearcherByFileName(input);
			searcher.setNextFilter(input);
		}
		if (yesOrNo == 0) {
			PrintToConsole.printString("Search by file extension? Print 0 for no, 1 for yes");
			yesOrNo = Integer.valueOf(ConsoleReader.readFromConsole());
			//TODO
		}
	}
}
