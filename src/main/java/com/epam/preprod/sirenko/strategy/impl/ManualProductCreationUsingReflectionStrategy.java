package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import com.epam.preprod.sirenko.strategy.ProductCreationUsingReflectionStrategy;

import java.math.BigDecimal;

public class ManualProductCreationUsingReflectionStrategy implements ProductCreationUsingReflectionStrategy {
	@Override
	public PetGroup getPetGroup() {
		return null;
	}
	
	@Override
	public Season getSeason() {
		return null;
	}
	
	@Override
	public Size getSize() {
		return null;
	}
	
	@Override
	public String getStringName() {
		return null;
	}
	
	@Override
	public String getStringBrandName() {
		return null;
	}
	
	@Override
	public int getInt() {
		return 0;
	}
	
	@Override
	public BigDecimal getBigDecimal() {
		return null;
	}
}