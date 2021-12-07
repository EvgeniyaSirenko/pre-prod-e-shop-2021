package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.strategy.ProductFieldsAnnotation;
import com.epam.preprod.sirenko.strategy.ProductCreationStrategy;

import java.lang.reflect.Field;

public class DryFoodFactoryWithReflection {
	private ProductCreationStrategy strategy;
	
	public DryFoodFactoryWithReflection(ProductCreationStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Product createProduct() {
		try {
			Field f = DryFood.class.getDeclaredField("brandName");
			ProductFieldsAnnotation annotation = f.getAnnotation(ProductFieldsAnnotation.class);
			System.out.println(annotation.title() + ":"); // from example just to test
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		//TODO annotations not finished
		
		DryFood dryFood = new DryFood();
		return dryFood;	}
}