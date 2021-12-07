package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.ProductCreationStrategy;

public class FoodFactoryImpl implements CreateProductFactory {
	private ProductCreationStrategy productCreationStrategy;
	
	public FoodFactoryImpl(ProductCreationStrategy productCreationStrategy) {
		this.productCreationStrategy = productCreationStrategy;
	}
	
	@Override
	public Product createProduct() {
		Food food = new Food();
		food.setName(productCreationStrategy.getStringName());
		food.setPrice(productCreationStrategy.getBigDecimal());
		food.setWeight(productCreationStrategy.getInt());
		return food;
	}
}
