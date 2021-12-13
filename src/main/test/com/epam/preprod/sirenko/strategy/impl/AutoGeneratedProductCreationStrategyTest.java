package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class AutoGeneratedProductCreationStrategyTest {
	private final char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	@InjectMocks
	private AutoGeneratedProductCreationStrategy autoGeneratedProductCreationStrategy;
	
	@Mock
	private Random random;
	
	@BeforeEach
	public void SetData() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void getPetGroupShouldReturnPetGroup() {
		PetGroup petGroup = PetGroup.values()[2];
		when(random.nextInt(anyInt())).thenReturn(2);
		
		assertEquals(petGroup, autoGeneratedProductCreationStrategy.getPetGroup());
	}
	
	@Test
	void getSeasonShouldReturnSeason() {
		Season season = Season.values()[1];
		when(random.nextInt(anyInt())).thenReturn(1);
		
		assertEquals(season, autoGeneratedProductCreationStrategy.getSeason());
	}
	
	@Test
	void getSizeShouldReturnSize() {
		Size size = Size.values()[1];
		when(random.nextInt(anyInt())).thenReturn(1);
		
		assertEquals(size, autoGeneratedProductCreationStrategy.getSize());
	}
	
	@Test
	void getIntShouldReturnInteger() {
		when(random.nextInt(anyInt())).thenReturn(10);
		
		assertEquals(10, autoGeneratedProductCreationStrategy.getInt());
	}
	
	@Test
	void getStringNameShouldReturnString() {
		mockWhenRandomNextInt();
		String stringOfElevenLetters = getStringOfElevenAlphabetLetters();
		
		assertEquals(stringOfElevenLetters, autoGeneratedProductCreationStrategy.getStringName());
	}
	
	@Test
	void getStringBrandNameShouldReturnString() {
		mockWhenRandomNextInt();
		String stringOfElevenLetters = getStringOfElevenAlphabetLetters();
		
		assertEquals(stringOfElevenLetters, autoGeneratedProductCreationStrategy.getStringBrandName());
	}
	
	@Test
	void getBigDecimalShouldReturnBigDecimal() {
		when(random.nextInt(anyInt())).thenReturn(10);
		BigDecimal result = new BigDecimal(BigInteger.valueOf(10), 2);
		
		assertEquals(result, autoGeneratedProductCreationStrategy.getBigDecimal());
	}
	
	private String getStringOfElevenAlphabetLetters() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i < 11; i++) {
			char letter = alphabet[i];
			stringBuilder.append(letter);
		}
		return stringBuilder.toString();
	}
	
	private void mockWhenRandomNextInt() {
		when(random.nextInt(anyInt()))
				.thenReturn(1)
				.thenReturn(2)
				.thenReturn(3)
				.thenReturn(4)
				.thenReturn(5)
				.thenReturn(6)
				.thenReturn(7)
				.thenReturn(8)
				.thenReturn(9)
				.thenReturn(10);
	}
}