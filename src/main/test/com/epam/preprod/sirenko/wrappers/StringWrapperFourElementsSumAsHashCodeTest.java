package com.epam.preprod.sirenko.wrappers;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.wrappers.StringWrapperFourElementsSumAsHashCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringWrapperFourElementsSumAsHashCodeTest {
	
	private static Food food;
	private static Food otherFood;
	private static DryFood dryFood;
	private static DryFood otherDryFood;
	private static Map<StringWrapperFourElementsSumAsHashCode, Product> hashMap;
	private static Map<StringWrapperFourElementsSumAsHashCode, Product> linkedHashMap;
	private static StringWrapperFourElementsSumAsHashCode abracadabra;
	private static StringWrapperFourElementsSumAsHashCode blabla;
	private static StringWrapperFourElementsSumAsHashCode anotherBlabla;
	private static StringWrapperFourElementsSumAsHashCode moonlight;
	private static StringWrapperFourElementsSumAsHashCode moon;
	private static StringWrapperFourElementsSumAsHashCode hooray;
	
	@BeforeAll
	static void setData() {
		hashMap = new HashMap<>();
		linkedHashMap = new LinkedHashMap<>();
		setupWrapper();
		setupProduct();
	}
	
	private static void setupProduct() {
		food = new Food("GoodFood", BigDecimal.valueOf(30), 10);
		otherFood = new Food("NormalFood", BigDecimal.valueOf(50), 20);
		dryFood = new DryFood("SuperFood", BigDecimal.valueOf(40), 30, "Brit", PetGroup.CAT);
		otherDryFood = new DryFood("VeryGoodFood", BigDecimal.valueOf(60), 40, "Royal", PetGroup.DOG);
	}
	
	private static void setupWrapper() {
		abracadabra = new StringWrapperFourElementsSumAsHashCode("abracadabra");
		blabla = new StringWrapperFourElementsSumAsHashCode("blabla");
		anotherBlabla = new StringWrapperFourElementsSumAsHashCode("blabla");
		moonlight = new StringWrapperFourElementsSumAsHashCode("moonlight");
		moon = new StringWrapperFourElementsSumAsHashCode("moon");
		hooray = new StringWrapperFourElementsSumAsHashCode("hooray");
	}
	
	@Test
	void testHashCodeShouldCalculateHashCode() {
		int result = abracadabra.hashCode();
		
		assertEquals(406, result);
	}
	
	@Test
	void testHashCodeShouldCalculateDifferentHashCode() {
		int result = blabla.hashCode();
		
		assertEquals(401, result);
	}
	
	@Test
	void testHashCodeShouldCalculateSameHashCode() {
		int moonlightHashCode = moonlight.hashCode();
		int moonHashCode = moon.hashCode();
		
		assertEquals(moonlightHashCode, moonHashCode);
	}
	
	@Test
	void testEqualsShouldReturnTrueIfObjectsEqualAndHashCodesEqual() {
		int blablaHashCode = blabla.hashCode();
		int anotherBlablaHashCode = anotherBlabla.hashCode();
		
		assertEquals(blablaHashCode, anotherBlablaHashCode);
		assertEquals(blabla, anotherBlabla);
	}
	
	@Test
	void testEqualsShouldReturnFalseIfObjectsNotEqualIfHashCodesEqualOrNot() {
		int blablaHashCode = blabla.hashCode();
		int hoorayHashCode = hooray.hashCode();
		
		assertNotEquals(blablaHashCode, hoorayHashCode);
		assertNotEquals(blabla, hooray);
	}
	
	@Test
	void testEqualsAndHashCodeShouldIterateDifferentHashMapAndLinkedHashMap() {
		setupHashMap();
		setupLinkedHashMap();
		Iterator<StringWrapperFourElementsSumAsHashCode> hashMapIterator = hashMap.keySet().iterator();
		Iterator<StringWrapperFourElementsSumAsHashCode> linkedHashMapIterator = linkedHashMap.keySet().iterator();

		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
	}
	
	private void setupLinkedHashMap() {
		linkedHashMap.put(abracadabra, food);
		linkedHashMap.put(blabla, otherFood);
		linkedHashMap.put(moonlight, dryFood);
		linkedHashMap.put(hooray, otherDryFood);
	}
	
	private void setupHashMap() {
		hashMap.put(abracadabra, food);
		hashMap.put(blabla, otherFood);
		hashMap.put(moonlight, dryFood);
		hashMap.put(hooray, otherDryFood);
	}
}