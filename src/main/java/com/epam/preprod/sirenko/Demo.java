package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.containers.CommandContainer;
import com.epam.preprod.sirenko.dao.ProductDAO;

import java.io.*;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		CommandContainer commandContainer = new CommandContainer();
		//TODO without line 13 I don't have productsList, Sonar says it's useless
		ProductDAO productDAO = new ProductDAO();
		GetConsoleInput getConsoleInput = new GetConsoleInput();
		PrintToConsole.printInstruction();
		while (true) {
			if (getConsoleInput.readFromConsole().equals("out")) {
				commandContainer.getCommand("out").execute();
				return;
			}
			//TODO this if statement is to check add command
//			if (GetConsoleInput.inputString.equals("food")) {
//				commandContainer.getCommand("addProductToCart").execute();
//				// without line 25 I get error out of line 28
//				getConsoleInput.readFromConsole();
//			}
			PrintToConsole.printInstruction();
			commandContainer.getCommand(GetConsoleInput.inputString).execute();
		}
	}
}
