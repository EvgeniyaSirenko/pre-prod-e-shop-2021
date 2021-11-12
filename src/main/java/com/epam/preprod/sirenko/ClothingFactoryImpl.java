package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;

public class ClothingFactoryImpl implements CreateProductFactory {
	
	@Override
	public Product createProduct(Strategy strategy) {
		Clothing clothing = new Clothing();
		clothing.setSize(strategy.getSize());
		clothing.setSeason(strategy.getSeason());
		clothing.setName(strategy.getStringName());
		clothing.setPrice(strategy.getBigDecimal());
		return clothing;
	}
}
