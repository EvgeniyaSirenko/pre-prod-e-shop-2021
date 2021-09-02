package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
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
	void get() {
	}
	
	@Test
	void remove() {
	}
	
	@Test
	void testRemove() {
	}
	
	@Test
	void iterator() {
	}
	
}