package com.epam.preprod.sirenko.filesearcher.filters;

import java.io.*;

public class FilterByFileName extends Filter {
	private String input;
	
	public FilterByFileName(String input) {
		this.input = input;
	}
	
	@Override
	public boolean check(File file) {
		String fileName = file.getName();
		if (!fileName.startsWith(input)) {
			return false;
		}
		return checkNextFilter(file);
	}
}
