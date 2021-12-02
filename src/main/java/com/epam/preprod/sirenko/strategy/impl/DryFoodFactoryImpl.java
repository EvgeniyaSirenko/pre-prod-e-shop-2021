package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.Strategy;

public class DryFoodFactoryImpl implements CreateProductFactory {
	private Strategy strategy;
	
	public DryFoodFactoryImpl(Strategy strategy) {
		this.strategy = strategy;
	}
	
	@Override
	public Product createProduct() {
		DryFood dryFood = new DryFood();
		dryFood.setName(strategy.getStringName());
		dryFood.setPrice(strategy.getBigDecimal());
		dryFood.setWeight(strategy.getInt());
		dryFood.setBrandName(strategy.getStringBrandName());
		dryFood.setPetGroup(strategy.getPetGroup());
		return dryFood;
	}
}