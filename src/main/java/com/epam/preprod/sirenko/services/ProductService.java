package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.util.List;

/**
 * This class is for work with ProductDAO
 */
public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProductsList();
	}
}
