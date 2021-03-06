package com.epam.preprod.sirenko.filesearcher.filters;

import java.io.File;

public class FilterBySize extends Filter {
	private String sizeRange;
	
	public FilterBySize(String sizeRange) {
		this.sizeRange = sizeRange;
	}
	
	@Override
	public boolean check(File file) {
		long fileSize = file.length();
		String[] sizeRangeArray = sizeRange.split("\\s");
		long sizeRangeFromInKB = Long.parseLong(sizeRangeArray[0]);
		long sizeRangeFromInBytes = sizeRangeFromInKB * 1024;
		long sizeRangeToInKB = Long.parseLong(sizeRangeArray[1]);
		long sizeRangeToInBytes = sizeRangeToInKB * 1024;
		if (!(fileSize > sizeRangeFromInBytes && fileSize < sizeRangeToInBytes)) {
			return false;
		}
		return checkNextFilter(file);
	}
}