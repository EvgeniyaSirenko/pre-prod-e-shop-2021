package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDAOTest {
	private ArrayList<Product> allProducts;
	private Food food;
	private Food otherFood;
	private Clothing clothing;
	private Clothing otherClothing;
	private DryFood dryFood;
	private DryFood otherDryFood;
	private ProductDAO productDAO;
	
	@BeforeEach
	void setData() {
		allProducts = new ArrayList<>();
		productDAO = new ProductDAO();
		food = new Food("food", BigDecimal.valueOf(10), 20);
		otherFood = new Food("otherFood", BigDecimal.valueOf(40), 30);
		clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		otherClothing = new Clothing("otherClothing", BigDecimal.valueOf(50), Size.M, Season.SPRING_AUTUMN);
		dryFood = new DryFood("dryFood", BigDecimal.valueOf(30), 40, "Brit", PetGroup.DOG);
		otherDryFood = new DryFood("otherDryFood", BigDecimal.valueOf(60), 50, "Royal", PetGroup.CAT);
		allProducts.add(food);
		allProducts.add(otherFood);
		allProducts.add(clothing);
		allProducts.add(otherClothing);
		allProducts.add(dryFood);
		allProducts.add(otherDryFood);
	}
	
	@Test
	void testGetAllProductsListShouldGetAllProductsList() {
		productDAO.getAllProductsList();
		
		assertEquals(allProducts, productDAO.getAllProductsList());
	}
}