package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public class FilterByExtension extends Filter {
	private String extension;
	
	public FilterByExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public boolean check(File file) {
		String fileName = file.getName();
		if (fileName.endsWith(extension)) {
			return true;
		}
		return checkNextFilter(file);
	}
}
