package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.strategy.ProductCreationStrategy;
import com.epam.preprod.sirenko.strategy.ProductCreationUsingReflectionStrategy;
import com.epam.preprod.sirenko.strategy.StrategyFactory;

public class AutoGeneratedProductFactory implements StrategyFactory {
	@Override
	public ProductCreationStrategy createWithoutReflection() {
		return new AutoGeneratedProductCreationStrategy();
	}
	
	@Override
	public ProductCreationUsingReflectionStrategy createUsingReflection() {
		return new AutoGeneratedProductCreationUsingReflectionStrategy();
	}
}
