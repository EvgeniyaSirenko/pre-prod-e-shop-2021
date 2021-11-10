package com.epam.preprod.sirenko.containers;

import com.epam.preprod.sirenko.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FactoryContainer {
	private Map<String, CreateProductFactory> factories = new HashMap<>();
	
	public FactoryContainer() {
		init();
	}
	
	private void init() {
		FoodFactoryImpl foodFactory = new FoodFactoryImpl();
		DryFoodFactoryImpl dryFoodFactory = new DryFoodFactoryImpl();
		ClothingFactoryImpl clothingFactory = new ClothingFactoryImpl();
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
