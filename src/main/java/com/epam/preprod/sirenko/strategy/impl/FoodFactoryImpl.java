package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.ProductCreationNoReflectionStrategy;

public class FoodFactoryImpl implements CreateProductFactory {
	private ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy;
	
	public FoodFactoryImpl(ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy) {
		this.productCreationNoReflectionStrategy = productCreationNoReflectionStrategy;
	}
	
	@Override
	public Product createProduct() {
		Food food = new Food();
		food.setName(productCreationNoReflectionStrategy.getStringName());
		food.setPrice(productCreationNoReflectionStrategy.getBigDecimal());
		food.setWeight(productCreationNoReflectionStrategy.getInt());
		return food;
	}
}
