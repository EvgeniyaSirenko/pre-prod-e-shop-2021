package com.epam.preprod.sirenko.filesearcher;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileSearcherDemo {
	//TODO this String could be a local variable, or better to leave it here?
	private static String startDirectory = "/Users/evgeniya/Desktop/test";
	private static FileSearcher fileSearcher;
	
	private static void init() throws IOException {
		String input = new ChainBuilder().builder();
		Filter filter = new FilterByFileName(input);
		filter.setNextFilter(new FilterByExtension(input));
		filter.setNextFilter(new FilterBySize(input));
		filter.setNextFilter(new FilterByEditDate(input));
		fileSearcher = new FileSearcher(filter);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		List<File> list = fileSearcher.fileSearch(new File(startDirectory));
		if (list.isEmpty()) {
			System.out.println("File not found");
		} else {
			for (File f : list) {
				System.out.println(f);
			}
			System.out.println("---------------------------------");
			System.out.println("Found files: " + list.size());
		}
	}
}
