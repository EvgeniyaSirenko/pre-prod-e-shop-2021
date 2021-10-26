package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public abstract class Filter {
	private Filter nextFilter;
	
	/**
	 * Additional check of file
	 */
	public abstract boolean check(File file);
	
	
	/**
	 * Starts check in next Filter
	 */
	protected boolean checkNextFilter(File file) {
		if (nextFilter == null) {
			return true;
		}
		return nextFilter.check(file);
	}
	
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
