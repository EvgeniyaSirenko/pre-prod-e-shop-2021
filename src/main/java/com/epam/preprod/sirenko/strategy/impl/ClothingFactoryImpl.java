package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.ProductCreationStrategy;

public class ClothingFactoryImpl implements CreateProductFactory {
	private ProductCreationStrategy productCreationStrategy;
	
	public ClothingFactoryImpl(ProductCreationStrategy productCreationStrategy) {
		this.productCreationStrategy = productCreationStrategy;
	}
	
	@Override
	public Product createProduct() {
		Clothing clothing = new Clothing();
		clothing.setSize(productCreationStrategy.getSize());
		clothing.setSeason(productCreationStrategy.getSeason());
		clothing.setName(productCreationStrategy.getStringName());
		clothing.setPrice(productCreationStrategy.getBigDecimal());
		return clothing;
	}
}
