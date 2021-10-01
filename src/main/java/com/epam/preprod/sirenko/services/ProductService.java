package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.util.List;

public class ProductService {
	ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProductsList();
	}
	
	public Product getProductByName(String name) {
		return productDAO.getProductByName(name);
	}
}
