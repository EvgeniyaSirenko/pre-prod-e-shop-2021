package com.epam.preprod.sirenko.filesearcher;

import java.io.File;
import java.util.List;

public class FileSearcherDemo {
	
	public static void main(String[] args) {
		String startDirectory = "/Users/evgeniya/Desktop";
		String input = "png";
		Filter filter = new FilterByFileName(input);
		//TODO filters work separately, but chain doesn't work
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
