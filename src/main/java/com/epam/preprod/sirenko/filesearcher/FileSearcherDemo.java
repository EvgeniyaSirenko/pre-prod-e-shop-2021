package com.epam.preprod.sirenko.filesearcher;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileSearcherDemo {
	
	public static void main(String[] args) throws IOException {
		String startDirectory = "/Users/evgeniya/Desktop";
	//	String input = "png";
		String input = new ChainBuilder().builder();
		Filter filter = new FilterByFileName(input);
		filter.setNextFilter(new FilterByExtension(input));
		FileSearcher fileSearcher = new FileSearcher(filter);
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
