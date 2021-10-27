package com.epam.preprod.sirenko.filesearcher;

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
		//TODO next block print as many times as files quantity
		if (timeFrom.after(timeTo)) {
			System.out.println("You've entered wrong dates - first is not earlier then second");
		}
		return fileModified.after(timeFrom) && fileModified.before(timeTo);
	}
}