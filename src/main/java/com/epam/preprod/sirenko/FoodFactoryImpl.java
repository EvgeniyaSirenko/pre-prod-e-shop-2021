package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;

public class FoodFactoryImpl implements CreateProductFactory {
	
	@Override
	public Product createProduct(Strategy strategy) {
		Food food = new Food();
		food.setName(strategy.getString());
		food.setPrice(strategy.getBigDecimal());
		food.setWeight(strategy.getInt());
		return food;
	}
}
