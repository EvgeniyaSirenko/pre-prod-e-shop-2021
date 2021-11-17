package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.impl.SerializationServiceImpl;

/**
 * This class serialises from file products list
 */
public class OnProgramStartSerializeProductsListCommand implements Command {
	private SerializationServiceImpl serializationServiceImpl;
	
	public OnProgramStartSerializeProductsListCommand(SerializationServiceImpl serializationServiceImpl) {
		this.serializationServiceImpl = serializationServiceImpl;
	}
	
	@Override
	public void execute() {
		serializationServiceImpl.serializeProductsListFromFile();
	}
}
