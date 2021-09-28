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
	
	private static StringWrapperFourElementsSumAsHashCode setupWrappers(String key) {
		return new StringWrapperFourElementsSumAsHashCode(key);
	}
	
	private static Food setupFoods(String name, BigDecimal price, int weight) {
		return new Food(name, price, weight);
	}
	
	private static DryFood setupDryFoods(String name, BigDecimal price, int weight, String brandName, PetGroup petGroup) {
		return new DryFood(name, price, weight, brandName, petGroup);
	}
	
	private void setupMap(Map<StringWrapperFourElementsSumAsHashCode, Product> map, StringWrapperFourElementsSumAsHashCode key, Product value) {
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
		moon = setupWrappers("moon");
		hooray = setupWrappers("hooray");
		food = setupFoods("GoodFood", BigDecimal.valueOf(30), 10);
		otherFood = setupFoods("NormalFood", BigDecimal.valueOf(50), 20);
		dryFood = setupDryFoods("SuperFood", BigDecimal.valueOf(40), 30, "Brit", PetGroup.CAT);
		otherDryFood = setupDryFoods("VeryGoodFood", BigDecimal.valueOf(60), 40, "Royal", PetGroup.DOG);
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
		setupMap(hashMap, abracadabra, food);
		setupMap(hashMap, blabla, otherFood);
		setupMap(hashMap, moonlight, dryFood);
		setupMap(hashMap, hooray, otherDryFood);
		setupMap(linkedHashMap, abracadabra, food);
		setupMap(linkedHashMap, blabla, otherFood);
		setupMap(linkedHashMap, moonlight, dryFood);
		setupMap(linkedHashMap, hooray, otherDryFood);
		Iterator<StringWrapperFourElementsSumAsHashCode> hashMapIterator = hashMap.keySet().iterator();
		Iterator<StringWrapperFourElementsSumAsHashCode> linkedHashMapIterator = linkedHashMap.keySet().iterator();

		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
	}
}