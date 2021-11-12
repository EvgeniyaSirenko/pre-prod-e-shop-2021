package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;

public class DryFoodFactoryImpl implements CreateProductFactory {
	
	@Override
	public Product createProduct(Strategy strategy) {
		DryFood dryFood = new DryFood();
		dryFood.setName(strategy.getStringName());
		dryFood.setPrice(strategy.getBigDecimal());
		dryFood.setWeight(strategy.getInt());
		dryFood.setBrandName(strategy.getStringBrandName());
		dryFood.setPetGroup(strategy.getPetGroup());
		return dryFood;
	}
}
