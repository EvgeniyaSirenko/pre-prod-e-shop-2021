package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.containers.FactoryContainer;
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
	private FactoryContainer factoryContainer;
	
	public ProductService(ProductDAO productDAO, FactoryContainer factoryContainer) {
		this.productDAO = productDAO;
		this.factoryContainer = factoryContainer;
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProductsList();
	}
	
	public void createNewProduct(String inputCategory) {
		CreateProductFactory createProductFactory = factoryContainer.getFactory(inputCategory);
		Product product = createProductFactory.createProduct();
		productDAO.addProduct(product);
		PrintToConsole.printString("New product successfully created");
	}
}