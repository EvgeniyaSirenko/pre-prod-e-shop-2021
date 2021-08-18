package com.epam.preprod.sirenko.entity;

import java.util.Objects;

/**
 * DryFood entity.
 *
 * @author E.Sirenko
 **/
public class DryFood extends Food {
	private int petAge;
	private int petWeight;
	private String brand;
	
	public DryFood() {
	}
	
	public DryFood(String name, int price, int foodAmount, String foodPetType, int dryFoodPetAge, int dryFoodPetWeight, String dryFoodBrand) {
		super(name, price, foodAmount, foodPetType);
		petAge = dryFoodPetAge;
		petWeight = dryFoodPetWeight;
		brand = dryFoodBrand;
	}
	
	public int getPetAge() {
		return petAge;
	}
	
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	public int getPetWeight() {
		return petWeight;
	}
	
	public void setPetWeight(int petWeight) {
		this.petWeight = petWeight;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "DryFood{" +
				"petAge=" + petAge +
				", petWeight=" + petWeight +
				", brand='" + brand + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DryFood)) return false;
		if (!super.equals(o)) return false;
		DryFood dryFood = (DryFood) o;
		return getPetAge() == dryFood.getPetAge() && getPetWeight() == dryFood.getPetWeight() && getBrand()
				.equals(dryFood.getBrand());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getPetAge(), getPetWeight(), getBrand());
	}
}
