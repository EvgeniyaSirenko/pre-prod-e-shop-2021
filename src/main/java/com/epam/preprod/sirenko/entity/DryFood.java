package com.epam.preprod.sirenko.entity;

import com.epam.preprod.sirenko.enums.PetGroup;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * DryFood entity.
 *
 * @author E.Sirenko
 **/
public class DryFood extends Food {
	private String brandName;
	private PetGroup petGroup;
	
	public DryFood() {
	}
	
	public DryFood(String name, BigDecimal price, int foodWeight, String dryFoodBrandName, PetGroup dryFoodPetGroup) {
		super(name, price, foodWeight);
		this.brandName = dryFoodBrandName;
		this.petGroup = dryFoodPetGroup;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public PetGroup getPetGroup() {
		return petGroup;
	}
	
	public void setPetGroup(PetGroup petGroup) {
		this.petGroup = petGroup;
	}
	
	@Override
	public String toString() {
		return "DryFood{" +
				"brandName='" + brandName + '\'' +
				", petGroup=" + petGroup +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DryFood)) return false;
		if (!super.equals(o)) return false;
		DryFood dryFood = (DryFood) o;
		return getBrandName().equals(dryFood.getBrandName()) && getPetGroup() == dryFood.getPetGroup();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getBrandName(), getPetGroup());
	}
}
