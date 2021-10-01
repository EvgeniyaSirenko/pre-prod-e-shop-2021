package com.epam.preprod.sirenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetConsoleInput {
	public static String inputString;
	
	public String readFromConsole() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		this.inputString = bufferedReader.readLine();
		return inputString;
	}
}
