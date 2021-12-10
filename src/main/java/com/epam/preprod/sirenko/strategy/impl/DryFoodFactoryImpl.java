package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.ProductCreationNoReflectionStrategy;

public class DryFoodFactoryImpl implements CreateProductFactory {
	private ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy;
	
	public DryFoodFactoryImpl(ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy) {
		this.productCreationNoReflectionStrategy = productCreationNoReflectionStrategy;
	}
	
	@Override
	public Product createProduct() {
		DryFood dryFood = new DryFood();
		dryFood.setName(productCreationNoReflectionStrategy.getStringName());
		dryFood.setPrice(productCreationNoReflectionStrategy.getBigDecimal());
		dryFood.setWeight(productCreationNoReflectionStrategy.getInt());
		dryFood.setBrandName(productCreationNoReflectionStrategy.getStringBrandName());
		dryFood.setPetGroup(productCreationNoReflectionStrategy.getPetGroup());
		return dryFood;
	}
}