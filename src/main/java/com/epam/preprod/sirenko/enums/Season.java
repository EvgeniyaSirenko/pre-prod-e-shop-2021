package com.epam.preprod.sirenko.enums;

/**
 * Season entity.
 *
 * @author E.Sirenko
 **/
public enum Season {
	WINTER, SPRING_AUTUMN;
	
	// not sure if I need this
	public String getName() {
		return name().toLowerCase();
	}
}
