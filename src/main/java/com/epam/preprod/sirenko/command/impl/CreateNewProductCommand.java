package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.AutoGeneratedProductImpl;
import com.epam.preprod.sirenko.CreatedByInputProductImpl;
import com.epam.preprod.sirenko.Strategy;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.containers.FactoryContainer;
import com.epam.preprod.sirenko.services.ProductService;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.util.ValidatorOfConsoleInput;

import java.io.IOException;

public class CreateNewProductCommand implements Command {
	private static final String CHOOSE_STRATEGY = "To create product print 0, to autogenerate product print 1";
	private static final String CHOOSE_CATEGORY = "Print category name end press Enter";
	private static final String INCORRECT_INPUT_CATEGORY_NAME = "No such category, try again";
	private static final String INCORRECT_INPUT_ONE_OR_ZERO = "Please print only 0 or 1";
	private ProductService productService;
	
	public CreateNewProductCommand(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public void execute() {
		FactoryContainer factoryContainer = new FactoryContainer();
		PrintToConsole.printSet(factoryContainer.getCategoriesList());
		PrintToConsole.printString(CHOOSE_CATEGORY);
		try {
			String inputCategory = ConsoleReader.readFromConsole();
			if (!factoryContainer.getCategoriesList().contains(inputCategory)) {
				PrintToConsole.printString(INCORRECT_INPUT_CATEGORY_NAME);
				return;
			}
			PrintToConsole.printString(CHOOSE_STRATEGY);
			String inputStrategy = ConsoleReader.readFromConsole();
			if (!ValidatorOfConsoleInput.checkInputStringIsNumberOneOrZero(inputStrategy)) {
				PrintToConsole.printString(INCORRECT_INPUT_ONE_OR_ZERO);
				inputStrategy = ConsoleReader.readFromConsole();
				Strategy strategy;
				if (inputStrategy.matches("[0]")) {
					strategy = new CreatedByInputProductImpl();
				} else {
					strategy = new AutoGeneratedProductImpl();
				}
				productService.createNewProduct(strategy, inputCategory);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
