package com.epam.preprod.sirenko.strategy;

public interface StrategyFactory {
	ProductCreationNoReflectionStrategy createWithoutReflection();
	ProductCreationUsingReflectionStrategy createUsingReflection();
}
