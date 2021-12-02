package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.Strategy;

public class FoodFactoryImpl implements CreateProductFactory {
	private Strategy strategy;
	
	public FoodFactoryImpl(Strategy strategy) {
		this.strategy = strategy;
	}
	
	@Override
	public Product createProduct() {
		Food food = new Food();
		food.setName(strategy.getStringName());
		food.setPrice(strategy.getBigDecimal());
		food.setWeight(strategy.getInt());
		return food;
	}
}
