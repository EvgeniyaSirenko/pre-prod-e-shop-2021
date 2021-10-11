package com.epam.preprod.sirenko.dao;

import com.epam.preprod.sirenko.entity.Clothing;
import com.epam.preprod.sirenko.entity.DryFood;
import com.epam.preprod.sirenko.entity.Food;
import com.epam.preprod.sirenko.entity.Product;
import com.epam.preprod.sirenko.enums.PetGroup;
import com.epam.preprod.sirenko.enums.Season;
import com.epam.preprod.sirenko.enums.Size;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOTest {
	private static NavigableMap<Timestamp, Map<Product, Integer>> orders = new TreeMap<>();
	private static Map<Product, Integer> cart1;
	private static Map<Product, Integer> cart2;
	private static Map<Product, Integer> cart3;
	private static Food food;
	private static Clothing clothing;
	private static DryFood dryFood;
	private static Timestamp creationDate;
	private static Timestamp otherCreationDate;
	private static Timestamp outOfPeriodCreationDate;
	private static Timestamp fromDate;
	private static Timestamp toDate;
	
	@BeforeAll
	static void setupData() {
		cart1 = new HashMap<>();
		cart2 = new HashMap<>();
		cart3 = new HashMap<>();
		food = new Food("food", BigDecimal.valueOf(10), 20);
		clothing = new Clothing("clothing", BigDecimal.valueOf(20), Size.S, Season.WINTER);
		dryFood = new DryFood("dryFood", BigDecimal.valueOf(30), 40, "Brit", PetGroup.DOG);
		cart1.put(food,1);
		cart2.put(clothing, 1);
		cart3.put(dryFood, 1);
		creationDate = Timestamp.valueOf("2021-09-23 10:00:00");
		otherCreationDate = Timestamp.valueOf("2021-09-25 10:00:00");
		outOfPeriodCreationDate = Timestamp.valueOf("2021-09-28 10:00:00");
		fromDate = Timestamp.valueOf("2021-09-20 10:00:00");
		toDate = Timestamp.valueOf("2021-09-27 10:00:00");
	}
	
	@Test
	void testMakeOrderShouldAddCartToOrdersMap() {
		OrderDAO orderDAO = new OrderDAO();
		
		orderDAO.makeOrder(creationDate, cart1);
		
		assertEquals(1, orderDAO.getOrdersListOfCurrentPeriod(fromDate, toDate).size());
	}
	
	@Test
	void testGetOrdersListOfCurrentPeriodShouldGetOrdersOfCurrentPeriod() {
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.makeOrder(creationDate, cart1);
		orderDAO.makeOrder(otherCreationDate, cart2);
		orderDAO.makeOrder(outOfPeriodCreationDate, cart3);
		
		assertEquals(2, orderDAO.getOrdersListOfCurrentPeriod(fromDate, toDate).size());
	}
	
	@Test
	void testGetOrdersClosestToDateShouldGetOrderWithClosestDate() {
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.makeOrder(creationDate, cart1);
		orderDAO.makeOrder(outOfPeriodCreationDate, cart2);
	
		assertEquals(cart1, orderDAO.getOrdersClosestToDate(otherCreationDate));
	}
}