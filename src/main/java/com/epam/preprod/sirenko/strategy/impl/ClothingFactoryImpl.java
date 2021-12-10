package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.ProductCreationNoReflectionStrategy;

public class ClothingFactoryImpl implements CreateProductFactory {
	private ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy;
	
	public ClothingFactoryImpl(ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy) {
		this.productCreationNoReflectionStrategy = productCreationNoReflectionStrategy;
	}
	
	@Override
	public Product createProduct() {
		Clothing clothing = new Clothing();
		clothing.setSize(productCreationNoReflectionStrategy.getSize());
		clothing.setSeason(productCreationNoReflectionStrategy.getSeason());
		clothing.setName(productCreationNoReflectionStrategy.getStringName());
		clothing.setPrice(productCreationNoReflectionStrategy.getBigDecimal());
		return clothing;
	}
}
