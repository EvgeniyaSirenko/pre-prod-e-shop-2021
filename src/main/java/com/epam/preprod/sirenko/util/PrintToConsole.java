package com.epam.preprod.sirenko.util;

import com.epam.preprod.sirenko.entity.Product;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintToConsole {
	
	private PrintToConsole() {
	}
	
	public static void printString(String string) {
		System.out.println(string);
	}
	
	public static void printBigDecimal(BigDecimal bigDecimal) {
		System.out.println(bigDecimal);
	}
	
	public static void printList(List<Product> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}
	public static void printCartMap(Map<Product, Integer> map) {
		System.out.println(map.entrySet());
	}
	
	public static void printSet(Set<String> set) {
		System.out.println(set);
	}
	
	public static void printOrderMap(Map<Timestamp, Map<Product, Integer>> map) {
		System.out.println(map.entrySet());
	}
	
}
