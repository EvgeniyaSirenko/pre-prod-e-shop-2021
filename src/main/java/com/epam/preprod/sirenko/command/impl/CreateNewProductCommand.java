package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.containers.FactoryContainer;
import com.epam.preprod.sirenko.services.ProductService;
import com.epam.preprod.sirenko.util.ConsoleReader;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.IOException;

public class CreateNewProductCommand implements Command {
	private static final String CHOOSE_CATEGORY = "Print category name end press Enter";
	private static final String INCORRECT_INPUT_CATEGORY_NAME = "No such category, try again";
	private ProductService productService;
	private FactoryContainer factoryContainer;
	
	public CreateNewProductCommand(ProductService productService, FactoryContainer factoryContainer) {
		this.productService = productService;
		this.factoryContainer = factoryContainer;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printSet(factoryContainer.getCategoriesList());
		PrintToConsole.printString(CHOOSE_CATEGORY);
		try {
			String inputCategory = ConsoleReader.readFromConsole();
			if (!factoryContainer.getCategoriesList().contains(inputCategory)) {
				PrintToConsole.printString(INCORRECT_INPUT_CATEGORY_NAME);
				return;
			}
			CreateProductFactory createProductFactory = factoryContainer.getFactory(inputCategory);
			productService.createNewProduct(createProductFactory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
