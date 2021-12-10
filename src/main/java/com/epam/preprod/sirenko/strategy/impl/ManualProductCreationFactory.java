package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.strategy.ProductCreationNoReflectionStrategy;
import com.epam.preprod.sirenko.strategy.ProductCreationUsingReflectionStrategy;
import com.epam.preprod.sirenko.strategy.StrategyFactory;

public class ManualProductCreationFactory implements StrategyFactory {
	@Override
	public ProductCreationNoReflectionStrategy createWithoutReflection() {
		return new ManualProductCreationStrategy();
	}
	
	@Override
	public ProductCreationUsingReflectionStrategy createUsingReflection() {
		return new ManualProductCreationUsingReflectionStrategy();
	}
}
