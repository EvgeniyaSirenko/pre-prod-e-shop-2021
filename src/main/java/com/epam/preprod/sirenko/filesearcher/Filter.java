package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public abstract class Filter {
	private Filter nextFilter;

//	protected Filter(Filter nextFilter) {
//		this.nextFilter = nextFilter;
//	}
	
	/**
	 * Helps build chain
	 */
//	public Filter linkWith(Filter nextFilter) {
//		this.nextFilter = nextFilter;
//		return nextFilter;
//	}
	
	/**
	 * Additional checking
	 */
	public abstract boolean check(File file);
	
	/**
	 * Checks next object or stops on the last
	 */
	public void setNextFilter(Filter filter) {
		if (filter == null) {
			return;
		}
		if (nextFilter != null) {
			nextFilter.setNextFilter(filter);
		}
	}
}
