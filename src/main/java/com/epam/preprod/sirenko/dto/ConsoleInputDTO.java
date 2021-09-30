package com.epam.preprod.sirenko.dto;

import com.epam.preprod.sirenko.GetConsoleInput;

public class ConsoleInputDTO {
	GetConsoleInput getConsoleInput;
	
	public ConsoleInputDTO(GetConsoleInput getConsoleInput) {
		this.getConsoleInput = getConsoleInput;
	}
	
	public GetConsoleInput getGetConsoleInput() {
		return getConsoleInput;
	}
	
	public void setGetConsoleInput(GetConsoleInput getConsoleInput) {
		this.getConsoleInput = getConsoleInput;
	}
	
	public void getInput() {
		getConsoleInput.getInputString();
	}
}
