package com.epam.preprod.sirenko.filesearcher;

import java.io.*;

public class FilterByFileName extends Filter {
	private String input;
	
	public FilterByFileName(String input) {
		this.input = input;
	}
	
	@Override
	public boolean check(File file, File toCheckWith) {
		String fileName = file.getName();
		String fileNameToCheckWith = toCheckWith.getName();
		if (fileName.startsWith(fileNameToCheckWith)) {
			return true;
		}
		return false;
	}
}
