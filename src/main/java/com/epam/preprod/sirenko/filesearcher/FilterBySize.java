package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public class FilterBySize extends Filter {
	private String sizeRange;
	
	public FilterBySize(String sizeRange) {
		this.sizeRange = sizeRange;
	}
	
	@Override
	public boolean check(File file) {
	//TODO
	//return checkNextFilter(file);
		return false;
	}
}