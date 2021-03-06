package com.epam.preprod.sirenko.command.impl;

import com.epam.preprod.sirenko.util.PrintToConsole;
import com.epam.preprod.sirenko.command.Command;
import com.epam.preprod.sirenko.services.ProductService;

/**
 * This class calls productService to print to console all products
 */
public class GetProductsListCommand implements Command {
	private ProductService productService;
	
	public GetProductsListCommand(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public void execute() {
		PrintToConsole.printList(productService.getAllProducts());
	}
}
