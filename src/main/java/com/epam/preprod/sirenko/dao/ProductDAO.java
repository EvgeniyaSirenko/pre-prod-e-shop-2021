package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.containers.ProductsContainer;
import com.epam.preprod.sirenko.entity.Product;

import java.util.*;

/**
 * This class works with product entity
 */
public class ProductDAO {
	private ProductsContainer productsContainer = new ProductsContainer();
	
	public List<Product> getAllProductsList() {
		return productsContainer.getAllProductsList();
	}
	
	public void setProductsList(List<Product> newProducts) {
		productsContainer.setAllProductsList(newProducts);
	}
}
