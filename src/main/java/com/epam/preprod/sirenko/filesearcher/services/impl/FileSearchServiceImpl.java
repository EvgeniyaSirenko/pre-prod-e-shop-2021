package com.epam.preprod.sirenko.filesearcher.services.impl;

import com.epam.preprod.sirenko.filesearcher.filters.Filter;
import com.epam.preprod.sirenko.filesearcher.services.FileSearchService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class returns list of found files
 */
public class FileSearchServiceImpl implements FileSearchService {
	private Filter filter;
	
	public FileSearchServiceImpl(Filter filter) {
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
			if (f.isFile() && filter.check(f)) {
					files.add(f);
				}
			}
		return files;
	}
}
