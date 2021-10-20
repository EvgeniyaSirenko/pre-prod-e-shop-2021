package com.epam.preprod.sirenko.filesearcher;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearcherByFileName extends Searcher {
	
	public SearcherByFileName(String input) {
		super(input);
	}
	
	@Override
	public List<File> filter(Searcher searcher) {
		String path = "/Users/evgeniya/idea-workspace/pre-prod-e-shop-2021";
		File file = new File(path);// TODO pathName
		File[] matchingFiles = file.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.startsWith(input); //TODO doesn't work correctly - by f/fi/fil finds file
			}
		});
		if (matchingFiles.length < 1) {
			System.out.println("no files found");
			throw new IllegalArgumentException(); //TODO is it correct?
		}
		List<File> files = new ArrayList<>(Arrays.asList(matchingFiles));
		System.out.println(files);
	return files;
	}
}
