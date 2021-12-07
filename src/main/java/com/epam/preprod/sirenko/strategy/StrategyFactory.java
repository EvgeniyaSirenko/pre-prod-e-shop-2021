package com.epam.preprod.sirenko.strategy;

public interface StrategyFactory {
	ProductCreationStrategy createWithoutReflection();
	ProductCreationUsingReflectionStrategy createUsingReflection();
}
