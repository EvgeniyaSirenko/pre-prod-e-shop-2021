package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.GetConsoleInput;
import com.epam.preprod.sirenko.dao.ProductDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.util.List;

public class GetAllProductsListService {
	ProductDAO productDAO;
	
	public GetAllProductsListService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProductsList();
	}
}
