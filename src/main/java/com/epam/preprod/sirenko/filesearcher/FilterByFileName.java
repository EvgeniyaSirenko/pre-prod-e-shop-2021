package com.epam.preprod.sirenko.filesearcher;

import java.io.*;
import java.util.NoSuchElementException;

public class FilterByFileName extends Filter {
	private String input;
	
	public FilterByFileName(String input) {
		this.input = input;
	}
	
	@Override
	public boolean check(File file) {
		File root = new File("/Users/evgeniya/idea-workspace/pre-prod-e-shop-2021");
		String inputFileName = file.getName();
		File[] listOfFiles = root.listFiles();
		for (File listOfFile : listOfFiles) {
			String fileName = listOfFile.getName();
			if (fileName.startsWith(inputFileName)) {
				System.out.println(inputFileName);
				return true;
			}
		}
		
		throw new NoSuchElementException();
	}
}
