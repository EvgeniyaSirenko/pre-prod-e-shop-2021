package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.services.ProductService;

public class GetProductsListCommand implements Command {
	ProductService productService;
	
	public GetProductsListCommand(ProductService productService) {
		this.productService = productService;
	}
	
	@Override
	public void execute() {
		productService.getAllProducts();
	}
}
