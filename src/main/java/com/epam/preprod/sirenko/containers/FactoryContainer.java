package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.strategy.Strategy;
import com.epam.preprod.sirenko.strategy.impl.ClothingFactoryImpl;
import com.epam.preprod.sirenko.strategy.CreateProductFactory;
import com.epam.preprod.sirenko.strategy.impl.DryFoodFactoryImpl;
import com.epam.preprod.sirenko.strategy.impl.FoodFactoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FactoryContainer {
	private Map<String, CreateProductFactory> factories = new HashMap<>();
	private Strategy strategy;
	
	public FactoryContainer(Strategy strategy) {
		this.strategy = strategy;
		init();
	}
	
	private void init() {
		FoodFactoryImpl foodFactory = new FoodFactoryImpl(strategy);
		DryFoodFactoryImpl dryFoodFactory = new DryFoodFactoryImpl(strategy);
		ClothingFactoryImpl clothingFactory = new ClothingFactoryImpl(strategy);
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
