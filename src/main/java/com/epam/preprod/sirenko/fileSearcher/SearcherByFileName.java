package com.epam.preprod.sirenko.fileSearcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearcherByFileName extends Searcher {
	
	public SearcherByFileName(int choice) {
		super(choice);
	}
	
	@Override
	public Integer getConsoleInput() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		return Integer.valueOf(bufferedReader.readLine());
	}
	
	@Override
	public void searcherManager(Integer input) throws IOException {
		super.searcherManager(input);
		//do I need this?
	}
}
