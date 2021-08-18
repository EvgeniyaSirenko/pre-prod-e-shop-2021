package com.epam.preprod.sirenko.entity;

import java.util.Objects;

/**
 * Food entity.
 *
 * @author E.Sirenko
 **/
public class Food extends Products {
	private int amount;
	private String petType;
	
	public Food() {
	}
	
	public Food(String name, int price, int foodAmount, String foodPetType) {
		super(name, price);
		amount = foodAmount;
		petType = foodPetType;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPetType() {
		return petType;
	}
	
	public void setPetType(String petType) {
		this.petType = petType;
	}
	
	@Override
	public String toString() {
		return "Food{" +
				"amount=" + amount +
				", petType='" + petType + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Food)) return false;
		if (!super.equals(o)) return false;
		Food food = (Food) o;
		return getAmount() == food.getAmount() && getPetType().equals(food.getPetType());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getAmount(), getPetType());
	}
}
