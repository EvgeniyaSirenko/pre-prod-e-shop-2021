package com.epam.preprod.sirenko.services.impl;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SerializeProductsByDefaultAndGZipTest {
	private static final String FILE_NAME = "test.txt";
	private static final String FILE_GZ = "test.gz";
	private File file;
	private File fileGZip;
	private ArrayList<Product> allProducts;
	private Food food;
	private Clothing clothing;
	private DryFood dryFood;
	private FileOutputStream fileOutputStream;
	private ObjectOutputStream objectOutputStream;
	
	@BeforeEach
	void setData() throws IOException {
		file = new File(FILE_NAME);
		fileGZip = new File(FILE_GZ);
		allProducts = new ArrayList<>();
		food = new Food("food", BigDecimal.valueOf(10), 20);
		clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		dryFood = new DryFood("dryFood", BigDecimal.valueOf(30), 40, "Brit", PetGroup.DOG);
		allProducts.add(food);
		allProducts.add(clothing);
		allProducts.add(dryFood);
		file.deleteOnExit();
		fileGZip.deleteOnExit();
	}
	
	private void setUpObjectOutputStream(File fileName) throws IOException {
		fileOutputStream = new FileOutputStream(fileName);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		int currentTimes = 3;
		for (int i = 0; i < currentTimes; i++) {
			objectOutputStream.writeObject(allProducts);
		}
	}
	
	@Test
	void shouldSaveProductsListToThreadCurrentTimes() throws IOException {
		setUpObjectOutputStream(file);
		
		assertTrue(file.exists());
		assertEquals(1182, file.length());
	}
	
	@Test
	void shouldSaveProductsListAsGZip() throws IOException {
		setUpObjectOutputStream(fileGZip);
		
		assertTrue(fileGZip.exists());
		assertEquals(1182, fileGZip.length());
	}
}