package com.epam.preprod.sirenko.filesearcher;

import java.io.File;

public class FilterBySize extends Filter {
	
	
	/**
	 * Additional checking
	 *
	 * @param file
	 */
	@Override
	public boolean check(File file) {
		return false;
	}
}
