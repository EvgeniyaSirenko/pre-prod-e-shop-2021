package com.epam.preprod.sirenko.filesearcher;

import com.epam.preprod.sirenko.filesearcher.filters.Filter;
import com.epam.preprod.sirenko.filesearcher.services.impl.FileSearchServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileSearcherDemo {
	private static final String START_DIRECTORY = "/Users/evgeniya/Desktop/test";
	private static FileSearchServiceImpl fileSearchServiceImpl;
	
	private static void init() throws IOException {
		Filter filter = new ChainBuilder().builder();
		fileSearchServiceImpl = new FileSearchServiceImpl(filter);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		List<File> list = fileSearchServiceImpl.fileSearch(new File(START_DIRECTORY));
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
