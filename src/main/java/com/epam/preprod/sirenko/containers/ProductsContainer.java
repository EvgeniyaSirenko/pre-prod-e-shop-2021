package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates list of products
 */
public class ProductsContainer implements Serializable {
	private List<Product> allProducts = new ArrayList<>();
	
	public ProductsContainer() {
		init();
	}
	
	private void init() {
		Food food = new Food("food", BigDecimal.valueOf(10), 20);
		Food otherFood = new Food("otherFood", BigDecimal.valueOf(40), 30);
		Clothing clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		Clothing otherClothing = new Clothing("otherClothing", BigDecimal.valueOf(50), Size.M, Season.SPRING_AUTUMN);
		DryFood dryFood = new DryFood("dryFood", BigDecimal.valueOf(30), 40, "Brit", PetGroup.DOG);
		DryFood otherDryFood = new DryFood("otherDryFood", BigDecimal.valueOf(60), 50, "Royal", PetGroup.CAT);
		allProducts.add(food);
		allProducts.add(otherFood);
		allProducts.add(clothing);
		allProducts.add(otherClothing);
		allProducts.add(dryFood);
		allProducts.add(otherDryFood);
	}
	
	public List<Product> getAllProductsList() {
		return allProducts;
	}
	
	public void setAllProductsList(List<Product> newProducts) {
		allProducts = newProducts;
	}
	
	public void addProductToList(Product newProduct) {
		allProducts.add(newProduct);
	}
}
