package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.containers.CommandContainer;

import java.io.*;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		CommandContainer commandContainer = new CommandContainer();
		while (true) {
			commandContainer.getCommand("menu").execute();
			String commandName = ConsoleReader.readFromConsole();
			if (commandName.equals("out")) {
				commandContainer.getCommand("out").execute();
				return;
			}
			commandContainer.getCommand(commandName).execute();
		}
	}
}
