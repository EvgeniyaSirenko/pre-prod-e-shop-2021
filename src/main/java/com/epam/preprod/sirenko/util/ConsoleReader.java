package com.epam.preprod.sirenko.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	public String readFromConsole() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}
}
