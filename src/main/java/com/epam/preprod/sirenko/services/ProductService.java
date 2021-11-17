package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.util.PrintToConsole;

import java.io.Serializable;
import java.util.List;

/**
 * This class is for work with ProductDAO
 */
public class ProductService implements Serializable {
	private ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProductsList();
	}
	
	public void createNewProduct(CreateProductFactory createProductFactory) {
		Product product = createProductFactory.createProduct();
		productDAO.addProduct(product);
		PrintToConsole.printString("New product successfully created");
	}
}
