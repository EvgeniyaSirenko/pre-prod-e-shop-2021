package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
	private static final int CAPACITY = 5;
	
	@Test
	void shouldReturnSizeOfContainer() {
		Container<Product> container = new Container<>();
		Food food = new Food();
		DryFood dryFood = new DryFood();
		container.add(food);
		container.add(dryFood);
		
		assertEquals(2, container.size());
	}
	
	@Test
	void shouldClearContainer() {
		Container<Product> container = new Container<>();
		Food food = new Food();
		container.add(food);
		
		container.clear();
		
		assertEquals(0, container.size());
	}
	
	@Test
	void shouldAddElementToContainer() {
		Container<Product> container = new Container<>();
		Food food = new Food();
		
		container.add(food);
		
		assertNotNull(container.get(0));
		assertEquals(container.get(0), food);
	}
	
	
	@Test
	void shouldAddElementToContainerWithCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
		Food food = new Food();
		
		container.add(food);
		
		assertNotNull(container.get(0));
		assertEquals(container.get(0), food);
	}
	
	@Test
	void shouldAddElementToContainerByIndex() {
		Container<Product> container = new Container<>();
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
	void shouldAddElementToContainerWithCapacityByIndex() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		container.add(1, clothing);
		
		assertNotNull(container.get(1));
		assertEquals(container.get(1), clothing);
	}
	
	@Test
	void shouldThrowExceptionWhenAddElementWithIndexIsOutOfBound() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.add(3, clothing);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	@Test
	void shouldThrowExceptionWhenAddElementWithIndexIsOutOfBoundOfContainerWithCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.add(3, clothing);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void isEmptyShouldReturnTrueIfSizeIsZero() {
		Container<Product> container = new Container<>(CAPACITY);

		assertEquals(0, container.size());
	}
	
	@Test
	void isEmptyShouldReturnFalseIfSizeIsNotZero() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		assertFalse(container.isEmpty());
	}
	
	@Test
	void shouldReturnTrueIfContainsElement() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		assertEquals(clothing, container.get(0));
		assertEquals(food, container.get(1));
	}
	
	@Test
	void shouldReturnFalseIfNotContainsElement() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		
		assertNotEquals(food, container.get(0));
		assertFalse(container.contains(food));
	}
	
	@Test
	void shouldReturnArray() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		Product[] array = new Product[]{clothing, food};
		container.add(clothing);
		container.add(food);
		
		Object[] containerArray = container.toArray();
		
		assertArrayEquals(containerArray, array);
	}
	
	@Test
	void shouldReturnArrayWithCurrentCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
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
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
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
	void shouldReturnArrayOfGivenObjectsWithCurrentCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		Food food = new Food();
		Product[] array = new Product[]{clothing, food};
		container.add(clothing);
		container.add(food);
		
		Object[] containerArray = container.toArray(array);
		
		assertArrayEquals(containerArray, array);
	}
	
	@Test
	void shouldGetElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Product product = container.get(0);
		
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldThrowExceptionWhenGetElementWithIndexIsOutOfBound() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.get(3);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldSetElementToContainerByIndex() {
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToAdd = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		containerToAdd.add(food);
		
		container.addAll(containerToAdd);
		
		assertEquals(3, container.size());
		assertEquals(clothing, container.get(0));
		assertEquals(food, container.get(1));
		assertEquals(food, container.get(2));
	}
	
	@Test
	void shouldAddAllElementsWithCurrentCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
		Container<Product> containerToAdd = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		containerToAdd.add(food);
		
		container.addAll(containerToAdd);

		assertEquals(3, container.size());
		assertEquals(clothing, container.get(0));
		assertEquals(food, container.get(1));
		assertEquals(food, container.get(2));
	}
	
	@Test
	void shouldAddAllElementsFromCurrentIndex() {
		Container<Product> container = new Container<>();
		Container<Product> containerToAdd = new Container<>();
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
	void shouldAddAllElementsFromCurrentIndexWithCurrentCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
		Container<Product> expectedContainer = new Container<>();
		Container<Product> containerToAdd = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		containerToAdd.add(food);
		expectedContainer.add(clothing);
		expectedContainer.add(food);
		expectedContainer.add(food);
		
		container.addAll(0, containerToAdd);
		
		assertEquals(expectedContainer.size(), container.size());
	}
	
	@Test
	void shouldReturnIndexOfFirstOccurrenceOfElement() {
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
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
	void shouldReturnIndexOfFirstOccurrenceOfElementWithCurrentCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
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
	void shouldReturnIndexOfFirstOccurrenceOfTheOnlyOneExistingElement() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		int index = container.indexOf(clothing);
		
		assertEquals(0, index);
	}
	
	@Test
	void shouldReturnIndexOfLastOccurrenceOfElement() {
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
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
	void shouldReturnIndexOfLastOccurrenceOfElementWithCurrentCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
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
	void shouldReturnIndexOfLastOccurrenceOfTheOnlyOneExistingElement() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		int index = container.indexOf(clothing);
		
		assertEquals(0, index);
	}
	
	@Test
	void shouldReturnIndexOfLastOccurrenceOfTheOnlyOneExistingElementWithCapacity() {
		Container<Product> container = new Container<>(CAPACITY);
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		int index = container.indexOf(clothing);
		
		assertEquals(0, index);
	}
	
	@Test
	void shouldRemoveElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		container.remove(0);
		
		assertEquals(container.get(0), food);
	}
	
	@Test
	void shouldRemoveTheOnlyOneExistedElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		container.remove(0);
		
		assertEquals( 0, container.size());
	}
	
	@Test
	void shouldRemoveLastElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		container.remove(1);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.get(1);
		});
		assertEquals("Index: 1, Size: 1", exception.getMessage());
	}
	
	@Test
	void shouldThrowExceptionWhenRemoveElementWithIndexIsOutOfBound() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.remove(3);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldRemoveElementByFirstOccurrence() {
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
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
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		container.add(clothing);
		container.add(food);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.set(3, clothing);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}

	@Test
	void containsAllShouldReturnTrueIfContainsAllElements() {
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		containerToCheck.add(clothing);
		
		boolean result = container.containsAll(containerToCheck);
		
		assertTrue(result);
		assertEquals(containerToCheck.get(0), container.get(0));

	}

	@Test
	void containsAllShouldReturnFalseIfNotContainsAllElements() {
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
		Food food = new Food();
		container.add(food);
		containerToCheck.add(food);
		
		container.retainAll(containerToCheck);
		
		assertEquals(food, container.get(0));
	}
	
	@Test
	void retainAllShouldReturnTrueIfContainsElementsWithNullAndRemovesAllOther() {
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
		DryFood dryFood = new DryFood();
		container.add(dryFood);
		containerToCheck.add(dryFood);
		
		container.removeAll(containerToCheck);
		
		assertEquals(0, container.size());
	}

	@Test
	void removeAllShouldReturnTrueIfContainsElementsAndRemovesThem() {
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
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
		Container<Product> container = new Container<>();
		Container<Product> containerToCheck = new Container<>();
		Food food = new Food();
		Clothing clothing = new Clothing();
		container.add(clothing);
		containerToCheck.add(food);

		container.removeAll(containerToCheck);
		
		assertEquals(clothing, container.get(0));
	}
	
	@Test
	void shouldReturnNextElement() {
		Container<Product> container = new Container<>();
		DryFood dryFood = new DryFood();
		Clothing clothing = new Clothing();
		container.add(dryFood);
		container.add(clothing);
		
		Product product = container.iterator().next();
		
		assertEquals(product, dryFood);
	}
	
	@Test
	void shouldReturnNextElementOnCondition() {
		Container<Product> container = new Container<>();
		DryFood dryFood = new DryFood();
		Clothing clothing = new Clothing();
		Predicate<Product> predicate = x -> x.equals(clothing);
		Iterator<Product> iterator = container.iterator(predicate);
		container.add(dryFood);
		container.add(clothing);
		
		Product product = iterator.next();
		
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldReturnTheOnlyOneExistingNextElement() {
		Container<Product> container = new Container<>();
		DryFood dryFood = new DryFood();
		container.add(dryFood);
		
		Product product = container.iterator().next();
		
		assertEquals(product, dryFood);
	}
	
	@Test
	void shouldThrowNoSuchElementExceptionWhenNextElementNotExist() {
		Container<Product> container = new Container<>();
		
		Iterator<Product> iterator = container.iterator();
		
		assertThrows(NoSuchElementException.class, iterator::next);
	}
	
	@Test
	void shouldThrowNoSuchElementExceptionWhenNextElementOnConditionNotExist() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Predicate<Product> predicate = x -> x.equals(clothing);
		
		Iterator<Product> iterator = container.iterator(predicate);
		
		assertThrows(NoSuchElementException.class, iterator::next);
	}
	
	@Test
	void shouldReturnFalseWhenNextElementNotExist() {
		Container<Product> container = new Container<>();
		
		assertFalse(container.iterator().hasNext());
	}
	
	@Test
	void shouldReturnFalseWhenNextElementOnConditionNotExist() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Predicate<Product> predicate = x -> x.equals(clothing);
		Iterator<Product> iterator = container.iterator(predicate);
		
		assertFalse(iterator.hasNext());
	}
	
	@Test
	void shouldReturnTrueIfHasNext() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		container.add(clothing);
		
		assertTrue(container.iterator().hasNext());
	}
	
	@Test
	void shouldReturnTrueIfHasNextElementOnConditionWhenOnlyOneExists() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		clothing.setSize(Size.S);
		clothing.setSeason(Season.WINTER);
		Predicate<Product> predicate = x -> x.equals(clothing);
		Iterator<Product> iterator = container.iterator(predicate);
		container.add(clothing);
		
		assertTrue(iterator.hasNext());
	}
	
	@Test
	void shouldReturnTrueIfHasNextElementOnCondition() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		DryFood dryFood = new DryFood();
		dryFood.setPetGroup(PetGroup.CAT);
		Predicate<Product> predicate = x -> x.equals(dryFood);
		Iterator<Product> iterator = container.iterator(predicate);
		container.add(clothing);
		container.add(dryFood);
		
		assertTrue(iterator.hasNext());
	}
	
	@Test
	void listIteratorShouldThrowUnsupportedOperationException() {
		Container<Product> container = new Container<>();
		
		assertThrows(UnsupportedOperationException.class, container::listIterator);
	}
	
	@Test
	void listIteratorWithIndexShouldThrowUnsupportedOperationException() {
		Container<Product> container = new Container<>();
		
		assertThrows(UnsupportedOperationException.class, ()-> {
			container.listIterator(3);
		});
	}
	
	@Test
	void subListShouldThrowUnsupportedOperationException() {
		Container<Product> container = new Container<>();
		
		assertThrows(UnsupportedOperationException.class, ()-> {
			container.subList(0, 0);
		});
	}
}