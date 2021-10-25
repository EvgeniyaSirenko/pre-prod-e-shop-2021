package com.epam.preprod.sirenko.filesearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class returns list of found files
 */
public class FileSearcher {
	private Filter filter;
	
	public FileSearcher(Filter filter) {
		this.filter = filter;
	}
	
	public List<File> fileSearch(File file) {
		List<File> files = new ArrayList<>();
		File[] filesList = file.listFiles();
		for (File f : filesList) {
			if (f.isDirectory()) {
				List<File> filesToAdd = fileSearch(f);
				files.addAll(filesToAdd);
			}
			//TODO not sure if its correct without first if statement
		//	if (f.isFile()) {
				if (filter.check(f)) {
					files.add(f);
				}
		//	}
		}
		return files;
	}
}
