package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.filesearcher.ChainBuilder;

import java.io.IOException;

public class FileSearcher {
	
	public static void main(String[] args) throws IOException {
		ChainBuilder chainBuilder = new ChainBuilder();
		chainBuilder.builder();
	}
}
