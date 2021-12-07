package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.ProductCreationStrategy;

public class DryFoodFactoryImpl implements CreateProductFactory {
	private ProductCreationStrategy productCreationStrategy;
	
	public DryFoodFactoryImpl(ProductCreationStrategy productCreationStrategy) {
		this.productCreationStrategy = productCreationStrategy;
	}
	
	@Override
	public Product createProduct() {
		DryFood dryFood = new DryFood();
		dryFood.setName(productCreationStrategy.getStringName());
		dryFood.setPrice(productCreationStrategy.getBigDecimal());
		dryFood.setWeight(productCreationStrategy.getInt());
		dryFood.setBrandName(productCreationStrategy.getStringBrandName());
		dryFood.setPetGroup(productCreationStrategy.getPetGroup());
		return dryFood;
	}
}