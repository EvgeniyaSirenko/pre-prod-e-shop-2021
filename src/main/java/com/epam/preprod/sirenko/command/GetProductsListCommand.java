package com.epam.preprod.sirenko.command;

import com.epam.preprod.sirenko.services.GetAllProductsListService;
import com.epam.preprod.sirenko.services.ProductService;

public class GetProductsListCommand implements Command{
	//ProductService productService;
	GetAllProductsListService getAllProductsList;
	
	public GetProductsListCommand(GetAllProductsListService getAllProductsList) {
		//this.productService = productService;
		this.getAllProductsList = getAllProductsList;
	}
	
	@Override
	public void execute() {
	getAllProductsList.getAllProducts();
	}
}
