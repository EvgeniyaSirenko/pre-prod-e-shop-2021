package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

import java.math.BigDecimal;
import java.util.*;

public class ProductDAO {
	
	private Map<Integer, Product> productsSetup() {
		Food food = new Food("food", BigDecimal.valueOf(10), 20);
		Clothing clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		Integer id = 1;
		Map<Integer, Product> productMap = new HashMap<>();
		productMap.put(id++, food);
		productMap.put(id++, clothing);
		System.out.println("productsSetup");
		
		return productMap;
	}
	
	public List<Product> getAllProductsList() {
		Collection<Product> products = productsSetup().values();
		List<Product> productsList = new ArrayList<>();
		productsList.addAll(products);
		return productsList;
	}
}
