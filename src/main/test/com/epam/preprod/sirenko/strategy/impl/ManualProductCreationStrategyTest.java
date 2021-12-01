package com.epam.preprod.sirenko.strategy.impl;

import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import com.epam.preprod.sirenko.util.ConsoleReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManualProductCreationStrategyTest {
	private PrintStream outMock;
	
	@InjectMocks
	@Spy
	private ManualProductCreationStrategy manualProductCreationStrategy;
	
	@Mock
	private ConsoleReader consoleReader;
	
	@BeforeEach
	public void SetData() {
		outMock = mock(PrintStream.class);
		System.setOut(outMock);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void getPetGroupShouldReturnPetGroup() throws IOException {
		doNothing().when(manualProductCreationStrategy).printPetGroupElements();
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("CAT");

		assertEquals(PetGroup.CAT, manualProductCreationStrategy.getPetGroup());
	}
	
	@Test
	void getSeasonShouldReturnSeason() throws IOException {
		doNothing().when(manualProductCreationStrategy).printSeasonElements();
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("WINTER");
		
		assertEquals(Season.WINTER, manualProductCreationStrategy.getSeason());
	}
	
	@Test
	void getSizeShouldReturnSize() throws IOException {
		doNothing().when(manualProductCreationStrategy).printSizeElements();
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("S");
		
		assertEquals(Size.S, manualProductCreationStrategy.getSize());
	}

	@Test
	void getStringNameShouldReturnString() throws IOException {
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("NewName");

		assertEquals("NewName", manualProductCreationStrategy.getStringName());
	}
	
	@Test
	void getStringBrandNameShouldReturnString() throws IOException {
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("Brand");
		
		assertEquals("Brand", manualProductCreationStrategy.getStringBrandName());
	}
	
	@Test
	void getIntShouldReturnInteger() throws IOException {
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("100");
		
		assertEquals(100, manualProductCreationStrategy.getInt());
	}
	
	@Test
	void getBigDecimalShouldReturnBigDecimal() throws IOException {
		doNothing().when(outMock).println();
		when(consoleReader.readFromConsole()).thenReturn("40.50");
		BigDecimal result = new BigDecimal("40.50");
		
		assertEquals(result, manualProductCreationStrategy.getBigDecimal());
	}
}