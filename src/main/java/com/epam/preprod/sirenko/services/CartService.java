package com.epam.preprod.sirenko.services;

import com.epam.preprod.sirenko.dao.CartDAO;
import com.epam.preprod.sirenko.entity.Product;

import java.math.BigDecimal;
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
	
	public Map<Product, Integer> getMaxEntriesLastAddedToCart() {
		return cartDAO.getMaxEntriesLastAddedToCart();
	}
	
	public BigDecimal getOrderTotalPrice() {
		BigDecimal sum = BigDecimal.valueOf(0);
		for (Map.Entry<Product, Integer> set : cartDAO.getCartItems().entrySet()) {
			if (set.getValue() > 1) {
				sum = set.getKey().getPrice().multiply(BigDecimal.valueOf(set.getValue())).add(sum);
			} else {
				sum = set.getKey().getPrice().add(sum);
			}
		}
		return sum;
	}
}
