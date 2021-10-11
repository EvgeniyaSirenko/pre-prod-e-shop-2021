package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CartDAOTest {
	private static Food food;
	private static Food otherFood;
	private static Clothing clothing;
	private static Clothing otherClothing;
	private static DryFood dryFood;
	private static DryFood otherDryFood;
	
	@BeforeAll
	static void setData() {
		food = new Food("food", BigDecimal.valueOf(10), 20);
		otherFood = new Food("otherFood", BigDecimal.valueOf(40), 30);
		clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		otherClothing = new Clothing("otherClothing", BigDecimal.valueOf(50), Size.M, Season.SPRING_AUTUMN);
		dryFood = new DryFood("dryFood", BigDecimal.valueOf(30), 40, "Brit", PetGroup.DOG);
		otherDryFood = new DryFood("otherDryFood", BigDecimal.valueOf(60), 50, "Royal", PetGroup.CAT);
		
	}
	
	@Test
	void testAddToCartShouldAddProductToCart() {
		CartDAO cartDAO = new CartDAO();
		
		cartDAO.addToCart(food);
		
		assertEquals(1, cartDAO.getCartItems().size());
		assertEquals(1, cartDAO.getCartItems().get(food));
	}
	
	@Test
	void testAddToCartShouldThrowExceptionIfProductIsNull() {
		CartDAO cartDAO = new CartDAO();
		
		assertThrows(IllegalArgumentException.class, () -> {
			cartDAO.addToCart(null);
		});
	}
	
	@Test
	void testGetCartItemsShouldGetMapOfItems() {
		CartDAO cartDAO = new CartDAO();
		cartDAO.addToCart(food);
		cartDAO.addToCart(otherFood);
		cartDAO.addToCart(food);
		
		
		assertEquals(2, cartDAO.getCartItems().size());
		assertEquals(2, cartDAO.getCartItems().get(food));
		assertEquals(1, cartDAO.getCartItems().get(otherFood));
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
		CartDAO cartDAO = new CartDAO();
		cartDAO.addToCart(food);
		cartDAO.addToCart(otherFood);
		cartDAO.addToCart(clothing);
		cartDAO.addToCart(otherClothing);
		cartDAO.addToCart(dryFood);
		cartDAO.addToCart(otherDryFood);
		
		
		Map<Product, Integer> cache = cartDAO.getEntriesLastAddedToCart();
		
		assertEquals(5, cache.size());
		assertNull(cache.get(food));
	}
}