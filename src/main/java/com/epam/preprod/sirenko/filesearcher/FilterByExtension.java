package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public class FilterByExtension extends Filter {
	private String extension;
	
	public FilterByExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public boolean check(File file, File toCheckWith) {
		String fileName = file.getName();
		String fileNameToCheckWith = toCheckWith.getName();
		if (fileName.endsWith("." + fileNameToCheckWith)) {
			return true;
		}
		return false;
	}
}
