package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.services.impl.SerializationServiceImpl;
import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;

/**
 * This class prints to console message that program is stopped
 */
public class ExitProgramCommand implements Command {
	private SerializationServiceImpl serializationServiceImpl;
	
	public ExitProgramCommand(SerializationServiceImpl serializationServiceImpl) {
		this.serializationServiceImpl = serializationServiceImpl;
	}
	
	@Override
	public void execute() {
		serializationServiceImpl.serializeProductsListToFile();
		PrintToConsole.printString("Program is stopped");
	}
}
