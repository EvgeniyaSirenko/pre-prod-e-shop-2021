package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.CartDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.util.Map;

public class CartService {
	private CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
	public void addProductToCart(Product product) {
		cartDAO.addToCart(product);
	}
	
	public Map<Product, Integer> getCartItems() {
		return cartDAO.getCartItems();
	}
	
	public void clearCart() {
		cartDAO.clearCart();
	}
	
	public Map<Product, Integer> getFiveLastAddedProductsToCart() {
		return cartDAO.getFiveLastAddedProductsToCart();
	}
}
