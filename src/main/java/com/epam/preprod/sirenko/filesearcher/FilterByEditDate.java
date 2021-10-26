package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public class FilterByEditDate extends Filter {
	private String dateRange;
	
	public FilterByEditDate(String dateRange) {
		this.dateRange = dateRange;
	}
	
	@Override
	public boolean check(File file) {
		//TODO
		return false;
	}
}
