package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.containers.CommandContainer;
import com.epam.preprod.sirenko.dto.ConsoleInputDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetConsoleInput {
	String inputString;
	
	public GetConsoleInput() {
	}
	
	public GetConsoleInput(String inputString) {
		this.inputString = inputString;
	}
	
	public String getInputString() {
		return inputString;
	}
	
	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	
	public String readFromConsole() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		this.inputString = bufferedReader.readLine();
		System.out.println("under while " + inputString);
		while (!inputString.equals(String.valueOf(1))) {
			inputString = bufferedReader.readLine();
			System.out.println("in " + inputString);
			CommandContainer commandContainer = new CommandContainer();
			
			//System.out.println("get " + Integer.valueOf(inputString));
			//commandContainer.getCommand(Integer.valueOf(inputString)).execute();
		}
		System.out.println("out " + inputString);
		return inputString;
	}
}
