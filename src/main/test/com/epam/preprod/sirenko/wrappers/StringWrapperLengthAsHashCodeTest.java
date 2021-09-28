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
	
	private static StringWrapperLengthAsHashCode setupWrappers(String key) {
		return new StringWrapperLengthAsHashCode(key);
	}
	
	private static Food setupFoods(String name, BigDecimal price, int weight) {
		return new Food(name, price, weight);
	}
	
	private static DryFood setupDryFoods(String name, BigDecimal price, int weight, String brandName, PetGroup petGroup) {
		return new DryFood(name, price, weight, brandName, petGroup);
	}
	
	private void setupMap(Map<StringWrapperLengthAsHashCode, Product> map, StringWrapperLengthAsHashCode key, Product value) {
		map.put(key, value);
	}
	
	@BeforeAll
	static void setData() {
		hashMap = new HashMap<>();
		linkedHashMap = new LinkedHashMap<>();
		abracadabra = setupWrappers("abracadabra");
		blabla = setupWrappers("blabla");
		anotherBlabla = setupWrappers("blabla");
		moonlight = setupWrappers("moonlight");
		hooray = setupWrappers("hooray");
		food = setupFoods("GoodFood", BigDecimal.valueOf(30), 10);
		otherFood = setupFoods("NormalFood", BigDecimal.valueOf(50), 20);
		dryFood = setupDryFoods("SuperFood", BigDecimal.valueOf(40), 30, "Brit", PetGroup.CAT);
		otherDryFood = setupDryFoods("VeryGoodFood", BigDecimal.valueOf(60), 40, "Royal", PetGroup.DOG);
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
		setupMap(hashMap, abracadabra, food);
		setupMap(hashMap, blabla, otherFood);
		setupMap(hashMap, moonlight, dryFood);
		setupMap(hashMap, hooray, otherDryFood);
		setupMap(linkedHashMap, abracadabra, food);
		setupMap(linkedHashMap, blabla, otherFood);
		setupMap(linkedHashMap, moonlight, dryFood);
		setupMap(linkedHashMap, hooray, otherDryFood);
		Iterator<StringWrapperLengthAsHashCode> hashMapIterator = hashMap.keySet().iterator();
		Iterator<StringWrapperLengthAsHashCode> linkedHashMapIterator = linkedHashMap.keySet().iterator();
		
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
	}
}