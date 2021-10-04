package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

import java.math.BigDecimal;
import java.util.*;

public class ProductDAO {
	
	private ArrayList<Product> allProducts = new ArrayList<>();
	
	public ProductDAO() {
		productsListSetup();
	}
	
	private void productsListSetup() {
		Food food = new Food("food", BigDecimal.valueOf(10), 20);
		Clothing clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		DryFood dryFood = new DryFood("dryFood", BigDecimal.valueOf(30), 40, "Brit", PetGroup.DOG);
		allProducts.add(food);
		allProducts.add(clothing);
		allProducts.add(dryFood);
	}
	
	public List<Product> getAllProductsList() {
		return allProducts;
	}
	
	public Product getProductByName(String name) {
		for (Product product : allProducts) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		throw new IllegalArgumentException("No such product name");
	}
	public Product getProductByIndex(Integer index) {
		return allProducts.get(index);
	}
}
