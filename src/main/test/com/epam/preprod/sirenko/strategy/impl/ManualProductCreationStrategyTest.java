package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ManualProductCreationStrategyTest {
	private ManualProductCreationStrategy manualProductCreation;
	private PetGroup petGroup;
	
	@BeforeEach
	public void SetData() {
		manualProductCreation = mock(ManualProductCreationStrategy.class);
		petGroup = PetGroup.CAT;
	}
	
	@Test
	void getPetGroup() {
		when(manualProductCreation.getPetGroup()).thenReturn(petGroup);
		
		assertEquals(PetGroup.CAT, manualProductCreation.getPetGroup());
		
	}
	
	@Test
	void getSeason() {
		when(manualProductCreation.getSeason()).thenReturn(Season.WINTER);
		
		assertEquals(Season.WINTER, manualProductCreation.getSeason());
	}
	
	@Test
	void getSize() {
		when(manualProductCreation.getSize()).thenReturn(Size.S);
		
		assertEquals(Size.S, manualProductCreation.getSize());
	}
	
	@Test
	void getStringName() {
		when(manualProductCreation.getStringName()).thenReturn("Name");
		
		assertEquals("Name", manualProductCreation.getStringName());
	}
	
	@Test
	void getStringBrandName() {
		when(manualProductCreation.getStringBrandName()).thenReturn("Brand");
		
		assertEquals("Brand", manualProductCreation.getStringBrandName());
	}
	
	@Test
	void getInt() {
		when(manualProductCreation.getInt()).thenReturn(1);
		
		assertEquals(1, manualProductCreation.getInt());
	}
	
	@Test
	void getBigDecimal() {
		when(manualProductCreation.getBigDecimal()).thenReturn(BigDecimal.ONE);
		
		assertEquals(BigDecimal.valueOf(1), manualProductCreation.getBigDecimal());
	}
}