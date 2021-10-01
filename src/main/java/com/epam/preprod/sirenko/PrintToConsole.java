package com.epam.preprod.sirenko;

import com.epam.preprod.sirenko.entity.Product;

import java.util.List;
import java.util.Map;

public class PrintToConsole {
	
	private PrintToConsole() {
	}
	
	public static void printString(String string) {
		System.out.println(string);
	}
	
	public static void printList(List<Product> list) {
		for(Object o : list) {
			System.out.println(o);
		}
	}
	public static void printMap(Map<Product, Integer> map) {
		System.out.println(map.entrySet());
	}
	
	public static void printInstruction() {
		PrintToConsole.printString("--------------------------------------------------");
		PrintToConsole.printString("Print out and press Enter to exit program");
		PrintToConsole.printString("Print products and press Enter to see all available products");
		PrintToConsole.printString("Print product name and press Enter to add product to cart");
		PrintToConsole.printString("Print cart and press Enter to see your cart");
		PrintToConsole.printString("Print order and press Enter to make an order");
		PrintToConsole.printString("Print last and press Enter to see 5 last added to cart products");
		PrintToConsole.printString("--------------------------------------------------");
	}
}
