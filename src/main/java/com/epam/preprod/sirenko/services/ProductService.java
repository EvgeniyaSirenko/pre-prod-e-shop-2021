package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.CreateProductFactory;
import com.epam.preprod.sirenko.Strategy;
import com.epam.preprod.sirenko.containers.FactoryContainer;
import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.entity.Product;

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
	
	public void createNewProduct(Strategy strategy, String factoryName) {
		FactoryContainer factoryContainer = new FactoryContainer();
		CreateProductFactory createProductFactory = factoryContainer.getFactory(factoryName);
		Product product = createProductFactory.createProduct(strategy);
		productDAO.addProduct(product);
	}
}
