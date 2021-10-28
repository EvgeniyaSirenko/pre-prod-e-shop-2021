package com.epam.preprod.sirenko.filesearcher.filters;

import java.io.File;
import java.sql.Timestamp;

public class FilterByEditDate extends Filter {
	private String dateRange;
	
	public FilterByEditDate(String dateRange) {
		this.dateRange = dateRange;
	}
	
	@Override
	public boolean check(File file) {
		long fileLastModifiedDate = file.lastModified();
		Timestamp fileModified = new Timestamp(fileLastModifiedDate);
		String[] dateRangeArray = dateRange.split("(?<!\\G\\S+)\\s");
		Timestamp timeFrom = Timestamp.valueOf(dateRangeArray[0]);
		Timestamp timeTo = Timestamp.valueOf(dateRangeArray[1]);
		if (fileModified.after(timeFrom) && fileModified.before(timeTo)) {
			return true;
		}
		return checkNextFilter(file);
	}
}