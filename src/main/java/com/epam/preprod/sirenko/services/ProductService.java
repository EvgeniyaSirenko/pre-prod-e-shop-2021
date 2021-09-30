package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.ProductDAO;

public class ProductService {
	ProductDAO productDAO;
	
	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
}
