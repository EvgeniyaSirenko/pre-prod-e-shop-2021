package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.GetConsoleInput;
import com.epam.preprod.sirenko.PrintToConsole;
import com.epam.preprod.sirenko.entity.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartDAO {
	private Map<Product, Integer> cart = new LinkedHashMap<>();
	
	public void addToCart() {
		ProductDAO productDAO = new ProductDAO();
		Product productToAdd = productDAO.getProductByName(GetConsoleInput.inputString);
		Integer quantity = 1;
		if (cart.containsKey(productToAdd)) {
			cart.put(productToAdd, ++quantity);
		}
		cart.put(productToAdd, quantity);
		System.out.println(cart.size());
		for (int i = 0; i < cart.size(); i++) {
			System.out.println("first added " + cart.keySet());
			
		}
	}
	
	public Map<Product, Integer> getCartItems() {
		PrintToConsole.printMap(cart);
		return cart;
	}
}
