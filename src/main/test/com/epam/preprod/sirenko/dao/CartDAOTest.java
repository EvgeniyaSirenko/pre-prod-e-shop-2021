package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartDAOTest {
	private static Map<Product, Integer> cart;
	private static Map<Product, Integer> testCart;
	private static Food food;
	private static Food otherFood;
	
	@BeforeAll
	static void setData() {
		cart = new HashMap<>();
		testCart = new HashMap<>();
		food = new Food("food", BigDecimal.valueOf(10), 20);
		otherFood = new Food("otherFood", BigDecimal.valueOf(40), 30);
	}
	
	@Test
	void testAddToCartShouldAddProductToCart() {
		CartDAO cartDAO = new CartDAO();
		testCart.put(food, 1);
		
		cartDAO.addToCart(food);
		
		assertEquals(testCart.size(), cartDAO.getCartItems().size());
		assertEquals(testCart.get(food), cartDAO.getCartItems().get(food));
	}
	
	@Test
	void getCartItems() {
		CartDAO cartDAO = new CartDAO();
		
	}
	
	@Test
	void testClearCartShouldClearCart() {
		CartDAO cartDAO = new CartDAO();
		cartDAO.addToCart(food);
		
		cartDAO.clearCart();
		
		assertEquals(0, cartDAO.getCartItems().size());
	}
	
	@Test
	void getEntriesLastAddedToCart() {
	}
}