package com.epam.preprod.sirenko.entity;

/**
 * Season entity.
 *
 * @author E.Sirenko
 **/
public enum Season {
	WINTER, SPRING_AUTUMN;
	
	public static Season getSeason(Clothing clothing) {
		int seasonId = clothing.getSeasonId();
		return Season.values()[seasonId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
}
