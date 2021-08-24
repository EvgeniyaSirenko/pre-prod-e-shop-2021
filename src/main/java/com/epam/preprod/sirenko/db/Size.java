package com.epam.preprod.sirenko.db;

import com.epam.preprod.sirenko.db.entity.Clothing;

/**
 * Size entity.
 *
 * @author E.Sirenko
 *
 **/
public enum Size {
	S, M, L, XL, XXL;
	
	// not sure if I need this
	public String getName() {
		return name().toLowerCase();
	}
}
