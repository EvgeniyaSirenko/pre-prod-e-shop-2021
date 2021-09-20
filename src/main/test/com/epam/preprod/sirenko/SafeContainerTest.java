package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SafeContainerTest {
	
	@Test
	void shouldReturnSizeOfContainer() {
		SafeContainer<Product> container = new SafeContainer<>();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(food);
		container.add(dryFood);
		
		assertEquals(2, container.size());
	}
	
	@Test
	void shouldClearContainer() {
		SafeContainer<Product> container = new SafeContainer<>();
		Food food = new Food();
		container.add(food);
		
		container.clear();
		
		assertEquals(0, container.size());
	}
	
	@Test
	void shouldAddElementToContainer() {
		SafeContainer<Product> container = new SafeContainer<>();
		Food food = new Food();
		
		container.add(food);
		
		assertNotNull(container.get(0));
		assertEquals(container.get(0), food);
	}
	
	@Test
	void shouldAddElementToContainerByIndex() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		container.add(1, clothing);
		
		assertEquals(clothing, container.get(0));
		assertEquals(clothing, container.get(1));
		assertEquals(food, container.get(2));
		assertEquals(3, container.size());
	}
	
	@Test
	void shouldThrowExceptionWhenAddElementWithIndexIsOutOfBound() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			container.add(3, clothing);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldReturnArray() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		Product[] array = new Product[]{clothing, food};
		container.add(clothing);
		container.add(food);
		
		Object[] containerArray = container.toArray();
		
		assertArrayEquals(containerArray, array);
	}
	
	@Test
	void shouldReturnArrayOfGivenObjectsWhenArrayIsSmaller() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		Product[] array = new Product[]{clothing, food};
		container.add(clothing);
		container.add(food);
		container.add(food);
		
		Object[] containerArray = container.toArray(array);
		
		assertEquals(clothing, containerArray[0]);
		assertEquals(food, containerArray[1]);
		assertEquals(food, containerArray[2]);
	}
	
	@Test
	void toArrayShouldReturnArrayWhenGivenArrayIsEmpty() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		Product[] array = new Product[3];
		container.add(clothing);
		container.add(food);
		container.add(food);
		
		Object[] containerArray = container.toArray(array);
		
		assertEquals(clothing, containerArray[0]);
		assertEquals(food, containerArray[1]);
		assertEquals(food, containerArray[2]);
	}
	
	@Test
	void shouldReturnArrayOfGivenObjectsWhenArrayIsBigger() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		Product[] array = new Product[]{clothing, food, food};
		container.add(clothing);
		container.add(food);
		
		Object[] containerArray = container.toArray(array);
		
		assertNull(containerArray[2]);
		assertArrayEquals(containerArray, array);
	}
	
	@Test
	void shouldGetElementById() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Product product = container.get(0);
		
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldThrowExceptionWhenGetElementWithIndexIsOutOfBound() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			container.get(3);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldSetElementToContainerByIndex() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		container.set(1, clothing);
		
		assertNotNull(container.get(1));
		assertEquals(container.get(1), clothing);
	}
	
	@Test
	void shouldAddAllElements() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> expectedContainer = new SafeContainer<>();
		SafeContainer<Product> containerToAdd = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		containerToAdd.add(food);
		expectedContainer.add(clothing);
		expectedContainer.add(food);
		expectedContainer.add(food);
		
		container.addAll(containerToAdd);
		
		assertEquals(expectedContainer.size(), container.size());
	}
	
	@Test
	void shouldAddAllElementsFromCurrentIndex() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToAdd = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(food);
		container.add(food);
		containerToAdd.add(clothing);
		
		container.addAll(1, containerToAdd);
		assertEquals(food, container.get(0));
		assertEquals(clothing, container.get(1));
		assertEquals(food, container.get(2));
		assertEquals(3, container.size());
	}
	
	@Test
	void shouldReturnIndexOfFirstOccurrenceOfElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		container.add(clothing);
		container.add(food);
		
		int index = container.indexOf(food);
		
		assertEquals(1, index);
	}
	
	
	@Test
	void shouldReturnIndexOfFirstOccurrenceOfElementNull() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(null);
		container.add(clothing);
		container.add(food);
		
		int index = container.indexOf(null);
		
		assertEquals(1, index);
	}
	
	@Test
	void shouldReturnIndexOfFirstOccurrenceOfTheOnlyOneExistingElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		int index = container.indexOf(clothing);
		
		assertEquals(0, index);
	}
	
	@Test
	void shouldReturnIndexOfLastOccurrenceOfElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		container.add(clothing);
		container.add(food);
		
		int index = container.lastIndexOf(food);
		
		assertEquals(3, index);
	}
	
	@Test
	void shouldReturnIndexOfLastOccurrenceOfElementNull() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		container.add(clothing);
		container.add(null);
		
		int index = container.indexOf(null);
		
		assertEquals(3, index);
	}
	
	@Test
	void shouldReturnIndexOfLastOccurrenceOfTheOnlyOneExistingElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		int index = container.indexOf(clothing);
		
		assertEquals(0, index);
	}
	
	@Test
	void shouldRemoveElementByIndex() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		container.remove(0);
		
		assertEquals(container.get(0), food);
	}
	
	@Test
	void shouldRemoveTheOnlyOneExistedElementByIndex() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		container.remove(0);
		
		assertEquals(0, container.size());
	}
	
	@Test
	void shouldRemoveLastElementByIndex() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		container.remove(1);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			container.get(1);
		});
		assertEquals("Index: 1, Size: 1", exception.getMessage());
	}
	
	@Test
	void shouldThrowExceptionWhenRemoveElementWithIndexIsOutOfBound() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			container.remove(3);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldRemoveElementByFirstOccurrence() {
		SafeContainer<Product> container = new SafeContainer<>();
		DryFood dryFood = new DryFood();
		Clothing clothing = new Clothing();
		container.add(dryFood);
		container.add(clothing);
		container.add(dryFood);
		
		container.remove(dryFood);
		
		assertEquals(container.get(0), clothing);
	}
	
	
	@Test
	void shouldRemoveElementNullByFirstOccurrence() {
		SafeContainer<Product> container = new SafeContainer<>();
		DryFood dryFood = new DryFood();
		Clothing clothing = new Clothing();
		container.add(null);
		container.add(clothing);
		container.add(dryFood);
		
		container.remove(null);
		
		assertEquals(container.get(0), clothing);
	}
	
	@Test
	void shouldThrowExceptionWhenSetElementWithIndexIsOutOfBound() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			container.set(3, clothing);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void containsAllShouldReturnTrueIfContainsAllElements() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(clothing);
		container.add(food);
		container.add(dryFood);
		containerToCheck.add(food);
		containerToCheck.add(clothing);
		
		boolean result = container.containsAll(containerToCheck);
		
		assertEquals(clothing, container.get(0));
		assertEquals(clothing, containerToCheck.get(1));
		assertEquals(container.get(1), containerToCheck.get(0));
		assertTrue(result);
	}
	
	@Test
	void containsAllShouldReturnTrueIfContainsAllElementsWithNull() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(null);
		container.add(food);
		containerToCheck.add(null);
		containerToCheck.add(clothing);
		
		boolean result = container.containsAll(containerToCheck);
		
		assertEquals(containerToCheck.get(1), container.get(0));
		assertTrue(result);
	}
	
	@Test
	void containsAllShouldReturnTrueIfContainsOnlyOneExistingElements() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		containerToCheck.add(clothing);
		
		boolean result = container.containsAll(containerToCheck);
		
		assertTrue(result);
		assertEquals(containerToCheck.get(0), container.get(0));
		
	}
	
	@Test
	void containsAllShouldReturnFalseIfNotContainsAllElements() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(food);
		container.add(dryFood);
		containerToCheck.add(clothing);
		containerToCheck.add(dryFood);
		
		boolean result = container.containsAll(containerToCheck);
		
		assertNotEquals(clothing, container.get(0));
		assertNotEquals(clothing, container.get(1));
		assertFalse(result);
	}
	
	@Test
	void retainAllShouldReturnTrueIfContainsOnlyOneExistingElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Food food = new Food();
		container.add(food);
		containerToCheck.add(food);
		
		container.retainAll(containerToCheck);
		
		assertEquals(food, container.get(0));
	}
	
	@Test
	void retainAllShouldReturnTrueIfContainsElementsWithNullAndRemovesAllOther() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(null);
		container.add(food);
		containerToCheck.add(null);
		containerToCheck.add(clothing);
		
		container.retainAll(containerToCheck);
		
		assertEquals(clothing, container.get(0));
		assertNull(container.get(1));
		assertEquals(2, container.size());
	}
	
	@Test
	void retainAllShouldReturnTrueIfContainsElementsAndRemovesAllOther() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(food);
		container.add(clothing);
		container.add(dryFood);
		containerToCheck.add(clothing);
		containerToCheck.add(dryFood);
		
		container.retainAll(containerToCheck);
		
		assertEquals(clothing, container.get(0));
		assertEquals(dryFood, container.get(1));
		assertEquals(2, container.size());
	}
	
	@Test
	void retainAllShouldReturnTrueIfNotContainAllElementsAndRemovesAllOthers() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(food);
		container.add(food);
		container.add(clothing);
		containerToCheck.add(dryFood);
		containerToCheck.add(dryFood);
		
		container.retainAll(containerToCheck);
		
		assertEquals(0, container.size());
	}
	
	@Test
	void removeAllShouldReturnTrueIfContainsOnlyOneExistingElementAndRemoveIt() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		DryFood dryFood = new DryFood();
		container.add(dryFood);
		containerToCheck.add(dryFood);
		
		container.removeAll(containerToCheck);
		
		assertEquals(0, container.size());
	}
	
	@Test
	void removeAllShouldReturnTrueIfContainsElementsAndRemovesThem() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Food food = new Food();
		Clothing clothing = new Clothing();
		DryFood dryFood = new DryFood();
		container.add(dryFood);
		container.add(food);
		container.add(food);
		container.add(clothing);
		containerToCheck.add(clothing);
		containerToCheck.add(dryFood);
		
		container.removeAll(containerToCheck);
		
		assertEquals(food, container.get(0));
		assertEquals(food, container.get(1));
	}
	
	@Test
	void removeAllShouldReturnTrueIfContainsElementsWithNullAndRemovesThem() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(null);
		container.add(food);
		container.add(food);
		container.add(clothing);
		containerToCheck.add(clothing);
		containerToCheck.add(null);
		
		container.removeAll(containerToCheck);
		
		assertEquals(food, container.get(0));
		assertEquals(food, container.get(1));
		assertEquals(2, container.size());
	}
	
	@Test
	void removeAllShouldReturnFalseIfNotContainsElements() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Food food = new Food();
		Food food1 = new Food();
		Clothing clothing = new Clothing();
		DryFood dryFood = new DryFood();
		container.add(food);
		container.add(food1);
		containerToCheck.add(clothing);
		containerToCheck.add(dryFood);
		
		container.removeAll(containerToCheck);
		
		assertEquals(food, container.get(0));
		assertEquals(food1, container.get(1));
	}
	
	@Test
	void removeAllShouldReturnFalseIfNotContainsOnlyOneExistingElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		SafeContainer<Product> containerToCheck = new SafeContainer<>();
		Food food = new Food();
		Clothing clothing = new Clothing();
		container.add(clothing);
		containerToCheck.add(food);
		
		container.removeAll(containerToCheck);
		
		assertEquals(clothing, container.get(0));
	}
	
	@Test
	void shouldReturnNextElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		DryFood dryFood = new DryFood();
		Clothing clothing = new Clothing();
		container.add(dryFood);
		container.add(clothing);
		
		Product product = container.iterator().next();
		
		assertEquals(product, dryFood);
	}
	
	@Test
	void shouldReturnTheOnlyOneExistingNextElement() {
		SafeContainer<Product> container = new SafeContainer<>();
		DryFood dryFood = new DryFood();
		container.add(dryFood);
		
		Product product = container.iterator().next();
		
		assertEquals(product, dryFood);
	}
	
	@Test
	void shouldThrowNoSuchElementExceptionWhenNextElementNotExist() {
		SafeContainer<Product> container = new SafeContainer<>();
		
		Iterator<Product> iterator = container.iterator();
		
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}
	
	@Test
	void shouldReturnFalseWhenNextElementNotExist() {
		SafeContainer<Product> container = new SafeContainer<>();
		
		assertFalse(container.iterator().hasNext());
	}
	
	@Test
	void shouldReturnTrueIfHasNext() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		assertTrue(container.iterator().hasNext());
	}
	
	@Test
	void iteratorShouldUseUnchangedContainer() {
		SafeContainer<Product> container = new SafeContainer<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(clothing);
		container.add(food);
		container.add(dryFood);
		Iterator<Product> iterator = container.iterator();
		container.set(0, food);
		assertEquals(clothing, iterator.next());
		assertEquals(food, container.get(0));
	}
	
	@Test
	void listIteratorShouldThrowUnsupportedOperationException() {
		SafeContainer<Product> container = new SafeContainer<>();
		
		assertThrows(UnsupportedOperationException.class, () -> {
			container.listIterator();
		});
	}
	
	@Test
	void listIteratorWithIndexShouldThrowUnsupportedOperationException() {
		SafeContainer<Product> container = new SafeContainer<>();
		
		assertThrows(UnsupportedOperationException.class, () -> {
			container.listIterator(3);
		});
	}
	
	@Test
	void subListShouldThrowUnsupportedOperationException() {
		SafeContainer<Product> container = new SafeContainer<>();
		
		assertThrows(UnsupportedOperationException.class, () -> {
			container.subList(0, 0);
		});
	}
}