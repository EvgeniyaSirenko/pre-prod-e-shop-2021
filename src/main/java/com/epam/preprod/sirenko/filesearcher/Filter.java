package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public abstract class Filter {
	private Filter nextFilter;
	
	/**
	 * Additional check of file
	 */
	public abstract boolean check(File file);
	
	/**
	 * Checks next filter and sets if it is null
	 */
	public void setNextFilter(Filter filter) {
		if (this.nextFilter == null) {
			this.nextFilter = filter;
			return;
		}
		nextFilter.setNextFilter(filter);
	}
}
