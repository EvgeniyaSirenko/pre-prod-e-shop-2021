package com.epam.preprod.sirenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringLengthAsHashCodeTest {
	
	@Test
	void testHashCode() {
		StringLengthAsHashCode stringLengthAsHashCode = new StringLengthAsHashCode();
		stringLengthAsHashCode.setKey("abracadabra");
		
		int result = stringLengthAsHashCode.hashCode();
		assertEquals(11, result);
	}
	
	@Test
	void testHashCodeShouldCalculateHashCode() {
		StringLengthAsHashCode stringLengthAsHashCode = new StringLengthAsHashCode();
		stringLengthAsHashCode.setKey("cadabra");
		
		int result = stringLengthAsHashCode.hashCode();
		assertEquals(7, result);
	}
}