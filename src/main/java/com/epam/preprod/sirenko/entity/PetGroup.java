package com.epam.preprod.sirenko.entity;

/**
 * PetType entity.
 *
 * @author E.Sirenko
 *
 **/
public enum PetGroup {
	CAT, DOG, SMALL_PET;
	
	public static PetGroup getPetGroup(DryFood dryFood) {
		int petGroupId = dryFood.getPetGroupId();
		return PetGroup.values()[petGroupId];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
}
