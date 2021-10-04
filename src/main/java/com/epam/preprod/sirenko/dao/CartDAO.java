package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartDAO {
	private Map<Product, Integer> cart = new LinkedHashMap<>();
	
	public void addToCart(Product product) {
		if (cart.get(product) == null) {
			cart.put(product, 1);
			return;
		}
		cart.put(product, cart.get(product) + 1);
	}
	
	public Map<Product, Integer> getCartItems() {
		return cart;
	}
	
	public void clearCart() {
		cart = new LinkedHashMap<>();
	}
}
