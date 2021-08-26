package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import org.junit.jupiter.api.Test;

import static com.epam.preprod.sirenko.enums.Season.WINTER;
import static com.epam.preprod.sirenko.enums.Size.S;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
	
	@Test
	void add() {
		Container container = new Container();
		Clothing clothing = new Clothing();
		clothing.setSeason(WINTER);
		clothing.setSize(S);
		clothing.setName("jacket");
		container.add(clothing);
		Product p1 = container.get(0);
		assertEquals(p1.getName(), "jacket");
		assertNotNull(container.get(0));
	}
	
	@Test
	void testAdd() {

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