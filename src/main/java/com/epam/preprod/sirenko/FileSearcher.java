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
	
	//	File dir = new File(""); //NPE
	//File dir = new File("/Users/evgeniya/Desktop/test");
	//	File dir = new File(".");
	
	public List<File> fileSearch(File file) {
		File dir = new File("."); //TODO
		List<File> files = new ArrayList<>();
		File[] filesList = dir.listFiles();
		for (File f : filesList) {
			if (f.isDirectory()) {
				fileSearch(f); //TODO
			}
			if (f.isFile()) {
				if (filter.check(f, file)) {
					files.add(f);
				}
			}
		}
		if (files.isEmpty()) {
			System.out.println("File not found");
		} else {
			for (File f : files) {
				System.out.println(f);
			}
			System.out.println("---------------------------------");
			System.out.println("Found files: " + files.size());
		}
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
			fileSearcher.fileSearch(fileName);
			
		}
		//TODO extract method or smth
		if (yesOrNo == 0) {
			PrintToConsole.printString("Search by file extension? Print 0 for no, 1 for yes");
			yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
			if (yesOrNo == 1) {
				PrintToConsole.printString("Print file extension");
				String input = ConsoleReader.readFromConsole();
				File fileName = new File(input);
				Filter filter = new FilterByExtension(input);
				//filter.setNextFilter(new FilterBySize());
				fileSearcher = new FileSearcher(filter);
				fileSearcher.fileSearch(fileName);
			}
			if (yesOrNo == 0) {
				PrintToConsole.printString("Search by file size range? Print 0 for no, 1 for yes");
				yesOrNo = Integer.parseInt(ConsoleReader.readFromConsole());
			}
		}
	}
}
