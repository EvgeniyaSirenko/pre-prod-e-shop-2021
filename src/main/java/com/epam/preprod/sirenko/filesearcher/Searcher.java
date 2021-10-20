package com.epam.preprod.sirenko.filesearcher;

import java.io.File;
import java.util.List;

public abstract class Searcher {
	String input;
	private Searcher nextSearcher;
	
	protected Searcher(String input) {
		this.input = input;
	}
	
	abstract List<File> filter(Searcher searcher);
	
	public void setNextFilter(String input) {
		filter(nextSearcher);
		if (nextSearcher != null) {
		nextSearcher.setNextFilter(input);
		} else {
	//TODO
		}
	}
}
