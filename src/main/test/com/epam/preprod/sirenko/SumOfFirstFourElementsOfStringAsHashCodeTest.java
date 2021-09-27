package com.epam.preprod.sirenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumOfFirstFourElementsOfStringAsHashCodeTest {
	
	@Test
	void testHashCode() {
		SumOfFirstFourElementsOfStringAsHashCode sumOfFirstFourElementsOfStringAsHashCode = new SumOfFirstFourElementsOfStringAsHashCode();
		sumOfFirstFourElementsOfStringAsHashCode.setKey("abracadabra");
		
		int result = sumOfFirstFourElementsOfStringAsHashCode.hashCode();
		
		assertEquals(406, result);
	}
	@Test
	void testHashCodeShouldCalculateHashCode() {
		SumOfFirstFourElementsOfStringAsHashCode sumOfFirstFourElementsOfStringAsHashCode = new SumOfFirstFourElementsOfStringAsHashCode();
		sumOfFirstFourElementsOfStringAsHashCode.setKey("cadabra");
		
		int result = sumOfFirstFourElementsOfStringAsHashCode.hashCode();
		
		assertEquals(393, result);
	}
}