package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringLengthAsHashCodeWrapperTest {
	private static Food food;
	private static Food otherFood;
	private static DryFood dryFood;
	private static DryFood otherDryFood;
	private static Map<StringLengthAsHashCodeWrapper, Product> hashMap;
	private static Map<StringLengthAsHashCodeWrapper, Product> linkedHashMap;
	private static StringLengthAsHashCodeWrapper abracadabra;
	private static StringLengthAsHashCodeWrapper blabla;
	private static StringLengthAsHashCodeWrapper anotherBlabla;
	private static StringLengthAsHashCodeWrapper moonlight;
	private static StringLengthAsHashCodeWrapper hooray;
	
	
	@BeforeAll
	static void setData() {
		hashMap = new HashMap<>();
		linkedHashMap = new LinkedHashMap<>();
		abracadabra = new StringLengthAsHashCodeWrapper("abracadabra");
		blabla = new StringLengthAsHashCodeWrapper("blabla");
		anotherBlabla = new StringLengthAsHashCodeWrapper("blabla");
		moonlight = new StringLengthAsHashCodeWrapper("moonlight");
		hooray = new StringLengthAsHashCodeWrapper("hooray");
		food = new Food("GoodFood", BigDecimal.valueOf(30), 10);
		otherFood = new Food("NormalFood", BigDecimal.valueOf(50), 20);
		dryFood = new DryFood("SuperFood", BigDecimal.valueOf(40), 30, "Brit", PetGroup.CAT);
		otherDryFood = new DryFood("VeryGoodFood", BigDecimal.valueOf(60), 40, "Royal", PetGroup.DOG);
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
		hashMap.put(abracadabra, food);
		hashMap.put(blabla, otherFood);
		hashMap.put(moonlight, dryFood);
		hashMap.put(hooray, otherDryFood);
		Iterator<StringLengthAsHashCodeWrapper> hashMapIterator = hashMap.keySet().iterator();
		linkedHashMap.put(abracadabra, food);
		linkedHashMap.put(blabla, otherFood);
		linkedHashMap.put(moonlight, dryFood);
		linkedHashMap.put(hooray, otherDryFood);
		Iterator<StringLengthAsHashCodeWrapper> linkedHashMapIterator = linkedHashMap.keySet().iterator();
		
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
		assertNotEquals(hashMap.get(hashMapIterator.next()), linkedHashMap.get(linkedHashMapIterator.next()));
	}

}