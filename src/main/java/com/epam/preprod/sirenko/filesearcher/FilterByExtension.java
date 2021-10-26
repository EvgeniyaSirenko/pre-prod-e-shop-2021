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
		return fileName.endsWith(extension); //last filter should be like this
//		if (fileName.endsWith(extension)) {
//			return true;
//		}
//		return checkNextFilter(file);
	}
}
