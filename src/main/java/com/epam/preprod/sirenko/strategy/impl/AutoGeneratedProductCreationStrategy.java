package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import com.epam.preprod.sirenko.strategy.Strategy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class AutoGeneratedProductCreationStrategy implements Strategy {
	private static final int BOUND_THOUSAND = 1000;
	private static final int BOUND_HUNDRED_THOUSAND = 100000;
	private final Random random = new Random();
	private final char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	@Override
	public PetGroup getPetGroup() {
		return PetGroup.values()[random.nextInt(PetGroup.values().length)];
	}
	
	@Override
	public Season getSeason() {
		return Season.values()[random.nextInt(Season.values().length)];
	}
	
	@Override
	public Size getSize() {
		return Size.values()[random.nextInt(Size.values().length)];
	}
	
	@Override
	public String getStringName() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			char letter = alphabet[random.nextInt(alphabet.length)];
			stringBuilder.append(letter);
		}
		return stringBuilder.toString();
	}
	
	@Override
	public String getStringBrandName() {
		return getStringName();
	}
	
	@Override
	public int getInt() {
		return random.nextInt(BOUND_THOUSAND);
	}
	
	@Override
	public BigDecimal getBigDecimal() {
		return new BigDecimal(BigInteger.valueOf(random.nextInt(BOUND_HUNDRED_THOUSAND)), 2);
	}
}