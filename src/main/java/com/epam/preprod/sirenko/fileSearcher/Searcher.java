package com.epam.preprod.sirenko.fileSearcher;

import java.io.IOException;

public abstract class Searcher {
	int choice;
	private Searcher searcher;
	
	public Searcher(int choice) {
		this.choice = choice;
	}
	
	abstract Integer getConsoleInput() throws IOException;
	
	public void searcherManager(Integer input) throws IOException {
		if (input == 0) {
		getConsoleInput();
		}
		if (searcher != null) {
		searcher.searcherManager(input);
		}
	}
}
