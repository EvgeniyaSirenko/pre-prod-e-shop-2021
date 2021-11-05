package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.containers.CommandContainer;
import com.epam.preprod.sirenko.services.impl.SerializationServiceImpl;
import com.epam.preprod.sirenko.util.ConsoleReader;

import java.io.*;

public class Demo {
	private SerializationServiceImpl serializationServiceImpl;
	
	public Demo(SerializationServiceImpl serializationServiceImpl) {
		this.serializationServiceImpl = serializationServiceImpl;
		init();
	}
	
	private void init() {
		serializationServiceImpl.serializedProductsListOutOfFile();
	}
	
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
