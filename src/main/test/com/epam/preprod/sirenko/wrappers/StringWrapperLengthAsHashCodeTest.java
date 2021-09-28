package com.epam.preprod.sirenko.wrappers;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.wrappers.StringWrapperLengthAsHashCode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringWrapperLengthAsHashCodeTest {
	private static Food food;
	private static Food otherFood;
	private static DryFood dryFood;
	private static DryFood otherDryFood;
	private static Map<StringWrapperLengthAsHashCode, Product> hashMap;
	private static Map<StringWrapperLengthAsHashCode, Product> linkedHashMap;
	private static StringWrapperLengthAsHashCode abracadabra;
	private static StringWrapperLengthAsHashCode blabla;
	private static StringWrapperLengthAsHashCode anotherBlabla;
	private static StringWrapperLengthAsHashCode moonlight;
	private static StringWrapperLengthAsHashCode hooray;
	
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
		abracadabra = new StringWrapperLengthAsHashCode("abracadabra");
		blabla = new StringWrapperLengthAsHashCode("blabla");
		anotherBlabla = new StringWrapperLengthAsHashCode("blabla");
		moonlight = new StringWrapperLengthAsHashCode("moonlight");
		hooray = new StringWrapperLengthAsHashCode("hooray");
	}
	
	@Test
	void testHashCodeShouldCalculateHashCode() {
		int result = hooray.hashCode();
		
		assertEquals(6, result);
	}
	
	@Test
	void testHashCodeShouldCalculateSameHashCode() {
		int result = blabla.hashCode();
		
		assertEquals(6, result);
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
		
		assertEquals(blablaHashCode, hoorayHashCode);
		assertNotEquals(blabla, hooray);
	}
	
	@Test
	void testEqualsAndHashCodeShouldIterateDifferentHashMapAndLinkedHashMap() {
		setupHashMap();
		setupLinkedHashMap();
		Iterator<StringWrapperLengthAsHashCode> hashMapIterator = hashMap.keySet().iterator();
		Iterator<StringWrapperLengthAsHashCode> linkedHashMapIterator = linkedHashMap.keySet().iterator();
		
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
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