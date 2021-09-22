package com.epam.preprod.sirenko;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TwoListWrapperTest {
	private static final List<Object> UNMODIFIED_EMPTY_LIST = new ArrayList<>();
	private static final List<Object> UNMODIFIED_LIST = new ArrayList<>(List.of("Hello", 1, "good"));
	private List<Object> modifiedList = new ArrayList<>();
	
	@Test
	void sizeShouldReturnSizeOfList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		assertEquals(5, twoListWrapper.size());
	}
	
	@Test
	void isEmptyShouldReturnTrueIfSizeIsZero() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_EMPTY_LIST, modifiedList);
		
		assertTrue(twoListWrapper.isEmpty());
		assertEquals(0, twoListWrapper.size());
	}
	
	@Test
	void isEmptyShouldReturnFalseIfSizeIsNotZero() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		assertFalse(twoListWrapper.isEmpty());
		assertNotEquals(0, twoListWrapper.size());
	}
	
	@Test
	void containsShouldReturnTrueIfContainsElement() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		assertTrue(twoListWrapper.contains("Hello"));
		assertEquals("Hello", twoListWrapper.get(0));
	}
	
	@Test
	void toArrayShouldReturnArrayOfList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		Object[] objects = new Object[]{"Hello", 1, "good", "fella", "!"};
		
		Object[] twoListWrapperArray = twoListWrapper.toArray();
		
		assertArrayEquals(twoListWrapperArray, objects);
	}
	
	@Test
	void toArrayShouldReturnArrayOfGivenArray() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		Object[] objects = new Object[]{"This", 1, "good", "idea"};
		
		Object[] twoListWrapperArray = twoListWrapper.toArray(objects);
		
		assertEquals("Hello", twoListWrapperArray[0]);
		assertEquals(1, twoListWrapperArray[1]);
		assertEquals("good", twoListWrapperArray[2]);
		assertEquals("fella", twoListWrapperArray[3]);
		assertEquals("!", twoListWrapperArray[4]);
	}
	
	@Test
	void toArrayShouldReturnArrayOfGivenEmptyArray() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		Object[] objects = new Object[]{5};
		
		Object[] twoListWrapperArray = twoListWrapper.toArray(objects);
		
		assertEquals("Hello", twoListWrapperArray[0]);
		assertEquals(1, twoListWrapperArray[1]);
		assertEquals("good", twoListWrapperArray[2]);
		assertEquals("fella", twoListWrapperArray[3]);
		assertEquals("!", twoListWrapperArray[4]);
	}
	
	@Test
	void toArrayShouldReturnArrayOfGivenBiggerArray() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		Object[] objects = new Object[]{"This", "is", "a", 1, "good", "idea"};
		
		Object[] twoListWrapperArray = twoListWrapper.toArray(objects);
		
		assertArrayEquals(twoListWrapperArray, objects);
		assertNull(twoListWrapperArray[5]);
	}
	
	@Test
	void addShouldAddElementToModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		twoListWrapper.add("fella");
		
		assertNotNull(twoListWrapper.get(3));
		assertEquals("fella", twoListWrapper.get(5));
	}
	
	@Test
	void removeShouldRemoveElementByFirstOccurrence() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		twoListWrapper.add("fella");
		
		twoListWrapper.remove("fella");
		
		assertEquals("!", twoListWrapper.get(3));
		assertEquals(5, twoListWrapper.size());
	}
	
	@Test
	void removeShouldThrowExceptionWhenRemoveElementIsInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.remove("Hello");
		});
		assertEquals("Can't remove element to unmodified list", exception.getMessage());
	}
	
	@Test
	void clearShouldClearModifiedListOnly() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		twoListWrapper.clear();
		
		assertEquals(0, modifiedList.size());
		assertEquals(3, twoListWrapper.size());
	}
	
	@Test
	void setShouldSetElementToModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		twoListWrapper.set(4, "?");
		
		assertEquals("?", twoListWrapper.get(4));
		assertEquals(5, twoListWrapper.size());
	}
	
	@Test
	void setShouldThrowExceptionWhenIndexIsInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.set(0, "Hi");
		});
		assertEquals("Can't set element to unmodified list", exception.getMessage());
	}
	
	@Test
	void addShouldAddElementByIndexToModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		twoListWrapper.add(4, "?");
		
		assertEquals("?", twoListWrapper.get(4));
		assertEquals("!", twoListWrapper.get(5));
		assertEquals(6, twoListWrapper.size());
	}
	
	@Test
	void addShouldThrowExceptionWhenIndexIsInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.add(0, "Hi");
		});
		assertEquals("Can't add element to unmodified list", exception.getMessage());
	}
	
	@Test
	void removeShouldRemoveElementByIndexFromModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		twoListWrapper.remove(3);
		
		assertEquals("good", twoListWrapper.get(2));
		assertEquals("!", twoListWrapper.get(3));
		assertEquals(4, twoListWrapper.size());
	}
	
	@Test
	void removeShouldThrowExceptionWhenIndexIsInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.remove(0);
		});
		assertEquals("Can't remove element to unmodified list", exception.getMessage());
	}
	
	@Test
	void indexOfShouldReturnIndexOfElement() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		
		assertEquals(3, twoListWrapper.indexOf("fella"));
		assertEquals(2, twoListWrapper.indexOf("good"));
	}
	
	@Test
	void lastIndexOfShouldReturnIndexOfElement() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("fella");
		
		assertEquals(4, twoListWrapper.lastIndexOf("fella"));
		assertEquals(2, twoListWrapper.lastIndexOf("good"));
	}
	
	@Test
	void addAllShouldAddElementToModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		List<String> listToAdd = new ArrayList<>();
		listToAdd.add("fella");
		listToAdd.add("is");
		
		twoListWrapper.addAll(listToAdd);
		
		assertEquals("fella", twoListWrapper.get(3));
		assertEquals("is", twoListWrapper.get(4));
		assertEquals(5, twoListWrapper.size());
		assertEquals(2, modifiedList.size());
	}
	
	@Test
	void containsAllShouldReturnTrueIfContainsAllElements() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		List<String> list = new ArrayList<>();
		list.add("good");
		list.add("fella");
		
		boolean result = twoListWrapper.containsAll(list);
		
		assertTrue(result);
		assertEquals(list.get(0), twoListWrapper.get(2));
		assertEquals(list.get(1), twoListWrapper.get(3));
	}
	
	@Test
	void containsAllShouldReturnFalseIfNotContainsAllElements() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		List<String> list = new ArrayList<>();
		list.add("good");
		list.add("fella");
		list.add("oops");
		
		boolean result = twoListWrapper.containsAll(list);
		
		assertFalse(result);
		assertNotEquals(list.get(2), twoListWrapper.get(0));
		assertNotEquals(list.get(2), twoListWrapper.get(1));
		assertNotEquals(list.get(2), twoListWrapper.get(2));
		assertNotEquals(list.get(2), twoListWrapper.get(3));
		assertNotEquals(list.get(2), twoListWrapper.get(4));
	}
	
	@Test
	void addAllByIndexShouldAddElementToModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		List<String> listToAdd = new ArrayList<>();
		listToAdd.add("fella");
		listToAdd.add("is");
		
		twoListWrapper.addAll(3, listToAdd);
		
		assertEquals("fella", twoListWrapper.get(3));
		assertEquals("is", twoListWrapper.get(4));
		assertEquals("fella", twoListWrapper.get(5));
		assertEquals(6, twoListWrapper.size());
		assertEquals(3, modifiedList.size());
	}
	
	@Test
	void addAllShouldThrowExceptionWhenIndexIsInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		List<String> listToAdd = new ArrayList<>();
		listToAdd.add("hi");
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.addAll(0, listToAdd);
		});
		assertEquals("Can't add element to unmodified list", exception.getMessage());
	}
	
	@Test
	void removeAllShouldRemoveElementsFromModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		List<String> listToRemove = new ArrayList<>();
		listToRemove.add("fella");
		
		twoListWrapper.removeAll(listToRemove);
		
		assertEquals("!", twoListWrapper.get(3));
		assertEquals(4, twoListWrapper.size());
	}
	
	@Test
	void removeAllShouldThrowExceptionWhenElementInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		List<String> listToRemove = new ArrayList<>();
		listToRemove.add("Hello");
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.removeAll(listToRemove);
		});
		assertEquals("Can't remove collection from unmodified list", exception.getMessage());
	}
	
	@Test
	void retainAllShouldRemoveElementsNotInCollectionFromModifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		modifiedList.add("fella");
		modifiedList.add("!");
		List<Object> listToRetain = new ArrayList<>();
		listToRetain.add("fella");
		listToRetain.add("Hello");
		listToRetain.add(1);
		listToRetain.add("good");
		
		twoListWrapper.retainAll(listToRetain);
		
		assertEquals("fella", twoListWrapper.get(3));
		assertEquals(4, twoListWrapper.size());
	}
	
	@Test
	void retainAllShouldThrowExceptionWhenElementNotInUnmodifiedList() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		List<String> listToRemove = new ArrayList<>();
		listToRemove.add("fella");
		
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			twoListWrapper.retainAll(listToRemove);
		});
		assertEquals("Can't retain collection of unmodified list", exception.getMessage());
	}
	
	@Test
	void listIteratorShouldThrowUnsupportedOperationException() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		assertThrows(UnsupportedOperationException.class, twoListWrapper::listIterator);
	}
	
	@Test
	void listIteratorWithIndexShouldThrowUnsupportedOperationException() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		assertThrows(UnsupportedOperationException.class, () -> {
			twoListWrapper.listIterator(3);
		});
	}
	
	@Test
	void subListShouldThrowUnsupportedOperationException() {
		TwoListWrapper<Object> twoListWrapper = new TwoListWrapper<>(UNMODIFIED_LIST, modifiedList);
		
		assertThrows(UnsupportedOperationException.class, () -> {
			twoListWrapper.subList(0, 0);
		});
	}
}