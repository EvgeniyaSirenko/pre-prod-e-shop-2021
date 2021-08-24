package com.epam.preprod.sirenko.db;

import com.epam.preprod.sirenko.db.entity.DryFood;

/**
 * PetType entity.
 *
 * @author E.Sirenko
 *
 **/
public enum PetGroup {
	CAT, DOG, SMALL_PET;
	
	// not sure if I need this
	public String getName() {
		return name().toLowerCase();
	}
}
