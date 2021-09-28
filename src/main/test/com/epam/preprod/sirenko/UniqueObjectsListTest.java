package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.enums.PetGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UniqueObjectsListTest {
	private static Food food;
	private static Food otherFood;
	private static DryFood dryFood;
	private static DryFood otherDryFood;
	
	@BeforeAll
	static void setData() {
		food = new Food("GoodFood", BigDecimal.valueOf(30), 10);
		otherFood = new Food("NormalFood", BigDecimal.valueOf(50), 20);
		dryFood = new DryFood("SuperFood", BigDecimal.valueOf(40), 30, "Brit", PetGroup.CAT);
		otherDryFood = new DryFood("VeryGoodFood", BigDecimal.valueOf(60), 40, "Royal", PetGroup.DOG);
	}
	
	@Test
	void testAddShouldAddElementIfNotInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(dryFood);
		
		assertEquals(2, uniqueObjectsList.size());
	}
	
	@Test
	void testAddShouldThrowExceptionWhenElementAlreadyInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		
		uniqueObjectsList.add(food);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			uniqueObjectsList.add(food);
		});
		assertEquals("Can't add such element", exception.getMessage());
	}
	
	@Test
	void testAddShouldAddElementByIndexIfNotInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(0, dryFood);
		
		assertEquals(2, uniqueObjectsList.size());
		assertEquals(dryFood, uniqueObjectsList.get(0));
		assertEquals(food, uniqueObjectsList.get(1));
	}
	
	@Test
	void testAddShouldThrowExceptionWhenElementByIndexAlreadyInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		
		uniqueObjectsList.add(food);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			uniqueObjectsList.add(0, food);
		});
		assertEquals("Can't add such element", exception.getMessage());
	}
	
	@Test
	void testSetShouldSetElementIfNotInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(dryFood);
		
		uniqueObjectsList.set(0, otherFood);
		
		assertEquals(otherFood, uniqueObjectsList.get(0));
		assertEquals(dryFood, uniqueObjectsList.get(1));
	}
	
	@Test
	void testSetShouldThrowExceptionWhenElementAlreadyInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		
		uniqueObjectsList.add(food);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			uniqueObjectsList.set(0, food);
		});
		assertEquals("Can't add such element", exception.getMessage());
	}
	
	@Test
	void testAddAllShouldAddElementsIfNotInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		UniqueObjectsList uniqueObjectsListToAdd = new UniqueObjectsList();
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(dryFood);
		uniqueObjectsListToAdd.add(otherDryFood);
		uniqueObjectsListToAdd.add(otherFood);
		
		uniqueObjectsList.addAll(uniqueObjectsListToAdd);
		
		assertEquals(4, uniqueObjectsList.size());
		assertEquals(food, uniqueObjectsList.get(0));
		assertEquals(dryFood, uniqueObjectsList.get(1));
		assertEquals(otherDryFood, uniqueObjectsList.get(2));
		assertEquals(otherFood, uniqueObjectsList.get(3));
	}
	
	@Test
	void testAddAllShouldThrowExceptionWhenElementsAlreadyInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		UniqueObjectsList uniqueObjectsListToAdd = new UniqueObjectsList();
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(dryFood);
		uniqueObjectsList.add(otherFood);
		uniqueObjectsListToAdd.add(food);
		uniqueObjectsListToAdd.add(dryFood);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			uniqueObjectsList.addAll(uniqueObjectsListToAdd);
		});
		assertEquals("Can't add such elements", exception.getMessage());
	}
	
	@Test
	void testAddAllShouldAddElementsByIndexIfNotInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		UniqueObjectsList uniqueObjectsListToAdd = new UniqueObjectsList();
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(dryFood);
		uniqueObjectsListToAdd.add(otherDryFood);
		uniqueObjectsListToAdd.add(otherFood);
		
		uniqueObjectsList.addAll(1, uniqueObjectsListToAdd);
		
		assertEquals(4, uniqueObjectsList.size());
		assertEquals(food, uniqueObjectsList.get(0));
		assertEquals(otherDryFood, uniqueObjectsList.get(1));
		assertEquals(otherFood, uniqueObjectsList.get(2));
		assertEquals(dryFood, uniqueObjectsList.get(3));
	}
	
	@Test
	void testAddAllShouldThrowExceptionWhenElementsByIndexAlreadyInList() {
		UniqueObjectsList uniqueObjectsList = new UniqueObjectsList();
		UniqueObjectsList uniqueObjectsListToAdd = new UniqueObjectsList();
		uniqueObjectsList.add(food);
		uniqueObjectsList.add(dryFood);
		uniqueObjectsList.add(otherFood);
		uniqueObjectsListToAdd.add(food);
		uniqueObjectsListToAdd.add(dryFood);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			uniqueObjectsList.addAll(2, uniqueObjectsListToAdd);
		});
		assertEquals("Can't add such elements", exception.getMessage());
	}
}