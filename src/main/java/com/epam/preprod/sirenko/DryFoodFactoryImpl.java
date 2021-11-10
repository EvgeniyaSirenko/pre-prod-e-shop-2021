package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;

public class DryFoodFactoryImpl implements CreateProductFactory {
	
	@Override
	public Product createProduct(Strategy strategy) {
		DryFood dryFood = new DryFood();
		dryFood.setName(strategy.getString());
		dryFood.setPrice(strategy.getBigDecimal());
		dryFood.setWeight(strategy.getInt());
		dryFood.setBrandName(strategy.getString());
		dryFood.setPetGroup((PetGroup) strategy.getEnum());
		return dryFood;
	}
}
