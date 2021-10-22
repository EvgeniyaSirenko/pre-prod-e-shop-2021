package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public abstract class Filter {
	private Filter nextFilter;

//	protected Filter(Filter nextFilter) {
//		this.nextFilter = nextFilter;
//	}
	
	/**
	 * Additional checking
	 */
	public abstract boolean check(File file, File toCheckWith);
	
	/**
	 * Checks next object or stops on the last
	 */
	public void setNextFilter(Filter filter) {
		if (this.nextFilter == null) {
			this.nextFilter = filter;
			return;
		}
		nextFilter.setNextFilter(filter);
	}
}
