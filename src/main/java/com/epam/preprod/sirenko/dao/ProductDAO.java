package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.containers.ProductsContainer;
import com.epam.preprod.sirenko.entity.Product;

import java.io.Serializable;
import java.util.*;

/**
 * This class works with product entity
 */
public class ProductDAO implements Serializable {
	private ProductsContainer productsContainer = new ProductsContainer();
	
	public List<Product> getAllProductsList() {
		return productsContainer.getAllProductsList();
	}
	
	public void setProductsList(List<Product> newProducts) {
		productsContainer.setAllProductsList(newProducts);
	}
	
	public void addProduct(Product newProduct) {
		productsContainer.addProductToList(newProduct);
	}
}