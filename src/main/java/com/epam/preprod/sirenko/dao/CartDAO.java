package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Product;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CartDAO {
	private static final int MAX_ENTRIES = 5;
	private Map<Product, Integer> cart = new HashMap<>();
	private Map<Product, Integer> cartCopy = new LinkedHashMap<>() {
		@Override
		protected boolean removeEldestEntry(Map.Entry<Product, Integer> eldest) {
			return cartCopy.size() > MAX_ENTRIES;
		}
	};
	
	public void addToCart(Product product) {
		Integer quantity = cart.get(product);
		if (quantity == null) {
			quantity = 0;
		}
		cart.put(product, quantity + 1);
		cartCopy.put(product, quantity + 1);
	}
	
	public Map<Product, Integer> getCartItems() {
		return cart;
	}
	
	public void clearCart() {
		cart = new HashMap<>();
	}

	public Map<Product, Integer> getMaxEntriesLastAddedToCart() {
		return cartCopy;
	}
}
