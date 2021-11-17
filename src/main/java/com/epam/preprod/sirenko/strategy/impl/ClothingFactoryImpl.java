package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.Strategy;

public class ClothingFactoryImpl implements CreateProductFactory {
	private Strategy strategy;
	
	public ClothingFactoryImpl(Strategy strategy) {
		this.strategy = strategy;
	}
	
	@Override
	public Product createProduct() {
		Clothing clothing = new Clothing();
		clothing.setSize(strategy.getSize());
		clothing.setSeason(strategy.getSeason());
		clothing.setName(strategy.getStringName());
		clothing.setPrice(strategy.getBigDecimal());
		return clothing;
	}
}
