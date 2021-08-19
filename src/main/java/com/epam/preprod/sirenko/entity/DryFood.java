package com.epam.preprod.sirenko.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * DryFood entity.
 *
 * @author E.Sirenko
 **/
public class DryFood extends Food {
	private String brandName;
	private int petGroupId;
	
	public DryFood() {
	}
	
	public DryFood(String name, BigDecimal price, int foodWeight, String dryFoodBrandName, int dryFoodPetGroupId) {
		super(name, price, foodWeight);
		brandName = dryFoodBrandName;
		petGroupId = dryFoodPetGroupId;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public int getPetGroupId() {
		return petGroupId;
	}
	
	public void setPetGroupId(int petGroupId) {
		this.petGroupId = petGroupId;
	}
	
	@Override
	public String toString() {
		return "DryFood{" +
				"brandName='" + brandName + '\'' +
				", petGroupId=" + petGroupId +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DryFood)) return false;
		if (!super.equals(o)) return false;
		DryFood dryFood = (DryFood) o;
		return getPetGroupId() == dryFood.getPetGroupId() && getBrandName().equals(dryFood.getBrandName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getBrandName(), getPetGroupId());
	}
}
