package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Product;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
	
	//create container and add elements to it before all?
	
	@Test
	void shouldAddElementToContainer() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		
		container.add(clothing);
		
		Product product = container.get(0);
		assertNotNull(container.get(0));
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldAddElementToContainerByIndex() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		container.add(1, clothing);
		
		Product product = container.get(1);
		assertNotNull(container.get(1));
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldThrowExceptionWhenAddElementWithIndexIsOutOfBound() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.add(3, clothing);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldGetElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		
		Product product = container.get(0);
		assertEquals(product, clothing);
	}
	
	@Test
	void shouldThrowExceptionWhenGetElementWithIndexIsOutOfBound() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, ()-> {
			container.get(3);
		});
		assertEquals("Index: 3, Size: 2", exception.getMessage());
	}
	
	@Test
	void shouldRemoveElementById() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		container.remove(0);
		
		Product product = container.get(0);
		assertEquals(product, clothing1);
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
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
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
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		
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
		Clothing clothing1 = new Clothing();
		
		container.add(clothing);
		container.add(clothing1);
		
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
		
		Iterator iterator = container.iterator();
		
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
	void shouldReturnTrueIfHasNext() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		
		container.add(clothing);
		
		assertTrue(container.iterator().hasNext());
	}
	
}