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
	
	@Test
	void shouldAddElementToContainer() {
		Container<Product> container = new Container<>();
		Food food = new Food();
		
		container.add(food);
		
		Product product = container.get(0);
		assertNotNull(container.get(0));
		assertEquals(product, food);
	}
	
	
	@Test
	void shouldAddElementToContainerWithCapacity() {
		Container<Product> container = new Container<>(5);
		Food food = new Food();
		
		container.add(food);
		
		Product product = container.get(0);
		assertNotNull(container.get(0));
		assertEquals(product, food);
	}
	
	@Test
	void shouldAddElementToContainerByIndex() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		container.add(1, clothing);
		
		Product product = container.get(1);
		assertNotNull(container.get(1));
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldAddElementToContainerWithCapacityByIndex() {
		Container<Product> container = new Container<>(5);
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		container.add(1, clothing);
		
		Product product = container.get(1);
		assertNotNull(container.get(1));
		assertEquals(product, clothing);
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
		Container<Product> container = new Container<>(5);
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
	void shouldRemoveElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Food food = new Food();
		
		container.add(clothing);
		container.add(food);
		container.remove(0);
		
		Product product = container.get(0);
		assertEquals(product, food);
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
		
		Product product = container.get(0);
		assertEquals(product, clothing);
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
		
		assertEquals(iterator.next(), clothing);
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
		
		assertThrows(NoSuchElementException.class, ()-> {
			iterator.next();
		});
	}
	
	
	@Test
	void shouldThrowNoSuchElementExceptionWhenNextElementOnConditionNotExist() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Predicate<Product> predicate = x -> x.equals(clothing);
		Iterator<Product> iterator = container.iterator(predicate);
		
		assertThrows(NoSuchElementException.class, ()-> {
			iterator.next();
		});
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
	
}