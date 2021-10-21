package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.filesearcher.Filter;
import com.epam.preprod.sirenko.filesearcher.FilterByExtension;
import com.epam.preprod.sirenko.filesearcher.FilterByFileName;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
	private Filter filter;
	
	public FileSearcher(Filter filter) {
		this.filter = filter;
	}
	
	public List<File> fileSearch(File file) {
		List<File> files = new ArrayList<>();
		if (file.isDirectory()) {
			fileSearch(file);
		}
	//	if (file.isFile()) {
			if (filter.check(file)) {
				files.add(file);
			}
	//	}
		System.out.println(files);
		return files;
	}
	
	public static void main(String[] args) throws IOException {
//		ChainBuilder chainBuilder = new ChainBuilder();
//		chainBuilder.builder();
		
		int yesOrNo;
		FileSearcher fileSearcher;
		
		PrintToConsole.printString("Search by file name? Print 0 for no, 1 for yes");
		yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
		
		if (yesOrNo == 1) {
			PrintToConsole.printString("Print file name");
			String input = ConsoleReader.readFromConsole();
			File fileName = new File(input);
			Filter filter = new FilterByFileName(input);
			filter.setNextFilter(new FilterByExtension(input));
			fileSearcher = new FileSearcher(filter);
			fileSearcher.fileSearch(fileName); //need file
			
		}
		if (yesOrNo == 0) {
			PrintToConsole.printString("Search by file extension? Print 0 for no, 1 for yes");
			yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
			//TODO
		}
	}
}
