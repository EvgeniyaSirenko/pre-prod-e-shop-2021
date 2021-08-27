import com.epam.preprod.sirenko.Container;
import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
	
	@Test
	void add() {
		Container<Product> container = new Container<>();
		Clothing clothing = new Clothing();
		
		container.add(clothing);
		
		Product p1 = container.get(0);
		assertNotNull(container.get(0));
		assertEquals(p1, clothing);
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