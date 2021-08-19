package com.epam.preprod.sirenko.entity;

/**
 * Size entity.
 *
 * @author E.Sirenko
 *
 **/
public enum Size {
	S, M, L, XL, XXL;
	
	public static Size getSize(Clothing clothing) {
		int sizeId = clothing.getSizeId();
		return Size.values()[sizeId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
}
