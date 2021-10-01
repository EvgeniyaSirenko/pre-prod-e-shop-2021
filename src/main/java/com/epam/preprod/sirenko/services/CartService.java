package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.CartDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.util.Map;

public class CartService {
	CartDAO cartDAO;
	
	public CartService(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}
	
	public void addProductToCart() {
		cartDAO.addToCart();
	}
	
	public Map<Product, Integer> getCartItems() {
		return cartDAO.getCartItems();
	}
}
