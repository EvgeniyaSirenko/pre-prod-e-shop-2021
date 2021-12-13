package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.strategy.ProductCreationNoReflectionStrategy;
import com.epam.preprod.sirenko.strategy.impl.ClothingFactoryImpl;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.impl.DryFoodFactoryImpl;
import com.epam.preprod.sirenko.strategy.impl.FoodFactoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FactoryContainer {
	private Map<String, CreateProductFactory> factories = new HashMap<>();
	
	public FactoryContainer(ProductCreationNoReflectionStrategy strategy) {
		init(strategy);
	}
	
	private void init(ProductCreationNoReflectionStrategy productCreationNoReflectionStrategy) {
		FoodFactoryImpl foodFactory = new FoodFactoryImpl(productCreationNoReflectionStrategy);
		DryFoodFactoryImpl dryFoodFactory = new DryFoodFactoryImpl(productCreationNoReflectionStrategy);
		ClothingFactoryImpl clothingFactory = new ClothingFactoryImpl(productCreationNoReflectionStrategy);
		factories.put("food", foodFactory);
		factories.put("dryFood", dryFoodFactory);
		factories.put("clothing", clothingFactory);
	}
	
	public CreateProductFactory getFactory(String factoryName) {
		return factories.get(factoryName);
	}
	
	public Set<String> getCategoriesList() {
		return factories.keySet();
	}
}
